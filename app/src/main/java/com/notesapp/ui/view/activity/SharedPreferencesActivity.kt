package com.notesapp.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import com.notesapp.R
import com.notesapp.data.database.DataBaseManager
import com.notesapp.core.SharedPreferencesManager
import com.notesapp.data.entity.Note
import kotlinx.coroutines.launch
import java.util.*

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    fun loadData() {
        var email = findViewById<TextView>(R.id.tvEmail)
        email.text = SharedPreferencesManager.getString(this, "email", "NO TIENE CORREO!!!")
    }

    fun saveData(email: String) {
        SharedPreferencesManager.putString(this, "email", email)
    }

    fun onClickSaveEmail(view: View) {
        var email = findViewById<TextInputEditText>(R.id.etEmail)
        saveData(email.text.toString())
        email.setText("")
        loadData()
    }

    fun database() {
        lifecycleScope.launch {
            var list = mutableListOf<Note>(
                Note(1, "Nota 1", "Esta es mi nota 1", Date()),
                Note(2, "Nota 2", "Esta es mi nota 2", Date()),
                Note(3, "Nota 3", "Esta es mi nota 3", Date()),
                Note(4, "Nota 4", "Esta es mi nota 4", Date()),
                Note(5, "Nota 5", "Esta es mi nota 5", Date()),
                Note(6, "Nota 6", "Esta es mi nota 6", Date()),
                Note(7, "Nota 7", "Esta es mi nota 7", Date()),
                Note(8, "Nota 8", "Esta es mi nota 8", Date()),
            )

            var db = DataBaseManager.getAppDataBase(this@SharedPreferencesActivity)
            db?.noteDao()?.insert(list)

            var notes = db?.noteDao()?.getAll()
            Log.d("Notes", "Notas: ${notes?.size}")
        }
    }
}