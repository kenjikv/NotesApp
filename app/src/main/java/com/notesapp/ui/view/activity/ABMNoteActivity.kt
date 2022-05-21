package com.notesapp.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.notesapp.R
import com.notesapp.data.entity.Note
import com.notesapp.databinding.ActivityAbmnoteBinding
import com.notesapp.databinding.ActivityMainBinding
import com.notesapp.ui.viewmodel.NoteViewModel
import java.util.*

class ABMNoteActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by viewModels()

    private lateinit var binding: ActivityAbmnoteBinding

    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbmnoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.extras != null) {
            note = intent.extras!!.getSerializable("note") as Note?
            binding.title.setText(note?.title)
            binding.message.setText(note?.message)
        }

        noteViewModel.init(this)
        noteViewModel.resultInsertNote.observe(this) { result ->
            finish()
        }
        noteViewModel.resultUpdateNote.observe(this) { resutl ->
            finish()
        }
    }

    fun onClickSave(view: View) {
        if(note == null) {
            note = Note(
                id = 0,
                title = binding.title.text.toString(),
                message = binding.message.text.toString(),
                create = Date()
            )
            noteViewModel.insertNote(note!!)
        } else {
            note!!.title = binding.title.text.toString()
            note!!.message = binding.message.text.toString()
            noteViewModel.updateNote(note!!)
        }
    }
}