package com.notesapp.model.data

import com.notesapp.model.entity.Note
import java.util.*

class NoteProvider {

    companion object {
        fun getNotes(): MutableList<Note> {
            return notes
        }

        private val notes = listOf(
            Note(
                id = 1,
                title = "Nota importante!!!",
                message = "No olvidar sacar la basura el dia de hoy y comprar cafe para el desayuno",
                create = Date()
            ),
            Note(
                id = 2,
                title = "Almuerzo",
                message = "Hoy el almuerzo no olvidar con el cliente",
                create = Date()
            ),
            Note(
                id = 3,
                title = "Clases",
                message = "Hoy hay clases de la arquitectura MVVM en Android con el lenguaje kotlin y esta muy complicado creo",
                create = Date()
            ),
            Note(
                id = 4,
                title = "Clases Sabado",
                message = "La clase del dia sabado se tratara de Clean Architecture y estara mucho mas complicado pero haremos que sea mas simple",
                create = Date()
            ),
            Note(
                id = 5,
                title = "Proyecto",
                message = "No olvidar hacer el proyecto porque me dijieron desde el primer dia de clases.",
                create = Date()
            ),
        ).toMutableList()
    }
}