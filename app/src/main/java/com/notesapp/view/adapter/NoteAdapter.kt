package com.notesapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.notesapp.R
import com.notesapp.model.entity.Note
import java.text.SimpleDateFormat

class NoteAdapter(): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var notes: MutableList<Note> = mutableListOf()

    constructor(notes: MutableList<Note>): this() {
        this.notes = notes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = notes[position]
        holder.title.text = item.title
        holder.message.text = item.message
        holder.create.text = SimpleDateFormat("yyyy-MM-hh").format(item.create)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var message = itemView.findViewById<TextView>(R.id.message)
        var create = itemView.findViewById<TextView>(R.id.create)
    }
}