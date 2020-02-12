package c.gingdev.cursedpuppy.ui.etc

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class CursedTranslatorViewModel @Inject constructor(private val retrofit: Retrofit): ViewModel() {
    private val TAG = "CursedTranslatorVM"

    val cursedText = MutableLiveData<String>()

//    EditText Change Listener
    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//        onText Changed

    }

//    getting CursedText
    private fun getCursedText(str: String) {

    }
}