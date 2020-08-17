package sg.edu.rp.c346.id17045491.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2  extends AppCompatActivity {

    WebView wbView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wbView = findViewById(R.id.WebView);
        wbView.setWebViewClient(new WebViewClient());
        // Tell the WebView to enable javascript execution
        wbView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // Disable file access within WebView.
        wbView.getSettings().setAllowFileAccess(false);
        //Enable the built-in zoom control for the webView
        wbView.getSettings().setBuiltInZoomControls(true);

        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");

        wbView.loadUrl(url);

    }
    }
