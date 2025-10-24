package com.responsi.h1d023079

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.responsi.h1d023079.footballclub.adapter.SquadAdapter
import com.responsi.h1d023079.databinding.ActivitySquadBinding
import com.responsi.h1d023079.footballclub.data.model.Player

class SquadActivity : AppCompatActivity(), SquadAdapter.OnPlayerClickListener {

    private lateinit var binding: ActivitySquadBinding
    private lateinit var adapter: SquadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val squad = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("SQUAD_DATA", ArrayList::class.java) as? ArrayList<Player>
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("SQUAD_DATA") as? ArrayList<Player>
        }

        if (squad != null) {
            setupRecyclerView(squad)
        } else {
            Toast.makeText(this, "Failed to load squad data", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun setupRecyclerView(players: List<Player>) {
        val actualPlayers = players.filter {
            !it.position.isNullOrEmpty() && it.position != "Coach"
        }

        adapter = SquadAdapter(actualPlayers, this)
        binding.rvSquad.adapter = adapter
        binding.rvSquad.layoutManager = LinearLayoutManager(this)
    }

    override fun onPlayerClick(player: Player) {
        val displayPosition = when (player.position) {
            "Attacker", "Forward" -> "Offence"
            else -> player.position ?: "N/A"
        }

        val playerDetailFragment = PlayerDetailFragment(
            name = player.name ?: "Unknown",
            dob = player.dateOfBirth ?: "N/A",
            nationality = player.nationality ?: "N/A",
            position = displayPosition
        )

        playerDetailFragment.show(supportFragmentManager, "PlayerDetailFragmentTag")
    }
}