package c.gingdev.cursedpuppy.utils.ui

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.utils.DebouncedClickListener
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView

fun Activity.statusBarTransparent() {
    window.apply {
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        statusBarColor = Color.TRANSPARENT
    }
}

fun Activity.statusBarColor(@ColorRes color: Int) {
    window.apply {
        statusBarColor = resources.getColor(color)
    }
}

private fun Window.setWindowFlag(flag: Int, on: Boolean) {
    apply {
        if (on)
            attributes.flags = attributes.flags or flag
        else
            attributes.flags = attributes.flags and flag.inv()
    }
}

fun Activity.getStatusBarHeight(): Int {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0)
        result = resources.getDimensionPixelSize(resourceId)
    return result
}

fun Activity.checkBackgroundColor(view: View): Int {
    var color: Int
    if (ColorChecker(view).isLight()) {
//            현제 밝음
        color = ContextCompat.getColor(this, R.color.colorBlack)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        else
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

    } else {
//            현재 어두움.
        color = ContextCompat.getColor(this, R.color.colorWhite)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or 0
        else
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    return color
}

fun View.setDebounceClickListener(f: () -> Unit) {
    this.setOnClickListener(object: DebouncedClickListener() {
        override fun debounceClicked(view: View?) {
            f()
        }
    })
}