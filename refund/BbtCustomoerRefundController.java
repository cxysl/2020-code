package com.bbt.oper.controller.promote.refund;

import com.aliyun.ots.thirdparty.org.apache.entity.ContentType;
import com.bbt.common.framework.tmc.TmcManager;
import com.bbt.common.util.CsvUtil;
import com.bbt.common.util.DateUtil;
import com.bbt.common.util.StringUtil;
import com.bbt.oper.controller.promote.refund.been.RefundDownQuery;
import com.bbt.oper.controller.promote.refund.been.RefundQuery;
import com.bbt.oper.model.result.BbtCustomerRefundModel;
import com.bbt.oper.mybatis.domain.BbtCustomer;
import com.bbt.oper.mybatis.domain.BbtCustomerRefund;
import com.bbt.oper.mybatis.domain.BbtCustomerRefundExample;
import com.bbt.oper.service.crm.impl.BbtCrmOrderOperServiceImpl;
import com.bbt.oper.service.refund.BbtCustomoerRefundService;
import com.bbt.oper.service.sms.CustomerService;
import com.bbt.oper.util.ExcelReader;
import com.bbt.oper.web.dto.JsonDTO;
import com.bbt.taobao.api.service.JushitaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 获取客户退款信息
 * @author 世林
 */
@RestController
@RequestMapping("/refund")
public class BbtCustomoerRefundController {

    private static Log LOG = LogFactory.getLog(BbtCrmOrderOperServiceImpl.class);

    @Resource
    BbtCustomoerRefundService bbtCustomoerRefundService;
    //用户表
    @Resource
    private CustomerService customerService;

    @Autowired
    private JushitaService jushitaService;


    /**
     * 条件查询
     * 无参    http://localhost:8080/refund/getAllCustomoerRefund.get
     * 页码    http://localhost:8080/refund/getAllCustomoerRefund.get?pageNo=2
     * 所有参数    http://localhost:8080/refund/getAllCustomoerRefund.get?sellerNick=00000a6543&startTime=2020-06-01 00:00:00&endTime=2020-06-10 00:00:00&pageNo=1&pageSize=10
     *
     */
    @RequestMapping(value = "/getAllCustomoerRefund.get")
    public JsonDTO getAllRefund( String sellerNick,String startTime,String endTime,Integer pageNo,Integer pageSize){

        RefundQuery query = new RefundQuery();  //参数对象
        BbtCustomerRefundExample example = new BbtCustomerRefundExample();
        BbtCustomerRefundExample.Criteria criteria =example.createCriteria();

        if(!StringUtil.isEmpty(sellerNick)){
            query.setSellerNick(sellerNick);
            criteria.andSellerNickEqualTo(query.getSellerNick());
        }
        if(!StringUtil.isEmpty(startTime)){
            query.setStartTime(startTime);
            criteria.andRefundOperationTimeGreaterThan(DateUtil.parseDate(query.getStartTime()));
        }
        if(!StringUtil.isEmpty(endTime)){
            query.setEndTime(endTime);
            criteria.andRefundOperationTimeLessThan(DateUtil.parseDate(query.getEndTime()));
        }
        if(pageNo!=null&&pageNo!=0){
            query.setPageNo(pageNo);
        } else query.setPageNo(1);

        if(pageSize!=null&&pageSize!=0){
            query.setPageSize(pageSize);
        } else query.setPageSize(10);
        PageInfo<BbtCustomerRefund> bbtCustomerRefunds =
                PageHelper.startPage((query.getPageNo()), (query.getPageSize()))
                        .doSelectPageInfo(() -> bbtCustomoerRefundService.selectByExample(example));

        return JsonDTO.createInstance().setData(bbtCustomerRefunds).setStatus(JsonDTO.SUCCESS).setMsg("请求处理成功");
    }

