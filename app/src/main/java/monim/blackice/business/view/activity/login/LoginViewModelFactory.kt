package monim.blackice.business.view.activity.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import monim.blackice.business.data.DataManager

class LoginViewModelFactory(
    private val dataManager: DataManager
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java!!)) {
            return LoginViewModel(this.dataManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}