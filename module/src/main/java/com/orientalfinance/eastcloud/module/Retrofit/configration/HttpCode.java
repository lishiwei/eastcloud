package com.orientalfinance.eastcloud.module.Retrofit.configration;

/**
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */

public class HttpCode {
    public static final int SUCCESS = 10;


    /**
     *  1.    -10    系统异常
     2.    -11    接口异常
     3.    -12    策略代理类调用出错
     4.    -13    逻辑异常
     5.    -20    数据访问异常
     6.    -21    没有找到指定数据
     7.    -22    DAO层系统异常
     8.    -23    批量数据更新失败
     9.    -24    批量数据新增失败
     10.   -30    无效的请求
     11.   -31    没有返回值
     12.   -32    缺少参数
     13.   -33    缺少接口指令
     14.   -34    参数校验错误
     15.   -35    被校验对象为空
     16.   -36    TOKEN失效
     */
    /**
     * 服务器500错误
     */
    public static final int SYSTEM_ERROR = -10;
    public static final int INTERFACE_ERROR = -11;
    public static final int LOGIC_ERROR = -13;


}
