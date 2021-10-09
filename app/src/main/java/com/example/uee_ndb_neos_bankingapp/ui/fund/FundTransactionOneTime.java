package com.example.uee_ndb_neos_bankingapp.ui.fund;

public class FundTransactionOneTime {
    private Integer payeeAccountNumber;
    private String payeeAccountBank;
    private Float amount;
    private String remark;

    public FundTransactionOneTime(){

    }

    public Integer getPayeeAccountNumber() {
        return payeeAccountNumber;
    }

    public void setPayeeAccountNumber(Integer payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }

    public String getPayeeAccountBank() {
        return payeeAccountBank;
    }

    public void setPayeeAccountBank(String payeeAccountBank) {
        this.payeeAccountBank = payeeAccountBank;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
