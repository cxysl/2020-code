package com.bbt.oper.controller.promote.refund.utils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bbt.oper.service.crm.impl.BbtCrmOrderOperServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 导出List<Object>数据到excel（最多可导出65535行）
 * @author user
 */
public final class ExportExcel {

    private static Log LOG = LogFactory.getLog(BbtCrmOrderOperServiceImpl.class);

    /***
     * 构造方法
     */
    private ExportExcel() {

    }

    /***
     * 工作簿
     */
    private static HSSFWorkbook workbook;

    /***
     * sheet
     */
    private static HSSFSheet sheet;
    /***
     * 标题行开始位置
     */
//    private static final int TITLE_START_POSITION = 0;

    /***
     * 时间行开始位置
     */
//    private static final int DATEHEAD_START_POSITION = 1;

    /***
     * 表头行开始位置
     */
    private static final int HEAD_START_POSITION = 0;

    /***
     * 文本行开始位置
     */
    private static final int CONTENT_START_POSITION = 1;


    /**
     *
     * @param dataList
     *        对象集合
     * @param titleMap
     *        表头信息（对象属性名称->要显示的标题值)[按顺序添加]
     * @param sheetName
     *        sheet名称和表头值
     */
    public static List<String> excelExport(List<?> dataList, Map<String, String> titleMap, String sheetName, HttpServletRequest request, HttpServletResponse response) {
        // 初始化workbook
        initHSSFWorkbook(sheetName);
//        // 标题行
//        createTitleRow(titleMap, sheetName);
//        // 时间行
//        createDateHeadRow(titleMap);
        // 表头行
        createHeadRow(titleMap);
        // 文本行
        createContentRow(dataList, titleMap);
        //设置自动伸缩
        //autoSizeColumn(titleMap.size());
        // 写入处理结果
        String filedisplay = null;
        try {
            //生成UUID文件名称
            Date d = new Date();
            //创建日期格式化对象(把日期转成字符串)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String str = sdf.format(d);
            filedisplay = "营销退款表" +str+".xls";

            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download;charset=UTF-8");
//            response.setHeader("Content-Disposition", "attachment;charset=UTF-8;filename="+filedisplay);
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filedisplay, "UTF-8"));
            workbook.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
        catch (Exception e) {
            LOG.warn("download csv io error ! " ,e);
            return null;
        }finally {

        }
        List results = new ArrayList();
        results.add(filedisplay);
        return results;
    }

    /***
     *
     * @param sheetName
     *        sheetName
     */
    private static void initHSSFWorkbook(String sheetName) {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
    }

    /**
     * 生成标题（第零行创建）
     * @param titleMap 对象属性名称->表头显示名称
     * @param sheetName sheet名称
     */
//    private static void createTitleRow(Map<String, String> titleMap, String sheetName) {
//        CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, titleMap.size() - 1);
//        sheet.addMergedRegion(titleRange);
//        HSSFRow titleRow = sheet.createRow(TITLE_START_POSITION);
//        HSSFCell titleCell = titleRow.createCell(0);
//        titleCell.setCellValue(sheetName);
//    }

    /**
     * 创建时间行（第一行创建）
     * @param titleMap 对象属性名称->表头显示名称
     */
//    private static void createDateHeadRow(Map<String, String> titleMap) {
//        CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, titleMap.size() - 1);
//        sheet.addMergedRegion(dateRange);
//        HSSFRow dateRow = sheet.createRow(DATEHEAD_START_POSITION);
//        HSSFCell dateCell = dateRow.createCell(0);
//        dateCell.setCellValue(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
//    }

    /**
     * 创建表头行（第二行创建）
     * @param titleMap 对象属性名称->表头显示名称
     */
    private static void createHeadRow(Map<String, String> titleMap) {
        // 第1行创建
        HSSFRow headRow = sheet.createRow(HEAD_START_POSITION);
        int i = 0;
        for (String entry : titleMap.keySet()) {
            HSSFCell headCell = headRow.createCell(i);
            headCell.setCellValue(titleMap.get(entry));
            i++;
        }
    }

    /**
     *
     * @param dataList 对象数据集合
     * @param titleMap 表头信息
     */
    private static void createContentRow(List<?> dataList, Map<String, String> titleMap) {
        try {
            int i=0;
            for (Object obj : dataList) {
                HSSFRow textRow = sheet.createRow(CONTENT_START_POSITION + i);
                int j = 0;
                for (String entry : titleMap.keySet()) {
                    String method = "get" + entry.substring(0, 1).toUpperCase() + entry.substring(1);
                    Method m = obj.getClass().getMethod(method, null);
                    String value;
                    try{
                         value =   m.invoke(obj, null).toString();
                    }catch (NullPointerException e){
                        continue;
                    }
                    HSSFCell textcell = textRow.createCell(j);
                    textcell.setCellValue(value);
                    j++;
                }
                i++;
            }

        }
        catch (Exception e) {
            LOG.warn("download csv io error ! " ,e);
        }
    }
    /**
     * 自动伸缩列（如非必要，请勿打开此方法，耗内存）
     * @param size 列数
     */
    private static void autoSizeColumn(Integer size) {
        for (int j = 0; j < size; j++) {
            sheet.autoSizeColumn(j);
        }
    }
}