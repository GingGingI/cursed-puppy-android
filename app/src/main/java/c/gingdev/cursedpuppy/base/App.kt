package c.gingdev.cursedpuppy.base

import android.app.Application
import android.content.Context
import c.gingdev.cursedpuppy.di.component.AppComponent
import c.gingdev.cursedpuppy.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Dagger의 class 중 가장 base Class
 * */
class App: DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component: AppComponent =
            DaggerAppComponent
                .builder()
                .application(this)
                .build()
        component.inject(this)

        return component
    }
}