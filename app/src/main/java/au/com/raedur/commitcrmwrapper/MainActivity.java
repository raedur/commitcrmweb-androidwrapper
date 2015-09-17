package au.com.raedur.commitcrmwrapper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

	private static final String DOMAIN = "YOURDOMAIN"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView browser = (WebView)findViewById(R.id.browser);
        browser.setWebChromeClient(new WebChromeClient());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        browser.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("https://" + DOMAIN))
                    return true;
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        browser.loadUrl("https://" + DOMAIN + "/commitcrm/commitcrm.dll/files/cmtcustlogin.html");
    }
}
