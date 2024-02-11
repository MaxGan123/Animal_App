package com.example.animalappreal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val data : List<Profile>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name : TextView = view.findViewById(R.id.Name)
        val description : TextView = view.findViewById(R.id.Description)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.profile, viewGroup, false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.description.text = data[position].description
    }

    override fun getItemCount(): Int {
        return data.size
    }

}