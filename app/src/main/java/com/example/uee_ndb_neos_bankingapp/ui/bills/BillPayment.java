package com.example.uee_ndb_neos_bankingapp.ui.bills;

public class BillPayment {
    private String biller;
    private String remark;
    private Float amount;

    public BillPayment() { }

    public String getBiller() {
        return biller;
    }

    public void setBiller(String biller) {
        this.biller = biller;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
