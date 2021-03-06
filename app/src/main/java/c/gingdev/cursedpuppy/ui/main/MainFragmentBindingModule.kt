package c.gingdev.cursedpuppy.ui.main

import c.gingdev.cursedpuppy.ui.list.CursedListDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {
//    @ContributesAndroidInjector
//    abstract fun provideMainListFragment(): MainListFragment
//
//    @ContributesAndroidInjector
//    abstract fun provideCursedTranslatorFragment(): CursedTranslatorFragment
    @ContributesAndroidInjector
    abstract fun provideCursedListDialogFragment(): CursedListDialogFragment
}