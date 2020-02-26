package c.gingdev.cursedpuppy.ui.list

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseButtomSheetFragment
import c.gingdev.cursedpuppy.ui.etc.SelectedPuppyViewModel
import c.gingdev.cursedpuppy.ui.list.MainListViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_basic.*
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
                selectedPuppyViewModel!!.setSelectedPuppy(puppy)
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