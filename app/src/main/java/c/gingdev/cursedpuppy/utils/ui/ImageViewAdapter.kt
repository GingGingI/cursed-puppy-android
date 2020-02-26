package c.gingdev.cursedpuppy.utils.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import c.gingdev.cursedpuppy.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

object ImageViewAdapter {

    @JvmStatic
    @BindingAdapter(value = ["app:loadImage"], requireAll = true)
    fun loadImage(imageView: ImageView, imageUrl: String?) {
        if (imageUrl?.isNotEmpty() == true) {
            Glide.with(imageView.context)
                .load(imageUrl)
                .transform(RoundedCorners(25))
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }
}