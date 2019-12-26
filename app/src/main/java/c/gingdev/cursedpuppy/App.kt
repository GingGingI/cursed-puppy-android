package c.gingdev.cursedpuppy

import android.app.Application
import android.content.Context
import c.gingdev.cursedpuppy.component.BasicNetworkComponent
import c.gingdev.cursedpuppy.component.DaggerBasicNetworkComponent
import c.gingdev.cursedpuppy.module.network.NetworkModule
import c.gingdev.cursedpuppy.module.AppModule

/**
 * Dagger의 class 중 가장 base Class
 * */
class App: Application() {
    val NetworkModule: BasicNetworkComponent by lazy {
        DaggerBasicNetworkComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()
    }

    companion object {
        fun getNetworkComponent(context: Context): BasicNetworkComponent {
            return (context.applicationContext as App).NetworkModule
        }
    }
}