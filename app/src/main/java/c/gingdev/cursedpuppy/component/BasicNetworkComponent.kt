package c.gingdev.cursedpuppy.component

import c.gingdev.cursedpuppy.module.AppModule
import c.gingdev.cursedpuppy.module.adapter.AdapterModule
import c.gingdev.cursedpuppy.module.network.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface BasicNetworkComponent {
    fun retrofit(): Retrofit
}