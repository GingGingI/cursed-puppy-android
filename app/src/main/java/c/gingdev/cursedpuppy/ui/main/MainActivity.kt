package c.gingdev.cursedpuppy.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import c.gingdev.cursedpuppy.ui.list.CursedListDialogFragment
import c.gingdev.cursedpuppy.ui.etc.SelectedPuppyViewModel
import c.gingdev.cursedpuppy.utils.ui.checkBackgroundColor
import c.gingdev.cursedpuppy.utils.ui.setDebounceClickListener
import c.gingdev.cursedpuppy.utils.ui.statusBarTransparent
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity: BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    private val selectedPuppyModel = SelectedPuppyViewModel()
    override fun onCreated(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.setVariable(BR.selectedPuppy, selectedPuppyModel)
        }

        statusBarTransparent()
        checkBackgroundColor(parentView)
        initView()
    }

    private fun initView() {
        parentView.setDebounceClickListener {
            openListPanel()
        }

        selectedPuppyModel.puppyModel.observe(this, Observer { puppy ->
            dialogFragment.dismiss()
            startActivity(Intent(this, CursedActivity::class.java))
        })
    }

    private val dialogFragment
            = CursedListDialogFragment().also {
        it.setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
        it.setSelectedPuppyModel(selectedPuppyModel)
    }
    private fun openListPanel() {
        dialogFragment.show(supportFragmentManager, "TAG")
    }
}