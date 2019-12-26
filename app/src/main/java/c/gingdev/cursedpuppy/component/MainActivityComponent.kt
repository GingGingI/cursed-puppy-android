package c.gingdev.cursedpuppy.component

import c.gingdev.cursedpuppy.MainActivity
import c.gingdev.cursedpuppy.annotations.UserScope
import c.gingdev.cursedpuppy.module.ActivityModule
import dagger.Component

@UserScope
@Component(dependencies = [BasicNetworkComponent::class],
    modules = [ActivityModule::class])
interface MainActivityComponent {
    fun inject(context: MainActivity): Unit
}