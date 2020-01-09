package c.gingdev.cursedpuppy.di.module.basic

import c.gingdev.cursedpuppy.di.module.view.ViewModelModule
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideApp(app: DaggerApplication) = app
}