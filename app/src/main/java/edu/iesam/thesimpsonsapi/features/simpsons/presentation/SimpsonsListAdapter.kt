package edu.iesam.thesimpsonsapi.features.simpsons.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import edu.iesam.thesimpsonsapi.R
import edu.iesam.thesimpsonsapi.databinding.ViewItemCharacterBinding
import edu.iesam.thesimpsonsapi.features.simpsons.domain.Character

class SimpsonsListAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<SimpsonsListAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ViewItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.apply {
                nameCharacter.text = character.name
                ageCharacter.text = character.age?: "Edad N/D"
                prhaseCharacter.text = "\" ${character.phrase} \""
                imageCharacter.load(character.urlImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ViewItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

}