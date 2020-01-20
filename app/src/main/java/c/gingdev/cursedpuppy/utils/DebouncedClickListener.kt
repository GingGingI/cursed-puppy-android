package c.gingdev.cursedpuppy.utils

import android.os.SystemClock
import android.view.View

abstract class DebouncedClickListener constructor(private var defaultInterval: Int = 1000)
    : View.OnClickListener {
    private var lastTimeClicked: Long = 0

    override fun onClick(view: View?) {
        if ((SystemClock.elapsedRealtime() - lastTimeClicked) < defaultInterval) {
            return
        }

        lastTimeClicked = SystemClock.elapsedRealtime()
        debounceClicked(view)
    }

    abstract fun debounceClicked(view: View?)
}