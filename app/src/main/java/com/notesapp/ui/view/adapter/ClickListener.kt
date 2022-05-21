package com.notesapp.ui.view.adapter

import android.view.View
import com.notesapp.data.entity.Note

interface ClickListener {

    fun onClickNote(view: View, note: Note)
}