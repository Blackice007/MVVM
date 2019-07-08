package monim.blackice.business.view.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import monim.blackice.business.data.DataManager
import monim.blackice.business.view.activity.login.LoginViewModel

class BaseViewmodelFactory(private val dataManager: DataManager) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java!!)) {
            return LoginViewModel(this.dataManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


/*
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
    {
        Provider < ? extends ViewModel > creator = creators.get(modelClass);
        if (creator == null) {
            for (Map. Entry < Class < ? extends ViewModel >, Provider<ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException ("unknown model class " + modelClass);
        }
        try {
            return (T) creator . get ();
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }*/
}