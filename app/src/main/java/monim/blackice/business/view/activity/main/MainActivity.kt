package monim.blackice.business.view.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import monim.blackice.business.R
import monim.blackice.business.data.model.BaseModel
import monim.blackice.business.data.model.user.UserData
import monim.blackice.business.databinding.ActivityMainBinding
import monim.blackice.business.util.DateUtil
import monim.blackice.business.util.LiveDataResult
import monim.blackice.business.view.activity.login.LoginActivity
import monim.blackice.business.view.base.BaseActivity

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val factory = MainViewModelFactory(getDataManager())
        this.viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.onAttach(this)

    }

    override fun viewRelatedTask() {

        this.viewModel.loadingLiveData.observe(this, this.loadingObserver)

        this.viewModel
            .addLiveData(this.getString(R.string.key_livedata_login), MutableLiveData())
            .observe(this, this.loginObserver)


        binding.btnName.setOnClickListener {
            viewModel.fetchLogin(this.getString(R.string.key_livedata_login))
        }
        val date:String = DateUtil
            .getInstance()
            .setFormatFlag(DateUtil.FORMAT_EEEEMMMdd)
            .setSaparatorFlag(DateUtil.SEPARATOR_COLON)
            .generateDateTimeFormat().buildDateTime(0)
    }

    private val loadingObserver = Observer<Boolean> { visibile ->

        when (visibile) {
            true -> binding.pb.visibility = View.VISIBLE
            false -> binding.pb.visibility = View.GONE

            else -> binding.pb.visibility = View.GONE
        }
    }


    private val loginObserver = Observer<LiveDataResult<BaseModel<Any>>> { result ->

        when (result?.status) {

            LiveDataResult.Status.LOADING -> {
                binding.pb.visibility = View.VISIBLE
            }
            LiveDataResult.Status.ERROR -> {
                showToast(applicationContext, result.err!!.message.toString())
            }
            LiveDataResult.Status.SUCCESS -> {

                val moshi: Moshi = Moshi.Builder().build()
                val adapter: JsonAdapter<UserData> = moshi.adapter(UserData::class.java)

                val user = result.data!! as BaseModel<UserData>
                if (user.code.equals(getString(R.string.code_200))) {
                    val userData = adapter.fromJsonValue(user.data!!)
                    binding.userData = userData
                    viewModel.storeUser(userData!!.user)
                    startActivity(Intent(this@MainActivity,LoginActivity::class.java))

                } else if (user.code.equals(getString(R.string.code_401))) {

                } else if (user.code.equals(getString(R.string.code_404))) {
                    showToast(applicationContext, user.message[0])
                }
                hideKeyboard()
            }
        }
    }


    fun showName() {
        showToast(applicationContext, "Md. Mushfique Hasan Monim")
    }


}
