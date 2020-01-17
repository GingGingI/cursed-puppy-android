package c.gingdev.cursedpuppy.di.component

import android.app.Application
import c.gingdev.cursedpuppy.annotations.UserScope
import c.gingdev.cursedpuppy.di.module.network.NetworkModule
import dagger.Component

@UserScope
@Component(modules = [NetworkModule::class])
interface ListVMComponet {
    fun inject(app: Application)
}