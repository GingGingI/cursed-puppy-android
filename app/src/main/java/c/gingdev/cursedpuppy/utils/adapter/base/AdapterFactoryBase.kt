package c.gingdev.cursedpuppy.utils.adapter.base

import android.content.Context
import androidx.annotation.LayoutRes
import c.gingdev.cursedpuppy.utils.adapter.BasicAdapter

abstract class AdapterFactoryBase {
    abstract fun createBasicAdapter(context: Context, @LayoutRes layoutRes: Int): BasicAdapter
}