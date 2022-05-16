package com.rizal.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OfficialKonser extends AppCompatActivity {

    private WebView wvOfficial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official_konser);
        wvOfficial = (WebView) findViewById(R.id.wvOfficial);
        wvOfficial.setWebViewClient(new WvOfficial());
        wvOfficial.getSettings().setJavaScriptEnabled(true);
        wvOfficial.loadUrl("https://karcis.co.id/");
    }

    public class WvOfficial extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wvOfficial.canGoBack()) {
            wvOfficial.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}