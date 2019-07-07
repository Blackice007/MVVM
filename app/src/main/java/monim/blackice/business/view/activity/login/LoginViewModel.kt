package monim.blackice.business.view.activity.login

import androidx.lifecycle.MutableLiveData
import monim.blackice.business.data.DataManager
import monim.blackice.business.data.model.BaseModel
import monim.blackice.business.data.model.user.User
import monim.blackice.business.util.LiveDataResult
import monim.blackice.business.view.activity.main.MainActivity
import monim.blackice.business.view.base.BaseActivity
import monim.blackice.business.view.base.BaseViewModel
import sslwireless.android.easy.loyal.merchant.viewmodel.util.ApiCallbackHelper

class LoginViewModel(dataManager: DataManager) : BaseViewModel(dataManager) {

    private lateinit var view: LoginActivity
    val amountLiveData: MutableLiveData<String> = MutableLiveData()

    override fun onAttach(activityView: BaseActivity) {
        super.onAttach(activityView)
        view = getView() as LoginActivity
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun amountUpdate() {
        amountLiveData.postValue("263")
    }

}