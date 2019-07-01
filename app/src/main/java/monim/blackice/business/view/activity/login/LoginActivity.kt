package monim.blackice.business.view.activity.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import monim.blackice.business.R
import monim.blackice.business.databinding.ActivityLoginBinding
import monim.blackice.business.view.activity.main.MainViewModelFactory
import monim.blackice.business.view.base.BaseActivity
import monim.blackice.business.view.fragment.LoginFragment

class LoginActivity : BaseActivity() {


    lateinit var binding:ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        val factory = LoginViewModelFactory(getDataManager())
        this.viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        viewModel.onAttach(this)
    }


    override fun viewRelatedTask() {
        addFragment(true, R.id.container, LoginFragment.newInstance("No"))
        viewModel.amountLiveData.observe(this,amountObserver)
        viewModel.amountUpdate()
    }

    private val amountObserver = Observer<String> { amount ->
      binding.tvAmount.setText(amount)
    }

    fun getLiveData():MutableLiveData<String>{
        return viewModel.amountLiveData;
    }

}
