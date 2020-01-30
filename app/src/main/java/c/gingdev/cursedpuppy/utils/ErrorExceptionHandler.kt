package c.gingdev.cursedpuppy.utils

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Process
import c.gingdev.cursedpuppy.base.App
import c.gingdev.cursedpuppy.base.BaseActivityLifecycleCallbacks
import c.gingdev.cursedpuppy.ui.etc.ErrorActivity
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.system.exitProcess

class ErrorExceptionHandler(
    app: Application,
    private val defaultExceptionHandler: Thread.UncaughtExceptionHandler,
    private val fabricExceptionHandler: Thread.UncaughtExceptionHandler
): Thread.UncaughtExceptionHandler {
//    마지막 액티비티와 현재 에러가 일어나있는 액티비티 갯수
    private var lastActivity: Activity? = null
    private var activityCnt = 0

    init {
        app.registerActivityLifecycleCallbacks(object : BaseActivityLifecycleCallbacks() {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                if (activity.isSkipActivity()) {
                    return
                }
                lastActivity = activity
            }

            override fun onActivityStarted(activity: Activity) {
                if (activity.isSkipActivity()) {
                    return
                }
                activityCnt++
                lastActivity = activity
            }

            override fun onActivityStopped(activity: Activity) {
                if (activity.isSkipActivity()) {
                    return
                }
                activityCnt--
                if (activityCnt < 0) {
                    lastActivity = null
                }
            }
        })
    }

    private fun Activity.isSkipActivity() = this is ErrorActivity

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        fabricExceptionHandler.uncaughtException(thread, throwable)
        lastActivity?.run {
            val stringWriter = StringWriter()
            throwable.printStackTrace(PrintWriter(stringWriter))

            startErrorActivity(this, stringWriter.toString())
        } ?: defaultExceptionHandler.uncaughtException(thread, throwable)

        Process.killProcess(Process.myPid())
        exitProcess(-1)
    }

    private fun startErrorActivity(activity: Activity, errorText: String) = activity.run {
        val errorActivityIntent = Intent(this, ErrorActivity::class.java)
            .apply {
                putExtra(ErrorActivity.EXTRA_INTENT, intent)
                putExtra(ErrorActivity.EXTRA_ERROR_TEXT, errorText)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        startActivity(errorActivityIntent)
        finish()
    }
}