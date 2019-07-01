package monim.blackice.business.view.fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import monim.blackice.business.R
import monim.blackice.business.databinding.FragmentLoginBinding
import monim.blackice.business.util.ConstantField
import monim.blackice.business.view.activity.login.LoginActivity
import monim.blackice.business.view.adapter.IAdapterListener
import monim.blackice.business.view.adapter.viewholder.UserViewHolder
import monim.blackice.business.view.base.BaseActivity
import monim.blackice.business.view.base.BaseAdapter
import monim.blackice.business.view.base.BaseFragment
import monim.blackice.business.view.base.BaseViewHolder
import monim.blackice.business.view.dialog.DialogHome

class LoginFragment : BaseFragment() {

    companion object {
        private var f = LoginFragment()
        fun newInstance(token: String): LoginFragment {
            val args = Bundle()
            args.putString(ConstantField.newInstance().ACCESS_TOKEN, token)
            f.arguments = args
            Log.d("TAG", f.toString())
            return f
        }
    }


    lateinit var binding: FragmentLoginBinding
    private var token: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.root
    }

    override fun viewRelatedTask() {

        Log.d("TAG", f.toString())
        token = arguments!!.getString(ConstantField.newInstance().ACCESS_TOKEN)


        val arrayList = ArrayList<String>()//Creating an empty arraylist
        arrayList.add("Md. Mushfique Hasan Monim")
        arrayList.add("Md. Mushfique Hasan Monim")
        arrayList.add("Md. Mushfique Hasan Monim")
        arrayList.add("Md. Mushfique Hasan Monim")
        arrayList.add("Md. Mushfique Hasan Monim")
        arrayList.add("Md. Mushfique Hasan Monim")
        arrayList.add("Md. Mushfique Hasan Monim")

//        binding.rvUsers.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
        binding.rvUsers.setLayoutManager(LinearLayoutManager(context))
        binding.rvUsers.adapter = BaseAdapter(
            context,
            object : IAdapterListener {
                override fun clickListener(position: Int) {
                    showToast(context!!, arrayList[position])
                }

                override fun getViewHolder(view: ViewDataBinding): BaseViewHolder {
                    return UserViewHolder(view, arrayList, context!!)
                }

            },
            R.layout.item_user,
            arrayList.size
        )

        (activity as LoginActivity).getLiveData().observe(this, amountObserver)


        binding.btnLogin.setOnClickListener {
            (activity as LoginActivity).getLiveData().postValue("850")
        }

    }

    private val amountObserver = Observer<String> { amount ->
        showDialog(true, DialogHome.newInstance(amount))
    }
}