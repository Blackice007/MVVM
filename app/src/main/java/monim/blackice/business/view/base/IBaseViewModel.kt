package monim.blackice.business.view.base

interface IBaseViewModel {

    abstract fun onAttach(activity: BaseActivity)

    abstract fun onDetach()
}