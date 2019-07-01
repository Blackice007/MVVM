package monim.blackice.business.view.adapter.viewholder

import android.content.Context
import androidx.databinding.ViewDataBinding
import monim.blackice.business.databinding.ItemUserBinding
import monim.blackice.business.view.adapter.IAdapterListener
import monim.blackice.business.view.base.BaseViewHolder

class UserViewHolder(itemView: ViewDataBinding, datas: List<String>, context: Context) : BaseViewHolder(itemView.root) {
    var binding:ItemUserBinding = itemView as ItemUserBinding
    var mContext:Context = context
    var allData: List<String> = datas
    override fun onBind(position: Int, listener: IAdapterListener) {
        //super.onBind(position, listener)
        binding.user = allData.get(position)

    }


}