package monim.blackice.business.view.base

import androidx.lifecycle.ViewModel
import monim.blackice.business.data.DataManager

abstract class BaseViewModel(dataManager: DataManager) : ViewModel(),
    IBaseViewModel {

    private var dataManager = dataManager

    private var mActivity: BaseActivity? = null

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