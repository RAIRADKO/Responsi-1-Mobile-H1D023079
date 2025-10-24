package com.responsi.h1d023079

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.responsi.h1d023079.databinding.ActivityMainBinding
import com.responsi.h1d023079.footballclub.data.model.TeamResponse
import com.responsi.h1d023079.footballclub.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var currentTeamData: TeamResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchTeamDetails(340)

        viewModel.teamData.observe(this) { teamResponse ->
            currentTeamData = teamResponse
            teamResponse?.let {
                binding.tvClubNameHeader.text = it.name ?: "Southampton FC"
            }
        }

        viewModel.error.observe(this) { errorMsg ->
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
        }

        binding.cardClubHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.cardCoach.setOnClickListener {
            currentTeamData?.coach?.let { coach ->
                val intent = Intent(this, CoachActivity::class.java)
                intent.putExtra("COACH_DATA", coach)
                startActivity(intent)
            } ?: run {
                Toast.makeText(this, "Data pelatih belum tersedia. Silakan tunggu...", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cardSquad.setOnClickListener {
            currentTeamData?.squad?.let { squad ->
                if (squad.isNotEmpty()) {
                    val intent = Intent(this, SquadActivity::class.java)
                    intent.putExtra("SQUAD_DATA", ArrayList(squad))
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Data skuad kosong", Toast.LENGTH_SHORT).show()
                }
            } ?: run {
                Toast.makeText(this, "Data skuad belum tersedia. Silakan tunggu...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}