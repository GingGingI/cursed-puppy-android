package c.gingdev.cursedpuppy.utils.adapter.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.utils.ListLiveData
import java.lang.Exception

abstract class AdapterBase(private val context: Context?)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val item = ListLiveData<Any>()

    protected fun getItem(position: Int): Any? {
        return item.value?.get(position)
    }

    override fun getItemCount(): Int {
        return item.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HolderBase<*>).bind(getItem(position))
    }
}

abstract class HolderBase<in ITEM: Any>(
    context: Context,
    @LayoutRes private val layoutRes: Int,
    parent: ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(layoutRes, parent, false)) {
//    val binding: ViewDataBinding


    fun bind(item: Any?) {
        try {
            onViewCreated(item as? ITEM?)
        } catch (e: Exception) {
            itemView.visibility = View.GONE
        }
    }

    abstract fun onViewCreated(item: ITEM?)
}