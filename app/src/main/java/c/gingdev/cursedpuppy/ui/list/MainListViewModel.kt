package c.gingdev.cursedpuppy.ui.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.gingdev.cursedpuppy.data.rest.CurseService
import c.gingdev.cursedpuppy.di.component.DaggerListVMComponet
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class MainListViewModel @Inject constructor(private val retrofit: Retrofit): ViewModel() {
    val TAG = "MainListVM"

    var helloText = MutableLiveData<String>()

    init {
        getPuppy()
    }

    private fun getPuppy() {
        retrofit.create(CurseService::class.java)
            .getPuppyList("v1")
            .doOnSuccess {
                it.forEach { puppy ->
                    Log.i(TAG, puppy.name)
                }
            }.doOnError {
                Log.e(TAG, it.message ?: "unknown")
            }.subscribeOn(Schedulers.io())
            .subscribe()
    }
}