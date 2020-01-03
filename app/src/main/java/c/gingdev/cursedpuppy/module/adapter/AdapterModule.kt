package c.gingdev.cursedpuppy.module.adapter

import android.app.Activity
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.annotations.UserScope
import c.gingdev.cursedpuppy.module.ActivityModule
import c.gingdev.cursedpuppy.utils.adapter.AdapterFactory
import c.gingdev.cursedpuppy.utils.adapter.BasicAdapter
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
class AdapterModule(private val layoutRes: Int) {
    @Provides
    @UserScope
    fun provideAdapterFactory(): AdapterFactory {
        return AdapterFactory()
    }

    @Provides
    fun provideBasicAdapter(activity: Activity, adapterFactory: AdapterFactory): BasicAdapter {
        return adapterFactory.createBasicAdapter(activity , layoutRes)
    }
}