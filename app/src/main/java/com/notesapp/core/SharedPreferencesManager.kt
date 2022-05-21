package com.notesapp.core

import android.content.Context

class SharedPreferencesManager {

    companion object {
        val NAME_PREFERENCES = "MisPreferencias"

        fun getString(context: Context, key: String, defaultString: String = ""): String? {
            var sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE)
            var text = sharedPreferences.getString(key, defaultString)
            return text
        }

        fun putString(context: Context, key: String, value: String) {
            var sharedPreferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            editor.putString(key, value)
            editor.commit()
        }
    }

}