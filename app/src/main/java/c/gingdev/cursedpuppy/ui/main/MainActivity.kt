package c.gingdev.cursedpuppy.ui.main

import android.os.Bundle
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import c.gingdev.cursedpuppy.ui.list.MainListFragment
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity: BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.mainFrame, MainListFragment()).commit()
        }
    }
}