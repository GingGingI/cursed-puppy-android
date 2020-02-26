package c.gingdev.cursedpuppy.ui.etc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.gingdev.cursedpuppy.data.models.PuppyModel

class SelectedPuppyViewModel: ViewModel() {
//    View단에서 Data변경을 하지못하게 제한
    private val _puppyModel = MutableLiveData<PuppyModel>()
    val puppyModel: LiveData<PuppyModel> get() = _puppyModel

    fun setSelectedPuppy(puppyModel: PuppyModel) {
        this._puppyModel.value = puppyModel

        Log.e("Changed",this._puppyModel.value.toString())
    }
}