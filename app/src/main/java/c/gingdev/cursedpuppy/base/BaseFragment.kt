package c.gingdev.cursedpuppy.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import c.gingdev.cursedpuppy.utils.event.PuppyEventBus
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

abstract class BaseFragment: DaggerFragment() {
    @LayoutRes
    abstract fun layoutRes(): Int
    private var activity: AppCompatActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutRes(), container,false)?.root
    }

    protected var binding: ViewDataBinding? = null
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = DataBindingUtil.getBinding(view!!)
        binding()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        activity = context as AppCompatActivity

        PuppyEventBus.register(this)
    }

    override fun onDetach() {
        super.onDetach()
        activity = null

        PuppyEventBus.unregister(this)
    }

    abstract fun binding()
}