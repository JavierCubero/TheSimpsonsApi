package edu.iesam.thesimpsonsapi.features.simpsons.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import edu.iesam.thesimpsonsapi.R
import edu.iesam.thesimpsonsapi.features.simpsons.domain.Character

class SimpsonsListAdapter(private val characters: List<Character>):
    RecyclerView.Adapter<SimpsonsListAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameCharacter: TextView
        val ageCharacter: TextView
        val praseCharacter: TextView
        val imageCharacter: ImageView
        init {
            nameCharacter = view.findViewById(R.id.nameCharacter)
            ageCharacter = view.findViewById(R.id.ageCharacter)
            praseCharacter = view.findViewById(R.id.prhaseCharacter)
            imageCharacter = view.findViewById(R.id.imageCharacter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameCharacter.text = characters[position].name
        holder.ageCharacter.text = characters[position].age.toString()
        holder.praseCharacter.text = characters[position].phrase
        holder.imageCharacter.load(characters[position].urlImage)
    }

    override fun getItemCount() = characters.size

}