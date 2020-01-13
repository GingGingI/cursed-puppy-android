package c.gingdev.cursedpuppy.di.module.basic

import android.app.Application
import android.content.Context
import c.gingdev.cursedpuppy.di.module.view.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
abstract class AppModule {
    @Binds
    abstract fun provideApp(app: Application): Context
}