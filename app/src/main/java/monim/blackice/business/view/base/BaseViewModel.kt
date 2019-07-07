package monim.blackice.business.view.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import monim.blackice.business.data.DataManager
import monim.blackice.business.data.model.BaseModel
import monim.blackice.business.util.LiveDataResult

abstract class BaseViewModel(dataManager: DataManager) : ViewModel(),
    IBaseViewModel {

    private var dataManager = dataManager

    private var mActivity: BaseActivity? = null
    val hashMap: HashMap<String, MutableLiveData<LiveDataResult<BaseModel<Any>>>> = HashMap()


    fun addLiveData(key: String): MutableLiveData<LiveDataResult<BaseModel<Any>>> {
        hashMap.put(key, MutableLiveData());
        return getLiveData(key)
    }

    fun getLiveData(key: String): MutableLiveData<LiveDataResult<BaseModel<Any>>> {
        return hashMap[key]!!
    }

    override fun onAttach(activity: BaseActivity) {
        mActivity = activity
    }

    override fun onDetach() {
        mActivity = null
    }

    fun isViewAttached(): Boolean {
        return mActivity != null
    }

    fun getView(): BaseActivity {
        return mActivity!!
    }

    fun getDataManager(): DataManager {
        return dataManager
    }
}