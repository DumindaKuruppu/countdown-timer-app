package com.example.timersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.timersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var countDownTimer: CountDownTimer? = null
    private var timerDuration: Long = 60000
    private var pauseOffset: Long = 0

    private var binding : ActivityMainBinding? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.textView3?.text = (timerDuration/1000).toString()

        binding?.button?.setOnClickListener {
            startTimer(pauseOffset)
        }

        binding?.button2?.setOnClickListener {
            pauseTimer()
        }

        binding?.button3?.setOnClickListener {
            resetTimer()
        }


    }

    private fun resetTimer() {
        if (countDownTimer != null) {
            countDownTimer!!.cancel()
            binding?.textView3?.text = (timerDuration/1000).toString()
            countDownTimer = null
            pauseOffset = 0
        }

    }

    private fun pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer!!.cancel()
        }
    }

    private fun startTimer(pauseOffsetL: Long) {

        countDownTimer = object : CountDownTimer(timerDuration - pauseOffsetL, 1000) {
            override fun onTick(milisUntilFinished: Long) {
                pauseOffset = timerDuration - milisUntilFinished
                binding?.textView3?.text = (milisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Timer Finished", Toast.LENGTH_SHORT).show()
            }

        }.start()


    }
}