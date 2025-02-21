package vn.iostar.tuan4

import android.widget.Switch
import android.widget.CompoundButton
import android.widget.Toast
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val img1 = findViewById<View>(R.id.imageView1) as ImageView
        img1.setImageResource(R.drawable.kotlin)
       /* val bg = findViewById<View>(R.id.constraintLayout1) as ConstraintLayout*/
        val bg = findViewById<ConstraintLayout>(R.id.constraintLayout1)

// Danh sách hình nền
        val backgrounds = listOf(
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg4
        )

// Chọn hình nền ngẫu nhiên
        val randomBg = backgrounds.random()
        bg.setBackgroundResource(randomBg)
        /* bg.setBackgroundColor(Color.BLUE)
         bg.setBackgroundResource(R.drawable.bg2)*/


        // Sử dụng ArrayList<Integer> như Java
        val arrayList = ArrayList<Int>()
        arrayList.add(R.drawable.bg1)
        arrayList.add(R.drawable.bg2)
        arrayList.add(R.drawable.bg3)
        arrayList.add(R.drawable.bg4)

        val random: Random = Random()
        val vitri: Int = random.nextInt(arrayList.size)

        bg.setBackgroundResource(arrayList[vitri])

        val img2 = findViewById<View>(R.id.imageButton1) as ImageButton
        img2.setOnClickListener {
            img1.setImageResource(R.drawable.dart)
            img1.layoutParams.width = 550
            img1.layoutParams.height = 550
        }

        val sw = findViewById<Switch>(R.id.switch1)
        sw.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Wifi đang bật", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Wifi đang tắt", Toast.LENGTH_LONG).show()
            }
        }

      /*  val bg = findViewById<ConstraintLayout>(R.id.constraintLayout1)
        val ck1 = findViewById<CheckBox>(R.id.checkBox)

        ck1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                bg.setBackgroundResource(R.drawable.bg3)
            } else {
                bg.setBackgroundResource(R.drawable.bg4)
            }
        }
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButton -> bg.setBackgroundResource(R.drawable.bg3)
                R.id.radioButton2 -> bg.setBackgroundResource(R.drawable.bg4)
            }
        }*/
       /* val progressBar = findViewById<ProgressBar>(R.id.progressBar2)

        img2.setOnClickListener {
            val current = progressBar.progress
            progressBar.progress = current + 10
        }*/
       /* val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        img2.setOnClickListener {
            var current = progressBar.progress
            // Nếu đạt max (>100), reset về 0
            if (current >= progressBar.max) {
                current = 0
            }
            progressBar.progress = current + 10 // Cập nhật progress
        }*/
       /* val progressBar = findViewById<ProgressBar>(R.id.progressBar2)

        img2.setOnClickListener {
            object : CountDownTimer(10000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    var current = progressBar.progress
                    // Nếu đạt max (>100), reset về 0
                    if (current >= progressBar.max) {
                        current = 0
                    }
                    progressBar.progress = current + 10 // Cập nhật progress
                }

                override fun onFinish() {
                    Toast.makeText(this@MainActivity, "Hết giờ", Toast.LENGTH_LONG).show()
                }
            }.start()
        }
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // progress: Giá trị của SeekBar
                Log.d("AAA", "Giá trị: $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("AAA", "Start")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("AAA", "Stop")
            }
        })*/






    }
}