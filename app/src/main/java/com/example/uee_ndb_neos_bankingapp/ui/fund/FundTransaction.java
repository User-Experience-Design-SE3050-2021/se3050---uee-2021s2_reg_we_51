package com.example.uee_ndb_neos_bankingapp.ui.fund;

public class FundTransaction {
    private String payee;
    private Float amount;
    private String remark;

    public FundTransaction(){

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

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
