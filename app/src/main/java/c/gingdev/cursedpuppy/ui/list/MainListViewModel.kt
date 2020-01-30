package c.gingdev.cursedpuppy.ui.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.data.models.PuppyModel
import c.gingdev.cursedpuppy.data.rest.CurseService
import c.gingdev.cursedpuppy.databinding.LayoutListPuppyBinding
import com.crashlytics.android.Crashlytics
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class MainListViewModel @Inject constructor(private val retrofit: Retrofit): ViewModel() {
    val TAG = "MainListVM"

    val correctPuppy = MutableLiveData<PuppyModel>()

    var adapter: BindListAdapter<PuppyModel, LayoutListPuppyBinding>
            = object: BindListAdapter<PuppyModel, LayoutListPuppyBinding>(
        layoutRes = R.layout.layout_list_puppy,
        list = ObservableArrayList(),
        bindingVariableID = BR.puppy) {
        override fun onItemClicked(item: PuppyModel) {
            Log.e(TAG, item.name)
            correctPuppy.value = item
        }
    }

    init {
        getPuppy()
    }

    @SuppressLint("CheckResult")
    private fun getPuppy() {
        retrofit.create(CurseService::class.java)
            .getPuppyList("v1")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSuccess {
                it.forEach { puppy ->
                    adapter.list?.add(puppy)
                }
            }.subscribe()
    }
}