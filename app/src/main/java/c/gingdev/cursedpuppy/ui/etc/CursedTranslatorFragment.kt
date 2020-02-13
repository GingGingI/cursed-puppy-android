package c.gingdev.cursedpuppy.ui.etc

import android.os.Bundle
import android.view.WindowManager
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseFragment
import c.gingdev.cursedpuppy.data.models.PuppyModel
import com.squareup.otto.Subscribe
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CursedTranslatorFragment(private val event: Int?): BaseFragment() {
    private val TAG = "CursedTranslatorFragment"

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    lateinit var vm: ViewModel

    override fun layoutRes(): Int {
        return when(event) {
            else -> {
                R.layout.fragment_cursed
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun binding() {
        vm = vmFactory.create(CursedTranslatorViewModel::class.java)
        binding?.run {
            this.setVariable(BR.vm, vm)
        }
    }

    @Subscribe
    fun isPuppyClicked(puppy: PuppyModel) {
        (vm as CursedTranslatorViewModel).run {
            this.cursedType = puppy.name
        }
    }
}