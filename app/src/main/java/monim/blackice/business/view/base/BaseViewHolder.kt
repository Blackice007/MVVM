package monim.blackice.business.view.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import monim.blackice.business.view.adapter.IAdapterListener

abstract class BaseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mCurrentPosition: Int = 0
    private lateinit var mListenerI: IAdapterListener


    open fun onBind(position: Int, listenerI: IAdapterListener) {
        mCurrentPosition = position
        mListenerI = listenerI
    }

    fun getCurrentPosition(): Int {
        return mCurrentPosition
    }



}