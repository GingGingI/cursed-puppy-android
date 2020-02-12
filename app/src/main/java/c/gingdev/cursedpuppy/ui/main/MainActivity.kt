package c.gingdev.cursedpuppy.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.drawerlayout.widget.DrawerLayout
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import c.gingdev.cursedpuppy.data.models.PuppyModel
import c.gingdev.cursedpuppy.ui.etc.CursedTranslatorFragment
import c.gingdev.cursedpuppy.ui.list.MainListFragment
import c.gingdev.cursedpuppy.utils.ui.checkBackgroundColor
import c.gingdev.cursedpuppy.utils.ui.disableScroll
import c.gingdev.cursedpuppy.utils.ui.getStatusBarHeight
import com.squareup.otto.Subscribe
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity: BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.mainFrame, MainListFragment())
                .add(R.id.navFrame, CursedTranslatorFragment(null))
                .commit()
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

//            Drawer Swipe Lock 설정
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        navBackButton.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.END)
        }
        navDrawer.disableScroll()
        ViewCompat.setOnApplyWindowInsetsListener(navFrame) {v, insets ->
            insets.replaceSystemWindowInsets(0, 0, 0, insets.systemWindowInsetBottom).apply {
                ViewCompat.onApplyWindowInsets(v, this)
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
        navTitleView.text = puppy.name
        titleView.text = puppy.name

        drawerLayout.openDrawer(GravityCompat.END)
    }
}