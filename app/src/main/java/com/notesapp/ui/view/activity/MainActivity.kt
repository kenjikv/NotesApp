package com.notesapp.ui.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.notesapp.databinding.ActivityMainBinding
import com.notesapp.data.entity.Note
import com.notesapp.ui.view.adapter.ClickListener
import com.notesapp.ui.view.adapter.NoteAdapter
import com.notesapp.ui.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteViewModel.init(this)

        noteViewModel.loading.observe(this) { show ->
            if (show) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
            }
        }

        noteViewModel.notesModel.observe(this) { notes ->
            setAdapter(notes)
        }

        binding.addNotes.setOnClickListener{
            startActivity(Intent(this@MainActivity, ABMNoteActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        noteViewModel.getNotes()
    }

    fun setAdapter(notes: MutableList<Note>) {
        var adapter = NoteAdapter(notes)
        adapter.setClickListener(clickListener)
        binding.recycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycler.adapter = adapter
    }

    var clickListener = object:ClickListener{
        override fun onClickNote(view: View, note: Note) {
            var intent = Intent(this@MainActivity, ABMNoteActivity::class.java)
            intent.putExtra("note", note)
            startActivity(intent)
        }
    }

}