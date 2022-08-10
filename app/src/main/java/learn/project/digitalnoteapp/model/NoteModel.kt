package learn.project.digitalnoteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
class NoteModel{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "titulo")
    var title: String = ""

    @ColumnInfo(name = "CXtexo")
    var cxtext: String = ""

}


