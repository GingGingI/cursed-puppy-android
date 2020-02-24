package c.gingdev.cursedpuppy.di.module.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.annotations.ViewModelKey
import c.gingdev.cursedpuppy.ui.etc.CursedTranslatorViewModel
import c.gingdev.cursedpuppy.ui.list.MainListViewModel
import c.gingdev.cursedpuppy.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(MainListViewModel::class)
//    abstract fun bindMainListViewModel(vm: MainListViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(CursedTranslatorViewModel::class)
//    abstract fun bindCursedTranslatorViewModel(vm: CursedTranslatorViewModel): ViewModel
//
    @Binds
    @IntoMap
    @ViewModelKey(MainListViewModel::class)
    abstract fun bindCursedDialogListViewModel(vm: MainListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}