package com.bbt.oper.controller.promote.refund.been;

/**
 * 退款导出Excel参数封装
 */
public class RefundDownQuery {
    private String sellerNick;
    private String startTime;
    private String endTime;

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
