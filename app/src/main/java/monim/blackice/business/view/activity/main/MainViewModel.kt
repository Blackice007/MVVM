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
    val hashMap: HashMap<String, MutableLiveData<LiveDataResult<BaseModel<Any>>>> = HashMap()

    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun addLiveData(key: String, values: MutableLiveData<LiveDataResult<BaseModel<Any>>>): MutableLiveData<LiveDataResult<BaseModel<Any>>> {
        hashMap.put(key, values);
        return values
    }

    fun getLiveData(key: String): MutableLiveData<LiveDataResult<BaseModel<Any>>> {
        return hashMap[key]!!
    }

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
            ApiCallbackHelper(getLiveData(key), loadingLiveData)
        )

    }

}