package c.gingdev.cursedpuppy.ui.etc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import c.gingdev.cursedpuppy.R
import c.gingdev.cursedpuppy.ui.main.MainActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Runnable {
//            Thread.sleep(2000)

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }.run()
    }
}