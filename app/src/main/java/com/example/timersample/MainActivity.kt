package com.example.timersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
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
        TODO("Not yet implemented")
    }

    private fun pauseTimer() {
        TODO("Not yet implemented")
    }

    private fun startTimer(pauseOffset: Long) {

    }
}