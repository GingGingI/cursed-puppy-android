package c.gingdev.cursedpuppy.utils

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class AdapterFactoryBase {
    abstract fun createBasicAdapter(@LayoutRes layoutRes: Int): Adapter<ViewHolder>
}