package learn.project.digitalnoteapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import learn.project.digitalnoteapp.Note
import learn.project.digitalnoteapp.R
import learn.project.digitalnoteapp.databinding.ActivityEditDetailsNoteBinding
import learn.project.digitalnoteapp.repository.SQLiteHelper

class EditDetailsNote : AppCompatActivity() {
    private lateinit var sqLiteHelper: SQLiteHelper

    private lateinit var binding: ActivityEditDetailsNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_details_note)

        binding = ActivityEditDetailsNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)



    binding.btnSalvar = View.OnClickListener{
        salveNotes()
    }

    }


    private fun salveNotes(): SQLiteHelper {
        sqLiteHelper.insertNote(Note("teste", "teste", "10/12/2001",))
        //finish()
    }

}