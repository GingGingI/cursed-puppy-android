package c.gingdev.cursedpuppy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class BaseFragment<BINDING: ViewDataBinding?>: DaggerFragment() {
    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<BINDING>(inflater, layoutRes(), container,false)?.root
    }

    protected var binding: BINDING? = null
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = DataBindingUtil.getBinding<BINDING>(view!!)
        binding()
    }

    abstract fun binding()
}