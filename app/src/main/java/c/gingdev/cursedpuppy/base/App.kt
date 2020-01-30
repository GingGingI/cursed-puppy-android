package c.gingdev.cursedpuppy.base

import android.util.Log
import c.gingdev.cursedpuppy.di.component.AppComponent
import c.gingdev.cursedpuppy.di.component.DaggerAppComponent
import c.gingdev.cursedpuppy.utils.ErrorExceptionHandler
import c.gingdev.cursedpuppy.utils.event.PuppyEventBus
import com.crashlytics.android.Crashlytics
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.fabric.sdk.android.Fabric
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import java.io.IOError
import java.io.IOException
import java.net.SocketException

/**
 * Dagger의 class 중 가장 base Class
 * */
class App: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component: AppComponent = DaggerAppComponent.builder().application(this).build()
        setCrashHandler()
        component.inject(this)

        return component
    }

    private fun setCrashHandler() {
        setRxErrorHandler()
        val defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { _, _ -> /* Crashlytics에서 기본 handler를 호출하기 때문에 이중으로 호출되는것을 막기위해 빈 handler로 설정 */ }
        Fabric.with(this, Crashlytics())
        val fabricExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(
            ErrorExceptionHandler(
                this,
                defaultExceptionHandler,
                fabricExceptionHandler
            )
        )
    }

    private fun setRxErrorHandler() {
        RxJavaPlugins.setErrorHandler { e ->
            var error = e
            if (error is UndeliverableException) {
                error = e.cause
            }
            if (error is IOException || error is SocketException) {
                // fine, irrelevant network problem or API that throws on cancellation
                return@setErrorHandler
            }
            if (error is InterruptedException) {
                // fine, some blocking code was interrupted by a dispose call
                return@setErrorHandler
            }
            if (error is NullPointerException || error is IllegalArgumentException) {
                // that's likely a bug in the application
                Thread.currentThread().uncaughtExceptionHandler
                    .uncaughtException(Thread.currentThread(), error)
                return@setErrorHandler
            }
            if (error is IllegalStateException) {
                // that's a bug in RxJava or in a custom operator
                Thread.currentThread().uncaughtExceptionHandler
                    .uncaughtException(Thread.currentThread(), error)
                return@setErrorHandler
            }
            Thread.currentThread().uncaughtExceptionHandler
                .uncaughtException(Thread.currentThread(), error)
        }
    }
}