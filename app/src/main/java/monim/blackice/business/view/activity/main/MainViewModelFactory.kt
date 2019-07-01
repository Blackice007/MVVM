package monim.blackice.business.view.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import monim.blackice.business.data.DataManager

class MainViewModelFactory(
    private val dataManager: DataManager
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
            return MainViewModel(this.dataManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}