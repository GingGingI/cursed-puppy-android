package c.gingdev.cursedpuppy.di.component

import android.app.Application
import c.gingdev.cursedpuppy.base.App
import c.gingdev.cursedpuppy.di.module.view.ActivityBindingModule
import c.gingdev.cursedpuppy.di.module.network.NetworkModule
import c.gingdev.cursedpuppy.di.module.basic.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class])
interface AppComponent: AndroidInjector<DaggerApplication> {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}