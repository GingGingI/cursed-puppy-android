package c.gingdev.cursedpuppy.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(
    val list: ListLiveData<Any?>,
    @LayoutRes val layoutResID: Int): RecyclerView.Adapter<ListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(layoutResID = layoutResID, parent = parent)
    }

    override fun getItemCount(): Int {
        return list.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {

    }
}

class ListHolder(
    @LayoutRes layoutResID: Int,
    parent: ViewGroup)
    : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutResID, parent, false)) {

}