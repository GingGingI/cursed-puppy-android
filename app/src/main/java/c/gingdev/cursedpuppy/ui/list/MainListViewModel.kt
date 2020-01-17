package c.gingdev.cursedpuppy.ui.list

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.data.models.PuppyModel
import c.gingdev.cursedpuppy.data.rest.CurseService
import c.gingdev.cursedpuppy.databinding.LayoutListPuppyBinding
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class MainListViewModel @Inject constructor(private val retrofit: Retrofit): ViewModel() {
    val TAG = "MainListVM"

    var adapter: BindListAdapter<PuppyModel, LayoutListPuppyBinding>
            = object: BindListAdapter<PuppyModel, LayoutListPuppyBinding>(
        layoutRes = R.layout.layout_list_puppy,
        list = ObservableArrayList(),
        bindingVariableID = BR.puppy) {}

    init {
        getPuppy()
    }

    private fun getPuppy() {
        retrofit.create(CurseService::class.java)
            .getPuppyList("v1")
            .doOnSuccess {
                it.forEach { puppy ->
                    adapter.list?.add(puppy)
                }
            }.doOnError {
                Log.e(TAG, it.message ?: "unknown")
            }.subscribeOn(Schedulers.io())
            .subscribe()
    }
}