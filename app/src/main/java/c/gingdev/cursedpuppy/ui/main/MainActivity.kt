package c.gingdev.cursedpuppy.ui.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import c.gingdev.cursedpuppy.data.models.PuppyModel
import c.gingdev.cursedpuppy.ui.list.MainListFragment
import c.gingdev.cursedpuppy.utils.ui.checkBackgroundColor
import c.gingdev.cursedpuppy.utils.ui.getStatusBarHeight
import c.gingdev.cursedpuppy.utils.ui.statusBarTransparent
import com.squareup.otto.Subscribe
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity: BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.mainFrame, MainListFragment()).commit()
        }

        initDrawer()
        checkBackgroundColor(drawerLayout)
    }

    private fun initDrawer() {
        getStatusBarHeight().run {
            statusBar.layoutParams.height = this
            navStatusBar.layoutParams.height = this
        }

        val drawerToggle = object: ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_left_arrow, R.drawable.ic_left_arrow) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = navDrawer.width * slideOffset

                layoutFrame.apply {
                    translationX = slideX * -0.3f
                }
            }
        }

        drawerLayout.apply {
            layoutParams.width = resources.displayMetrics.widthPixels
            drawerElevation = 0f

            setScrimColor(Color.TRANSPARENT)
            addDrawerListener(drawerToggle)
            requestLayout()
        }
    }

    @Subscribe
    fun isPuppyClicked(puppy: PuppyModel) {
        Log.e("Main", puppy.name)
        drawerLayout.openDrawer(GravityCompat.END)
    }
}