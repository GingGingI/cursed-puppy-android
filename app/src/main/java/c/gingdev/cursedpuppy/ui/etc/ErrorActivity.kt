package c.gingdev.cursedpuppy.ui.etc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import c.gingdev.cursedpuppy.BR
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.base.BaseActivity
import c.gingdev.cursedpuppy.databinding.ActivityErrorBinding
import c.gingdev.cursedpuppy.utils.ui.checkBackgroundColor
import kotlinx.android.synthetic.main.activity_error.*

class ErrorActivity: BaseActivity() {
    private val TAG = "ERRORACTIVITY"

    private val lastActivityIntent by lazy { intent.getParcelableExtra<Intent>(EXTRA_INTENT) }
    private val errorText by lazy { intent.getStringExtra(EXTRA_ERROR_TEXT) }

    override fun layoutRes(): Int {
        return R.layout.activity_error
    }

    override fun onCreated(savedInstanceState: Bundle?) {
//        Log.e("errorActivity", errorText)
        Log.e(TAG, "$lastActivityIntent")

        binding.setVariable(BR.errorText, errorText)

        (binding as ActivityErrorBinding).retryButton.setOnClickListener {
            startActivity(lastActivityIntent)
            finish()
        }

        checkBackgroundColor(parentView)
    }

    companion object {
        const val EXTRA_INTENT = "EXTRA_INTENT"
        const val EXTRA_ERROR_TEXT = "EXTRA_ERROR_TEXT"
    }
}