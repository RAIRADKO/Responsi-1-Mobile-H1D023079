package com.responsi.h1d023079.footballclub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.responsi.h1d023079.R
import com.responsi.h1d023079.footballclub.data.model.Player
import com.responsi.h1d023079.databinding.ListItemPlayerBinding
class SquadAdapter(
    private var players: List<Player>,
    private val onPlayerClickListener: OnPlayerClickListener // Interface for clicks
) : RecyclerView.Adapter<SquadAdapter.PlayerViewHolder>() {

    interface OnPlayerClickListener {
        fun onPlayerClick(player: Player)
    }

    inner class PlayerViewHolder(val binding: ListItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ListItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PlayerViewHolder(binding)
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]

        holder.binding.tvPlayerName.text = player.name
        holder.binding.tvPlayerNationality.text = player.nationality

        val colorRes = when (player.position) {
            "Goalkeeper" -> R.color.colorGoalkeeper
            "Defender" -> R.color.colorDefender
            "Midfielder" -> R.color.colorMidfielder
            "Attacker", "Forward" -> R.color.colorForward // API uses Attacker/Forward
            else -> R.color.colorDefault
        }
        holder.binding.playerCard.setCardBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, colorRes)
        )

        holder.binding.root.setOnClickListener {
            onPlayerClickListener.onPlayerClick(player)
        }
    }
}