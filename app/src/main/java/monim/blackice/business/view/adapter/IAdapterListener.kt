package monim.blackice.business.view.adapter

import androidx.databinding.ViewDataBinding
import monim.blackice.business.view.base.BaseViewHolder

interface IAdapterListener {
    fun clickListener(position: Int)
    fun getViewHolder(view: ViewDataBinding) : BaseViewHolder
}