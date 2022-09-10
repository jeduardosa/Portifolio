package learn.project.digitalnoteapp.repository

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import learn.project.digitalnoteapp.model.NoteModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class NoteRepository private constructor(context: Context) {

    private val noteDatabase = NoteDatabase.getDataBase(context).NoteDAO()

    companion object {
        private lateinit var repository: NoteRepository


        fun getInstance(context: Context): NoteRepository {

            if (!::repository.isInitialized) {
                repository = NoteRepository(context)
            }
            return repository
        }
    }

    fun insert(note: NoteModel): Boolean {

        return noteDatabase.insert(note) > 0
    }

    fun update(note: NoteModel): Boolean {
        return noteDatabase.update(note) > 0
    }

    fun delete(id: Int) {
        val note = get(id)
        noteDatabase.delete(note)
    }

    fun get(id: Int): NoteModel {
        return noteDatabase.get(id)
    }

    fun getLoad(): List<NoteModel> {
        return noteDatabase.getLoad()
    }

    fun getDate() {
        //return SimpleDateFormat("dd/MM/yyyy").format(trans.created_date.toDate())
    }
}