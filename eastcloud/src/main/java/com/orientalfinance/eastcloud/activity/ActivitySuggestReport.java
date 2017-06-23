package com.orientalfinance.eastcloud.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.orientalfinance.eastcloud.view.EastCloudProgressDialog;

public class ActivitySuggestReport extends AppCompatActivity {
    EastCloudProgressDialog mEastCloudProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_report);
        mEastCloudProgressDialog = new EastCloudProgressDialog(this);
        findViewById(R.id.btn_Suggest).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mEastCloudProgressDialog.show();
                SuggestRequestParam suggestRequestParam = new SuggestRequestParam();
                suggestRequestParam.setContent("您好");
                RequestParam requestParam = new RequestParam(suggestRequestParam);
//                RemoteDataProxy.reportSuggest(requestParam).compose(new NullTransform())
//                        .doOnError(new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//                                mEastCloudDialog.hide();
//                                Toast.makeText(ActivitySuggestReport.this, "网络访问失败!", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .subscribe(new Consumer<EastCloudResponseBody>() {
//                            @Override
//                            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
//                                mEastCloudDialog.hide();
//                                Toast.makeText(ActivitySuggestReport.this, "您的建议我们已收到,谢谢!", Toast.LENGTH_SHORT).show();
//                            }
//                        });
                RemoteDataProxy.reportSuggestTest(requestParam, new HttpCallBack() {
                    @Override
                    public void OnSuccess(Object data) {
                        Toast.makeText(ActivitySuggestReport.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        LogUtils.e("TAG", "onFailure: " + errorMsg);
                    }

                    @Override
                    public void onCompleted() {
                        LogUtils.e("TAG", "onCompleted: ");
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEastCloudProgressDialog.dismiss();
    }

    class SuggestRequestParam {
        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "SuggestRequestParam{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }
}
