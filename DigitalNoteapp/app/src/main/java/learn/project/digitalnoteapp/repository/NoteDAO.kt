package learn.project.digitalnoteapp.repository

import androidx.room.*
import learn.project.digitalnoteapp.model.NoteModel

@Dao
interface NoteDAO {

    @Insert
    fun insert(note: NoteModel): Long

    @Update
    fun update(note: NoteModel): Int

    @Delete
    fun delete(note: NoteModel)

    @Query("SELECT * FROM Note WHERE id = :id")
    fun get(id: Int): NoteModel

    @Query("SELECT * FROM Note")
    fun getLoad(): List<NoteModel>


}
