package c.gingdev.cursedpuppy.ui.main

import android.os.Bundle
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import kotlinx.android.synthetic.main.activity_cursed.*


class CursedActivity: BaseActivity() {
    override fun layoutRes(): Int {
        return R.layout.activity_cursed
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        toolBarCursed.run {
            title = "멈멈"
            setSupportActionBar(this)
        }

        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}