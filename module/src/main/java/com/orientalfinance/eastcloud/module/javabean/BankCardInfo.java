package com.orientalfinance.eastcloud.module.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/12.
 */

public class BankCardInfo implements Parcelable {
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
    public boolean isFirstCard() {
        return firstCard.equals("1");
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

    public static class CheckRequestParam {
        String id_card;
        String bank_code;
        String name;
        String phone;
        String valid_code;

        public CheckRequestParam(String id_card, String bank_code, String name, String phone, String valid_code) {
            this.id_card = id_card;
            this.bank_code = bank_code;
            this.name = name;
            this.phone = phone;
            this.valid_code  = valid_code ;
        }

        public String getId_card() {
            return id_card;
        }

        public void setId_card(String id_card) {
            this.id_card = id_card;
        }

        public String getBank_code() {
            return bank_code;
        }

        public void setBank_code(String bank_code) {
            this.bank_code = bank_code;
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

        public String getvalid_code() {
            return valid_code ;
        }

        public void setvalid_code(String pwd) {
            this.valid_code  = pwd;
        }

        @Override
        public String toString() {
            return "CheckRequestParam{" +
                    "id_card='" + id_card + '\'' +
                    ", bank_code='" + bank_code + '\'' +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", valid_code='" + valid_code + '\'' +
                    '}';
        }
    }
public static class CommitRequestParam{
    String id_card;
    String bank_code;
    String name;
    String phone;
    String pwd;

    public CommitRequestParam(String id_card, String bank_code, String name, String phone, String payPwd) {
        this.id_card = id_card;
        this.bank_code = bank_code;
        this.name = name;
        this.phone = phone;
        this.pwd = payPwd;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "CommitRequestParam{" +
                "id_card='" + id_card + '\'' +
                ", bank_code='" + bank_code + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bankId);
        dest.writeString(this.idCard);
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeString(this.validCode);
        dest.writeString(this.firstCard);
        dest.writeString(this.bankNumber);
        dest.writeString(this.bankName);
        dest.writeString(this.bankProperty);
        dest.writeString(this.bankLogo);
        dest.writeString(this.cardType);
    }

    protected BankCardInfo(Parcel in) {
        this.bankId = in.readString();
        this.idCard = in.readString();
        this.name = in.readString();
        this.phone = in.readString();
        this.validCode = in.readString();
        this.firstCard = in.readString();
        this.bankNumber = in.readString();
        this.bankName = in.readString();
        this.bankProperty = in.readString();
        this.bankLogo = in.readString();
        this.cardType = in.readString();
    }

    public static final Parcelable.Creator<BankCardInfo> CREATOR = new Parcelable.Creator<BankCardInfo>() {
        @Override
        public BankCardInfo createFromParcel(Parcel source) {
            return new BankCardInfo(source);
        }

        @Override
        public BankCardInfo[] newArray(int size) {
            return new BankCardInfo[size];
        }
    };
}
