package com.orientalfinance.eastcloud.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.orientalfinance.R;

public class ActivityWebView extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = (WebView) findViewById(R.id.webView);
        //声明WebSettings子类
        WebSettings webSettings = webView.getSettings();

//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);


//设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

//缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
//其他细节操作
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        webView.setWebViewClient(new MyClient());
        webView.setWebChromeClient(new MyWebViewChromClient());
        webView.addJavascriptInterface(new Native("native"), "NATIVE");
        webView.loadUrl("http://192.168.200.46:8080/index.html");

    }

    class MyWebViewChromClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            AlertDialog.Builder b = new AlertDialog.Builder(ActivityWebView.this);
            b.setTitle("Alert");
            b.setMessage(message);
            b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.confirm();
                }
            });
            b.setCancelable(false);
            b.create().show();
            return true;

        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }
    }

    class MyClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Toast.makeText(ActivityWebView.this, "wodo-7-", Toast.LENGTH_SHORT).show();
            view.loadUrl(request.getUrl().getPath());
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Toast.makeText(ActivityWebView.this, "wodo-7-", Toast.LENGTH_SHORT).show();
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            String js = "var script = document.createElement('script');";
            js += "script.type = 'text/javascript';";
            js += "var child=document.getElementsByTagName('a')[0];";
            js += "child.onclick=function(){userIdClick();};";
            js += "function userIdClick(){NATIVE.getClose();};";

            webView.loadUrl("javascript:" + js);
        }
    }

    class Native {
        String name;

        @Override
        public String toString() {
            return "Native{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Native(String name) {
            this.name = name;
        }

        @JavascriptInterface
// sdk17版本以上加上注解
        public void getClose() {
            Toast.makeText(ActivityWebView.this, "dododo", Toast.LENGTH_SHORT)
                    .show();


        }
    }
}
