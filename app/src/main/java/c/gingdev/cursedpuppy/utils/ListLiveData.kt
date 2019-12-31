package c.gingdev.cursedpuppy.utils

import androidx.lifecycle.LiveData

class ListLiveData<T>: LiveData<ArrayList<T>>() {
    private val arrayData: ArrayList<T> = ArrayList()

    fun add(item: T?) {
        item NotNull {
            arrayData.add(it)
            this.value = arrayData
        }
    }

    fun remove(item: T?) {
        item NotNull {
            arrayData.remove(it)
            this.value = arrayData
        }
    }
}