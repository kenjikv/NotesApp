package com.notesapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.notesapp.R
import com.notesapp.databinding.ActivityMainBinding
import com.notesapp.model.data.DataBaseManager
import com.notesapp.model.entity.Note
import com.notesapp.view.adapter.NoteAdapter
import com.notesapp.viewmodel.NoteViewModel
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteViewModel.notesModel.observe(this) { notes ->
            setAdapter(notes)
        }

        binding.addNotes.setOnClickListener{
            noteViewModel.getNotes()
        }
    }

    fun setAdapter(notes: MutableList<Note>) {
        var adapter = NoteAdapter(notes)
        binding.recycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycler.adapter = adapter
    }

}