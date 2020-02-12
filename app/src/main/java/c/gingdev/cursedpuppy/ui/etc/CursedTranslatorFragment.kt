package c.gingdev.cursedpuppy.ui.etc

import android.os.Bundle
import android.view.WindowManager
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseFragment

class CursedTranslatorFragment(private val event: Int?): BaseFragment() {

    override fun layoutRes(): Int {
        return when(event) {
            else -> {
                R.layout.fragment_cursed
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun binding() {
    }
}