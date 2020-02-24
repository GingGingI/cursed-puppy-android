package c.gingdev.cursedpuppy.ui.main

import android.os.Bundle
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import c.gingdev.cursedpuppy.ui.etc.CursedListDialogFragment
import c.gingdev.cursedpuppy.ui.etc.SelectedPuppyViewModel
import c.gingdev.cursedpuppy.utils.ui.checkBackgroundColor
import c.gingdev.cursedpuppy.utils.ui.setDebounceClickListener
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

        checkBackgroundColor(parentView)
        initView()
    }

    private fun initView() {
        parentView.setDebounceClickListener {
            openListPanel()
        }
    }

    private fun openListPanel() {
        CursedListDialogFragment().also {
            it.setSelectedPuppyModel(selectedPuppyModel)
            it.show(supportFragmentManager, "TAG")
        }

    }
}