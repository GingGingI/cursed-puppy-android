package c.gingdev.cursedpuppy.ui.etc

import android.annotation.SuppressLint
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import c.gingdev.cursedpuppy.data.models.CursedRequestModel
import c.gingdev.cursedpuppy.data.rest.CurseService
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class CursedTranslatorViewModel @Inject constructor(private val retrofit: Retrofit): ViewModel() {
    private val TAG = "CursedTranslatorVM"

    val cursedText = ObservableField<String>()
    var cursedType: String? = null

//    EditText Change Listener
    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//        onText Changed
        Log.e(TAG, s.toString())

        getCursedText(s.toString())
    }

//    getting CursedText
    @SuppressLint("CheckResult")
    private fun getCursedText(str: String) {
        Observable.just(str)
            .map { str ->
                Log.e(TAG, "str : $str , type: $cursedType")
                CursedRequestModel(cursedType ?: "멈뭄미", str)
            }.subscribe { curseModel ->
                retrofit.create(CurseService::class.java)
                    .getCursedText("v1", curseModel)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .doOnSuccess {
                        Log.e(TAG, "success : ${it.success}. text : ${it.text}")
                        cursedText.set(it.text)
                    }.subscribe()
            }
    }
}