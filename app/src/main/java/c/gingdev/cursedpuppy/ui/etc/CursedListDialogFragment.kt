package c.gingdev.cursedpuppy.ui.etc

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseButtomSheetFragment
import c.gingdev.cursedpuppy.ui.list.MainListViewModel
import javax.inject.Inject

class CursedListDialogFragment: BaseButtomSheetFragment() {

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    lateinit var vm: ViewModel

    override fun layoutRes(): Int {
        return R.layout.fragment_basic
    }

    override fun binding() {
        vm = vmFactory.create(MainListViewModel::class.java).also {
            it.correctPuppy.observe(this, Observer { puppy ->
//                                selectedPuppyViewModel
            })
        }
        binding?.run {
            setVariable(BR.vm, vm)
        }
    }

    private var selectedPuppyViewModel: SelectedPuppyViewModel? = null
    fun setSelectedPuppyModel(selectedPuppyViewModel: SelectedPuppyViewModel) {
        this.selectedPuppyViewModel = selectedPuppyViewModel
    }
}