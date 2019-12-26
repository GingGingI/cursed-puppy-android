package c.gingdev.cursedpuppy.ui

import android.os.Bundle

abstract class InjectableActivity: BaseActivity() {
    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()
    }
}