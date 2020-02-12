package c.gingdev.cursedpuppy.ui.main

import c.gingdev.cursedpuppy.ui.etc.CursedTranslatorFragment
import c.gingdev.cursedpuppy.ui.list.MainListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun provideMainListFragment(): MainListFragment

    @ContributesAndroidInjector
    abstract fun provideCursedTranslatorFragment(): CursedTranslatorFragment
}