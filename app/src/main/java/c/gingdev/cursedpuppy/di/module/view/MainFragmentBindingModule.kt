package c.gingdev.cursedpuppy.di.module.view

import c.gingdev.cursedpuppy.ui.list.MainListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun provideMainListFragment(): MainListFragment
}