package learn.project.digitalnoteapp.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import learn.project.digitalnoteapp.model.NoteModel


@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase() : RoomDatabase() {

    abstract fun NoteDAO(): NoteDAO

    companion object {
        private lateinit var INSTANCE: NoteDatabase

        fun getDataBase(context: Context): NoteDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(NoteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, NoteDatabase::class.java, "notedb")
                        .addMigrations(/* MIGRATION_VERSION */)
                        .allowMainThreadQueries()
                        .build()
                }
            }

            return INSTANCE
        }

        private val MIGRATION_VERSION: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                TODO("Not yet implemented")
            }

        }
    }
}