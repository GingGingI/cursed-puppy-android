package c.gingdev.cursedpuppy.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import c.gingdev.cursedpuppy.utils.event.PuppyEventBus
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity() {

    @LayoutRes protected abstract fun layoutRes(): Int

    protected lateinit var binding: ViewDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes())
        onCreated(savedInstanceState)

        PuppyEventBus.register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        PuppyEventBus.unregister(this)
    }

    protected abstract fun onCreated(savedInstanceState: Bundle?)
}