package c.gingdev.cursedpuppy.utils

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class BasicAdapter(@LayoutRes layoutRes: Int): AdapterBase(layoutRes) {
    val list: ArrayList<Any?> = ArrayList()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}