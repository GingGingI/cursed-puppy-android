package c.gingdev.cursedpuppy.utils.event

import android.os.Handler
import android.os.Looper
import com.squareup.otto.Bus

object PuppyEventBus: Bus() {
    var registeredObjects = arrayListOf<Any?>()


    /*register*/
    override fun register(obj: Any?) {
        obj.notContainedByObjects {
            registeredObjects.add(obj)
            super.register(obj)
        }
    }

    override fun unregister(obj: Any?) {
        obj.containedByObjects {
            registeredObjects.remove(obj)
            super.unregister(obj)
        }
    }

    fun unregisterAll() {
//        모두 찾아서 unregister
        for (obj in registeredObjects)
            unregister(obj)
//        전부 unregister한뒤 clear
        registeredObjects.clear()
        registeredObjects = arrayListOf()
    }


    /*Post*/
    override fun post(event: Any?) {
        if (Looper.myLooper() == Looper.getMainLooper())
            super.post(event)
        else {
            Handler(Looper.getMainLooper()).post {
                super.post(event)
            }
        }
    }

    /*etc*/
    private infix fun Any?.containedByObjects(f: () -> Unit) {
        if (registeredObjects.contains(this)) f()
    }
    private infix fun Any?.notContainedByObjects(f: () -> Unit) {
        if (!registeredObjects.contains(this)) f()
    }
}