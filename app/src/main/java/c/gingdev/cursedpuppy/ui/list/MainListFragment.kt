package c.gingdev.cursedpuppy.ui.list

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseFragment
import c.gingdev.cursedpuppy.utils.event.PuppyEventBus
import javax.inject.Inject

class MainListFragment: BaseFragment() {
    private val TAG = "MainListFragment"

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    lateinit var vm: ViewModel

    override fun layoutRes(): Int {
        return R.layout.fragment_basic
    }

    override fun binding() {
        vm = vmFactory.create(MainListViewModel::class.java)
            .also {
                it.correctPuppy.observe(this, Observer { puppy ->
                    PuppyEventBus.post(puppy)
                })
            }
        binding?.run {
            setVariable(BR.vm, vm)
        }
    }
}