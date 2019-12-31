package c.gingdev.cursedpuppy.component

import androidx.databinding.ViewDataBinding
import c.gingdev.cursedpuppy.MainActivity
import c.gingdev.cursedpuppy.annotations.UserScope
import c.gingdev.cursedpuppy.module.ActivityModule
import c.gingdev.cursedpuppy.module.adapter.AdapterModule
import c.gingdev.cursedpuppy.utils.ListLiveData
import dagger.Component

@UserScope
@Component(dependencies = [BasicNetworkComponent::class],
    modules = [ActivityModule::class, AdapterModule::class])
interface MainActivityComponent {
    fun inject(context: MainActivity): Unit

}