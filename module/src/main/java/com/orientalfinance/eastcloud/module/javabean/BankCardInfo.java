package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/12.
 */

public class BankCardInfo {
    String bankName;
    String bankProperty;
    String bankNumber;
    String bankLogo;
    public BankCardInfo(String bankName, String bankProperty, String bankNumber, String bankLogo) {
        this.bankName = bankName;
        this.bankProperty = bankProperty;
        this.bankNumber = bankNumber;
        this.bankLogo = bankLogo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankProperty() {
        return bankProperty;
    }

    public void setBankProperty(String bankProperty) {
        this.bankProperty = bankProperty;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(String bankLogo) {
        this.bankLogo = bankLogo;
    }
}
