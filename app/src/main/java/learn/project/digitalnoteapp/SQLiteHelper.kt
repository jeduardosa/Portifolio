package learn.project.digitalnoteapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

            companion object {
                private const val DATABASE_VERSION = 1
                private const val DATABASE_NAME = "note_db"
                private const val TBL_NOTE = "note_db"
                private const val ID = "id"
                private const val TITLE = "title"
                private const val CXTEXTO = "cx_texto"
            }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblNote = ("CREATE TABLE " + TBL_NOTE + "(" + ID + "INTERGER PRIMARY KEY,"
                + TITLE + "TEXT," + CXTEXTO + "TEXT" + ")")
        db?.execSQL(createTblNote)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_NOTE")
        onCreate(db)
    }

    fun insertNote(std: Note): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, std.id)
        contentValues.put(TITLE, std.titulo)
        contentValues.put(CXTEXTO, std.cxtexto)

        val success = db.insert(TBL_NOTE, null, contentValues)
        db.close()
        return success
    }



}