package c.gingdev.cursedpuppy.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class AdapterBase(@LayoutRes private val layoutRes: Int): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HolderBase(layoutRes = layoutRes, parent = parent)
    }
}

class HolderBase(@LayoutRes layoutRes: Int, parent: ViewGroup)
    : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)) {
    fun item() {

    }
}