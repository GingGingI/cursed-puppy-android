package c.gingdev.cursedpuppy.ui.list

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

abstract class BindListAdapter<ITEM: Any?, BINDING: ViewDataBinding> (
    val list: ObservableArrayList<ITEM>?,
    @LayoutRes private val layoutRes: Int,
    private val bindingVariableID: Int? = null): RecyclerView.Adapter<BindListHolder<BINDING>>() {

    init {
        list!!.addOnListChangedCallback(
            object: ObservableList.OnListChangedCallback<ObservableList<ViewModel>>() {
                override fun onChanged(sender: ObservableList<ViewModel>?) {
                    notifyDataSetChanged()
                }
                override fun onItemRangeRemoved(sender: ObservableList<ViewModel>?, positionStart: Int, itemCount: Int) {
                    notifyItemRangeRemoved(positionStart, itemCount)
                }
                override fun onItemRangeMoved(
                    sender: ObservableList<ViewModel>?,
                    fromPosition: Int,
                    toPosition: Int,
                    itemCount: Int) {
                    notifyItemMoved(fromPosition, toPosition)
                }
                override fun onItemRangeInserted(sender: ObservableList<ViewModel>?, positionStart: Int, itemCount: Int) {
                    notifyItemRangeInserted(positionStart,itemCount)
                }
                override fun onItemRangeChanged(sender: ObservableList<ViewModel>?, positionStart: Int, itemCount: Int) {
                    notifyItemRangeChanged(positionStart, itemCount)
                }
            })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindListHolder<BINDING> =
        object: BindListHolder<BINDING>(
            layoutResId = layoutRes,
            parent = parent,
            bindingVariableId = bindingVariableID){}

    override fun getItemCount(): Int
            = list?.size ?: 0

    override fun onBindViewHolder(holder: BindListHolder<BINDING>, position: Int) {
        holder.bind(list!![position])
    }
}