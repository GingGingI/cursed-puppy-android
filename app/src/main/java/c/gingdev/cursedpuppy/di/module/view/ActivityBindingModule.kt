package c.gingdev.cursedpuppy.di.module.view

import c.gingdev.cursedpuppy.ui.main.ErrorActivity
import c.gingdev.cursedpuppy.ui.main.CursedActivity
import c.gingdev.cursedpuppy.ui.main.MainActivity
import c.gingdev.cursedpuppy.ui.main.MainFragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindCursedActivity(): CursedActivity

    @ContributesAndroidInjector
    abstract fun bindErrorActivity(): ErrorActivity
}