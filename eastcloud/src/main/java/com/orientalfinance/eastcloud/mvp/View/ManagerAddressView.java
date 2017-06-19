package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Address;

import java.util.List;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public interface ManagerAddressView extends BaseMvpView {


    void showSuccess(List<Address> addressList);
    void editSuccess();
    void deleteSuccess();

}
