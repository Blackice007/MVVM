package monim.blackice.business.view.activity.main

import androidx.lifecycle.MutableLiveData
import monim.blackice.business.data.DataManager
import monim.blackice.business.data.model.BaseModel
import monim.blackice.business.data.model.user.User
import monim.blackice.business.util.LiveDataResult
import monim.blackice.business.view.base.BaseActivity
import monim.blackice.business.view.base.BaseViewModel
import sslwireless.android.easy.loyal.merchant.viewmodel.util.ApiCallbackHelper

class MainViewModel(dataManager: DataManager) : BaseViewModel(dataManager) {

    private lateinit var view: MainActivity

    fun storeUser(user: User) {
        getDataManager().PrefLogin(user)
        val user = getDataManager().PrefGetCurrentUser()
        val isLogin = getDataManager().PrefGetLoginMode()
    }

    override fun onAttach(activityView: BaseActivity) {
        super.onAttach(activityView)
        view = getView() as MainActivity
    }

    override fun onDetach() {
        super.onDetach()
    }


    fun fetchLogin(key: String) {

        getDataManager().apiLogin(
            "store1@test.com",
            "123456",
            ApiCallbackHelper(getLiveData(key))
        )

    }

}