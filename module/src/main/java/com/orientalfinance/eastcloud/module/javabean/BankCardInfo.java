package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/12.
 */

public class BankCardInfo {
    @SerializedName("bank_id")
    String bankId;

    @SerializedName("id_card")
    String idCard;

    String name;
    String phone;
    @SerializedName("valid_code")
    String validCode;
    @SerializedName("first_card")
    String firstCard;

    @SerializedName("bank_code")
    String bankNumber;

    @SerializedName("bank_name")
    String bankName;

    String bankProperty;

    @SerializedName("bank_img")
    String bankLogo;
    @SerializedName("card_type")
    String cardType;
    public BankCardInfo(String bankName, String bankProperty, String bankNumber, String bankLogo) {
        this.bankName = bankName;
        this.bankProperty = bankProperty;
        this.bankNumber = bankNumber;
        this.bankLogo = bankLogo;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(String firstCard) {
        this.firstCard = firstCard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
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

    @Override
    public String toString() {
        return "BankCardInfo{" +
                "bankId='" + bankId + '\'' +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", validCode='" + validCode + '\'' +
                ", firstCard='" + firstCard + '\'' +
                ", bankNumber='" + bankNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankProperty='" + bankProperty + '\'' +
                ", bankLogo='" + bankLogo + '\'' +
                ", cardType='" + cardType + '\'' +
                '}';
    }

}
