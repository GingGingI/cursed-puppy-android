package c.gingdev.cursedpuppy

import android.os.Bundle
import c.gingdev.cursedpuppy.component.DaggerMainActivityComponent
import c.gingdev.cursedpuppy.module.ActivityModule
import c.gingdev.cursedpuppy.module.adapter.AdapterModule
import c.gingdev.cursedpuppy.ui.InjectableActivity
import c.gingdev.cursedpuppy.utils.adapter.AdapterFactory
import c.gingdev.cursedpuppy.utils.adapter.BasicAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity: InjectableActivity() {
	@Inject lateinit var retrofit: Retrofit
	@Inject lateinit var adapter: BasicAdapter
	override fun inject() {
		DaggerMainActivityComponent.builder()
			.basicNetworkComponent(App.getNetworkComponent(this))
			.activityModule(ActivityModule(this))
			.adapterModule(AdapterModule(R.layout.layout_basic))
			.build()
			.inject(this)
	}

	override fun getLayoutResId(): Int {
		return R.layout.activity_main
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		recycler.adapter = adapter.also {
			it.item.add(1)
			it.item.add(2)
			it.item.add(3)
			it.item.add(4)
			it.item.add(5)
		}
	}
}