    /**
     *生成CSV(下载)
     *       http://localhost:8080/refund/getRefundExcel.post
     *       http://localhost:8080/refund/getRefundExcel.post?sellerNick=00陈小雨
     *       http://localhost:8080/refund/getRefundExcel.post?endTime=2020-06-10 00:00:00
     *       http://localhost:8080/refund/getRefundExcel.post?startTime=2020-06-01 00:00:00&endTime=2020-06-10 00:00:00
     *       http://localhost:8080/refund/getRefundExcel.post?sellerNick=00000a6543&startTime=2020-06-01 00:00:00&endTime=2020-06-10 00:00:00
     *
     */
    @RequestMapping(value = "/getRefundExcel.post")
    public JsonDTO downExcel( String sellerNick,String startTime,String endTime,HttpServletRequest request, HttpServletResponse response){
        RefundDownQuery query = new RefundDownQuery();
        BbtCustomerRefundExample example = new BbtCustomerRefundExample();
        BbtCustomerRefundExample.Criteria criteria =example.createCriteria();

        if(!StringUtil.isEmpty(sellerNick)){
            query.setSellerNick(sellerNick);
            criteria.andSellerNickEqualTo(query.getSellerNick());
        }
        if(!StringUtil.isEmpty(startTime)){
            query.setStartTime(startTime);
            criteria.andRefundOperationTimeGreaterThan(DateUtil.parseDate(query.getStartTime()));
        }
        if(!StringUtil.isEmpty(endTime)){
            query.setEndTime(endTime);
            criteria.andRefundOperationTimeLessThan(DateUtil.parseDate(query.getEndTime()));
        }
        List<BbtCustomerRefund> bbtCustomerRefunds = bbtCustomoerRefundService.selectByExample(example);
        List<BbtCustomerRefundModel> models= new ArrayList<>();
        bbtCustomerRefunds.parallelStream().forEach((r)->{
            BbtCustomerRefundModel model=new BbtCustomerRefundModel();
            model.setId(r.getId());
            model.setSellerNick(r.getSellerNick());
            model.setServiceOrderId(r.getServiceOrderId());
            if(r.getRefundMoney()!=null){
                model.setRefundMoney(r.getRefundMoney());
            }else{
                BigDecimal bd = new BigDecimal(0);
                model.setRefundMoney(bd);
            }
            model.setAlipayTradeId(r.getAlipayTradeId());
            model.setAlipayName(r.getAlipayName());
            model.setAlipayAccount(r.getAlipayAccount());
            model.setApplyTime(r.getApplyTime());
            model.setOperator(r.getOperator());
            model.setRefundOperationTime(r.getRefundOperationTime());
            model.setDeadLine(r.getDeadLine());
            model.setReason(r.getReason());
            model.setRemarks(r.getRemarks());
            model.setCreatTime(r.getCreatTime());
            model.setDeadLine(r.getRelieveTime());
            model.setLoginFlag(r.getLoginFlag());
            model.setStatus(r.getStatus());

            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            if (r.getApplyTime()!=null) {       //如果时间为空对象，将字符串赋空值，否则导入excel报错
                model.setApplyTimeStr(sdf.format(r.getApplyTime()));
            }else{
                model.setApplyTimeStr("");
            }
            if (r.getRefundOperationTime()!=null) {
                model.setRefundOperationTimeStr(sdf.format(r.getRefundOperationTime()));
            }else{
                model.setRefundOperationTimeStr("");
            }
            if (r.getRelieveTime()!=null) {
                model.setRelieveTimeStr(sdf.format(r.getRelieveTime()));
            }else{
                model.setRelieveTimeStr("");
            }
            models.add(model);
        });

        String[] title = new String[] {"店铺昵称", "服务市场订单号", "支付宝名称", "支付宝账号","申请退款时间","实际完成退款时间", "退款金额(元)","支付宝流水号","退款原因","操作人"
                ,"解除限制时间","备注"};
        List<String[]> content = new ArrayList<String[]>();
        content.add(title);
        if(models!=null && models.size()>0){
            for (BbtCustomerRefundModel model : models) {
                List<String> list = new ArrayList<String>();
                list.add(model.getSellerNick());
                list.add(model.getServiceOrderId());
                list.add(model.getAlipayName());
                list.add(model.getAlipayAccount());
                list.add(model.getApplyTimeStr());
                list.add(model.getRefundOperationTimeStr());
                list.add(model.getRefundMoney().toString());
                list.add(model.getAlipayTradeId());
                list.add(model.getReason());
                list.add(model.getOperator());
                list.add(model.getRelieveTimeStr());
                list.add(model.getRemarks());

                String[] result = new String[list.size()];
                content.add(list.toArray(result));
            }
        }
        String filename = "customerRefund_" +new Date().getTime()+ ".csv";
//        String path =request.getSession().getServletContext().getRealPath("/assets")+ "\\" + filename;
        String path =filename;
        FileInputStream inputStream = null;
        OutputStream out = null;
        File file = null;
        try {
            file = new File(path);
            CsvUtil.writerCsvFile(file, content);
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment" + ";filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\"");
            byte[] bytes = new byte[(int) file.length()];
            inputStream = new FileInputStream(file);
            out = response.getOutputStream();
            out.write(bytes, 0, inputStream.read(bytes));
        } catch (Exception e) {
            LOG.warn("download csv io error ! " ,e);
            return JsonDTO.createInstance().setData("download csv io error ! ").setStatus(JsonDTO.FAIL).setMsg("请求处理失败") ;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (file != null && file.exists()) {
                file.delete();
            }
        }

