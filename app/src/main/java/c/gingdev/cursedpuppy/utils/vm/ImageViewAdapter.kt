package c.gingdev.cursedpuppy.utils.vm

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import c.gingdev.cursedpuppy.R
import com.bumptech.glide.Glide

object ImageViewAdapter {

    @JvmStatic
    @BindingAdapter(value = ["app:loadImage"], requireAll = true)
    fun loadImage(imageView: ImageView, imageUrl: String) {
        if (imageUrl.isNotEmpty()) {
            Glide.with(imageView.context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }

}