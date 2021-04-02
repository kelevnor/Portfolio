package com.ibm.mobilefirst.myportfolio.portfolio

import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModel

import com.ibm.mobilefirst.myportfolio.data.PortfolioRepository

class PortfolioViewModel(private val portfolioRepository: PortfolioRepository) : ViewModel() {

    private var isPortfolioLoading = false;
    private var hasPortfolioLoaded = false

    fun setPortfolioLoaded() {
        isPortfolioLoading = false
        hasPortfolioLoaded = true
    }

    fun setPortfolioIsLoading() {
        isPortfolioLoading = true
        hasPortfolioLoaded = false
    }

    fun setPortfolioStoppedLoading() {
        isPortfolioLoading = false
        hasPortfolioLoaded = false
    }

    fun loadPortfolioSiteToWebview (webView: WebView, url: String){
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.builtInZoomControls = false
        webView.loadUrl(url)
    }

    fun showHideWebviewProgressBar (webView: WebView, textView: TextView){
        if(webView.visibility == View.VISIBLE){
            webView.visibility = View.GONE
            textView.visibility = View.VISIBLE
        }
        else{
            webView.visibility == View.VISIBLE
            textView.visibility = View.GONE
        }

    }


//    private val _loginForm = MutableLiveData<LoginFormState>()
//    val loginFormState: LiveData<LoginFormState> = _loginForm
//
//    private val _loginResult = MutableLiveData<LoginResult>()
//    val loginResult: LiveData<LoginResult> = _loginResult
//
//    fun login(username: String, password: String) {
//        // can be launched in a separate asynchronous job
//        val result = loginRepository.login(username, password)
//
//        if (result is Result.Success) {
//            _loginResult.value = LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
//        } else {
//            _loginResult.value = LoginResult(error = R.string.login_failed)
//        }
//    }
//
//    fun navigateToPortfolio(activity: LoginActivity) {
//        // can be launched in a separate asynchronous job
//        val intent = Intent(activity, PortfolioActivity::class.java)
//        activity.startActivity(intent)
//    }
//
//    fun loginDataChanged(username: String, password: String) {
//        if (!isUserNameValid(username)) {
//            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
//        } else if (!isPasswordValid(password)) {
//            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
//        } else {
//            _loginForm.value = LoginFormState(isDataValid = true)
//        }
//    }
//
//    // A placeholder username validation check
//    private fun isUserNameValid(username: String): Boolean {
//        return if (username.contains('@')) {
//            Patterns.EMAIL_ADDRESS.matcher(username).matches()
//        } else {
//            username.isNotBlank()
//        }
//    }
//
//    // A placeholder password validation check
//    private fun isPasswordValid(password: String): Boolean {
//        return password.length > 5
//    }
}