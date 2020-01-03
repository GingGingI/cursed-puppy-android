package c.gingdev.cursedpuppy.utils.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.cursedpuppy.utils.adapter.base.AdapterFactoryBase

class AdapterFactory: AdapterFactoryBase() {
    override fun createBasicAdapter(context: Context, layoutRes: Int): BasicAdapter {
        return BasicAdapter(context, layoutRes)
    }
}