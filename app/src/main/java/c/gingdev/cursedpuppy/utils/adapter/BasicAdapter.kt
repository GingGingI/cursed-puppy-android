package c.gingdev.cursedpuppy.utils.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.cursedpuppy.utils.adapter.base.AdapterBase
import c.gingdev.cursedpuppy.utils.adapter.base.HolderBase

class BasicAdapter(private val context: Context, @LayoutRes private val layoutRes: Int): AdapterBase(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BasicHolder(context = context, layoutRes = layoutRes, parent = parent)
    }
}

class BasicHolder(context: Context, @LayoutRes layoutRes: Int, parent: ViewGroup)
    : HolderBase<Any>(context = context, layoutRes = layoutRes, parent = parent) {
    override fun onViewCreated(item: Any?) {

    }
}