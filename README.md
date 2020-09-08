# 2020-code

## 简介说明

*  <strong> TeaStore： </strong>  一个 web 茶叶网站，分卖家买家账号登入进入不同的页面做不同的业务操作，实现了商品、购物车信息、个人信息、订单、订单详情信息的增删改查;</br></br>

* `project_api`、`project_jdbc`、`work02`为同一个项目(我将这三个已单独建立了仓库可以出取看)：</br>
`project_jdbc`:  [wx_shop-backstage](https://github.com/cxysl/wx_shop-backstage) 、
`project_api`:  [wx_shop_api](https://github.com/cxysl/wx_shop_api) 、
`work02`:  [wx_shop-web](https://github.com/cxysl/wx_shop-web) 、

*  <strong> project_jdbc： </strong> 为项目后台 web 网页版，给卖家管理员使用，后台实现的业务模块有：顾客信息模块、商品信息模块（包括增删改查、采购和采购记录、商品上下架、商品轮播图信息维护、商品品牌分类）、订单以及订单详情模块、物流信息模块; 系统已经丢服务器上上线了，访问地址(游客账号：123@qq.com 密码：123)：[系统后台](https://www.cxysl.cn/project_jdbc)  </br></br>

*  <strong> work02： </strong> 为系统前台 微信小程序版，给顾客使用;前台实现的业务功能有：顾客账号登录和注册（没错，我的小程序没有让他直接获取顾客微信信息，而是做的账号密码进行登录验证，可注册）、商品的品牌分类显示以及模糊查询、商品目录到对应商品详情页的跳转显示、商品详情页有直接下单和加入购物车的操作、顾客购物车操作的动态变化以及合计下单、订单的生成和订单明细的生成、顾客个人信息的维护等等;</br>
前台访问需扫微信小程序二维码申请访问：[系统前台](https://www.cxysl.cn/cxysl_wx.jpg)</br></br>


* <strong> project_api： </strong> 为系统中层接口，为前台小程序服务，间接的操作数据库;</br></br>

*  <strong> refund </strong> 有Excel 的导入导出;</br></br>

