package vn.iostar.tuan4

import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class bai02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bai02)

        val sw = findViewById<Switch>(R.id.switch1)
        val bg = findViewById<ConstraintLayout>(R.id.constraintLayout1)
        sw.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked)
                bg.setBackgroundResource(R.drawable.bg3)
            else
                bg.setBackgroundResource(R.drawable.bg4)

        }
    }


}