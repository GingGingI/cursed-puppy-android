package c.gingdev.cursedpuppy.ui.main

import c.gingdev.cursedpuppy.annotations.UserScope
import c.gingdev.cursedpuppy.di.module.network.NetworkModule
import c.gingdev.cursedpuppy.di.module.view.ViewModelModule
import c.gingdev.cursedpuppy.ui.list.MainListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun provideMainListFragment(): MainListFragment
}