package c.gingdev.cursedpuppy.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindListHolder<BINDING: ViewDataBinding>(
    @LayoutRes layoutResId: Int,
    parent: ViewGroup,
    private val bindingVariableId: Int?)
    : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)) {
    private val binding: BINDING = DataBindingUtil.bind(itemView)!!

    fun bind(vm: Any?) {
        bindingVariableId?.let {
            binding.setVariable(it, vm)
            binding.executePendingBindings()
        }
    }
}