package monim.blackice.business.view.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import monim.blackice.business.view.adapter.IAdapterListener

class BaseAdapter(mContext: Context?, mListener: IAdapterListener, mLayout: Int, mSize: Int) :
    RecyclerView.Adapter<BaseViewHolder>() {


    var context: Context? = mContext
    var listener: IAdapterListener = mListener
    var layout: Int = mLayout
    var size: Int = mSize
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return listener.getViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layout, parent, false
            ))
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position, listener)
    }


}