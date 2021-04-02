package com.ibm.mobilefirst.myportfolio.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView

import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ibm.mobilefirst.myportfolio.BuildConfig
import com.ibm.mobilefirst.myportfolio.R
import com.ibm.mobilefirst.myportfolio.ui.login.PortfolioViewModelFactory

class PortfolioActivity : AppCompatActivity() {

    private val portfolioViewModel: PortfolioViewModel by viewModels {
        PortfolioViewModelFactory(
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)
        val webView: WebView = findViewById(R.id.webview)
        val textView: TextView = findViewById(R.id.loading)
        portfolioViewModel.showHideWebviewProgressBar(webView, textView)
        portfolioViewModel.loadPortfolioSiteToWebview(webView, BuildConfig.PORTFOLIO_BASE_URL)


        webView!!.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {

                    textView!!.text = "Page loading : $newProgress%"
                    if (newProgress == 100) {
                        textView!!.text = "Page Loaded."
                    }
                    portfolioViewModel.showHideWebviewProgressBar(webView, textView)

                }
            }
        }



//        webView.webViewClient = WebViewClient()
//        webView.settings.javaScriptEnabled = true
//        webView.settings.domStorageEnabled = true
//        webView.settings.loadWithOverviewMode = true
//        webView.settings.useWideViewPort = true
//        webView.settings.builtInZoomControls = false
//        webView.loadUrl(BuildConfig.PORTFOLIO_BASE_URL)


}