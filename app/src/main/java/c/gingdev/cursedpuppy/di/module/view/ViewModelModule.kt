package c.gingdev.cursedpuppy.di.module.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.annotations.ViewModelKey
import c.gingdev.cursedpuppy.ui.list.MainListViewModel
import c.gingdev.cursedpuppy.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainListViewModel::class)
    abstract fun bindMainListViewModel(listVM: MainListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}