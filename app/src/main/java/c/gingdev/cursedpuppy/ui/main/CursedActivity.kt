package c.gingdev.cursedpuppy.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import c.gingdev.cursedpuppy.ui.etc.CursedTranslatorViewModel
import c.gingdev.cursedpuppy.utils.ui.checkBackgroundColor
import c.gingdev.cursedpuppy.utils.ui.statusBarTransparent
import kotlinx.android.synthetic.main.activity_cursed.*
import kotlinx.android.synthetic.main.activity_cursed.parentView
import javax.inject.Inject


class CursedActivity: BaseActivity() {
    override fun layoutRes(): Int {
        return R.layout.activity_cursed
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        initView()

        statusBarTransparent()
        checkBackgroundColor(parentView)
    }

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    lateinit var vm: ViewModel

    private fun initView() {
        vm = vmFactory.create(CursedTranslatorViewModel::class.java)
            .also {
                it.cursedText.observe(this, Observer { cursedText ->
                    resultText.text = cursedText
                })
            }
        binding.setVariable(BR.translator, vm)

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