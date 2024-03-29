package monim.blackice.business.view.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import monim.blackice.business.R
import monim.blackice.business.view.dialog.DialogHome

abstract class BaseDialogFragment : DialogFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewRelatedTask()
    }

    abstract fun viewRelatedTask()


    fun showToast(context: Context, message: String) {
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_toast_layout, null)

        val toastText = view.findViewById<TextView>(R.id.toastText)
        toastText.setText(message)

        toast.view = view
        toast.show()
    }



}