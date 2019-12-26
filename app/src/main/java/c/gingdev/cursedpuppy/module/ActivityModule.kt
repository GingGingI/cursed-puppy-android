package c.gingdev.cursedpuppy.module

import android.app.Activity
import c.gingdev.cursedpuppy.annotations.UserScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @UserScope
    fun provideActivity() = activity
}