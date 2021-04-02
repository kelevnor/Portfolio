package com.ibm.mobilefirst.myportfolio.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibm.mobilefirst.myportfolio.data.PortfolioDataSource
import com.ibm.mobilefirst.myportfolio.data.PortfolioRepository
import com.ibm.mobilefirst.myportfolio.portfolio.PortfolioViewModel

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class PortfolioViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PortfolioViewModel::class.java)) {
            return PortfolioViewModel(
                    portfolioRepository = PortfolioRepository(
                            dataSource = PortfolioDataSource()
                    )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}