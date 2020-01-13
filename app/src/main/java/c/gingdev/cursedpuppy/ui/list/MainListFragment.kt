package c.gingdev.cursedpuppy.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseFragment
import c.gingdev.cursedpuppy.databinding.LayoutBasicBinding
import c.gingdev.cursedpuppy.utils.ViewModelFactory
import javax.inject.Inject

class MainListFragment: BaseFragment() {

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    lateinit var vm: ViewModel

    override fun layoutRes(): Int {
        return R.layout.layout_basic
    }

    override fun binding() {
        vm = vmFactory.create(MainListViewModel::class.java)
        binding?.run {
            setVariable(BR.vm, vm)
        }
    }
}