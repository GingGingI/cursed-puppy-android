package c.gingdev.cursedpuppy.module

import c.gingdev.cursedpuppy.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app
}