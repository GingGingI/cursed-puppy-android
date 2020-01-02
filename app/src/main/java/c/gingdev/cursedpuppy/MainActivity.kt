package c.gingdev.cursedpuppy

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import c.gingdev.cursedpuppy.component.DaggerMainActivityComponent
import c.gingdev.cursedpuppy.ui.InjectableActivity
import c.gingdev.cursedpuppy.utils.BindableAdapter
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity: InjectableActivity() {
	@Inject lateinit var retrofit: Retrofit
	@Inject lateinit var adapter: BindableAdapter<Any?, ViewDataBinding>
	override fun inject() {
		DaggerMainActivityComponent.builder()
			.basicNetworkComponent(App.getNetworkComponent(this))
			.build()
			.inject(this)
	}

	override fun getLayoutResId(): Int {
		return R.layout.activity_main
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


	}
}