        return JsonDTO.createInstance().setData("导出文件成功").setStatus(JsonDTO.SUCCESS).setMsg("请求处理成功");
    }


    /**
     * 表格导入
     *      http://localhost:8080/refund/importRefundTable.post
     */
    @PostMapping(value = "/importRefundTable.post")
//    public JsonDTO importRefundExcel()throws Exception{
    public JsonDTO importRefundExcel(@RequestParam("file") MultipartFile file)throws Exception{
//        MultipartFile file = this.getMultipartFile(new File("C:\\Users\\admin\\Downloads\\支付宝退款记录（bboss）(1).xlsx"));

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        String[] filedNames = new String[] { "sellerNick","serviceOrderId","alipayName","alipayAccount","applyTime","refundOperationTime","refundMoney","alipayTradeId","reason","operator","remarks"};

        List<BbtCustomerRefund> refunds = new ExcelReader<BbtCustomerRefund>(file.getInputStream())
                .setClazz(BbtCustomerRefund.class)
                .parseToList(0,1,filedNames,null);

        List<BbtCustomerRefund> failRefunds = new ArrayList<BbtCustomerRefund>();
        Date date = new Date();
        for (BbtCustomerRefund b : refunds) {
            BbtCustomer customer = new BbtCustomer();
            customer = customerService.getCustomerByNick(b.getSellerNick());       //两表nick关联

            if (customer==null){
                b.setRemarks("用户未登录过!");    //备注显示说明一下  改用户未登录过
                b.setStatus(1);     // 退款状态 (0待退款、1退款成功、2退款失败)
                b.setLoginFlag(false);      // 限制其登录
                b.setCreatTime(DateUtil.parseDateTime(sdf.format(date)));   //设置 创建时间
                bbtCustomoerRefundService.insertSelective(b);       //找不到nick 照导 导入数据库

            }else{          //找到，不仅导，还修改 bbt_customer 表中的 dead_line 到期时间
                b.setDeadLine(customer.getDeadLine());      //本表的DeadLine = 表Customer中的 DeadLine
                customer.setDeadLine(DateUtil.parseDate(sdf.format(date)));     //刷新BbtCustomer表中的DeadLine
                customerService.updateDeadLineFormCustomerByNick(customer);     //执行修改
                b.setStatus(1);     // 退款状态 (0待退款、1退款成功、2退款失败)
                b.setLoginFlag(false);      // 限制其登录
                b.setCreatTime(DateUtil.parseDateTime(sdf.format(date)));   //设置 创建时间
                b.setRemarks("");
//              b.setRelieveTime(null);   //默认数据
                bbtCustomoerRefundService.insertSelective(b);       //插入  导入数据库
                this.jushitaService.deleteJdpUser(b.getSellerNick());
                TmcManager.getInstance().tmcUserCancel(b.getSellerNick());
            }
        }

        return JsonDTO.createInstance().setData("导入成功").setStatus(JsonDTO.SUCCESS).setMsg("请求处理成功");
    }


    /**
     * 手动将文件转化成流 测试
     */
    private MultipartFile getMultipartFile(File file){
        FileInputStream fileInputStream = null;
        MultipartFile multipartFile = null;
        try {
            fileInputStream = new FileInputStream(file);
            multipartFile = new MockMultipartFile(file.getName(),file.getName(),
            ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multipartFile;
    }


    /**
     * 退款标记解除
     *      http://localhost:8080/refund/updateRefundMarker.post
     *      {"id":66}
     */
    @PostMapping(value = "/updateRefundMarker.post")
    public JsonDTO updateRefundMarker(@RequestBody BbtCustomerRefund b){

        BbtCustomerRefund bbtCustomerRefund = bbtCustomoerRefundService.selectByPrimaryKey(b.getId().longValue());     //找到该对象
        if(bbtCustomerRefund == null) {
            LOG.warn("找不到该条记录 ");
            return JsonDTO.createInstance().setData("找不到该条记录 ").setStatus(JsonDTO.FAIL).setMsg("请求处理失败");
        }
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date date = new Date();
        bbtCustomerRefund.setRelieveTime(DateUtil.parseTimestamp(sdf.format(date)));     //存解除限制时间
        bbtCustomerRefund.setLoginFlag(true);       //  是否被限制（是否允许登录）

        bbtCustomoerRefundService.updateByPrimaryKeySelective(bbtCustomerRefund);
        return JsonDTO.createInstance().setData(bbtCustomerRefund).setStatus(JsonDTO.SUCCESS).setMsg("请求处理成功");
    }

}