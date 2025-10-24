package com.responsi.h1d023079

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.responsi.h1d023079.databinding.ActivityCoachBinding
import com.responsi.h1d023079.footballclub.data.model.Coach

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coach = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("COACH_DATA", Coach::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("COACH_DATA") as? Coach
        }

        if (coach != null) {
            binding.tvCoachName.text = coach.name ?: "N/A"
            binding.tvCoachDob.text = coach.dateOfBirth ?: "N/A"
            binding.tvCoachNationality.text = coach.nationality ?: "N/A"
        }
    }
}