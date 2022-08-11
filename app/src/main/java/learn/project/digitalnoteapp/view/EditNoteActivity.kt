package learn.project.digitalnoteapp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import learn.project.digitalnoteapp.R
import learn.project.digitalnoteapp.constants.DataBaseConstants
import learn.project.digitalnoteapp.databinding.ActivityEditNoteBinding
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.viewmodel.EditNoteViewModel

class EditNoteActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityEditNoteBinding
    private lateinit var viewModel: EditNoteViewModel
    private var noteId = 0
    private var noteTitle = ""
    private var noteAnnotation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(EditNoteViewModel::class.java)

        binding.btnSalvar.setOnClickListener(this)

        observe()
        loadData()
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.btnSalvar) {
            val title = binding.editTitle.text.toString()
            val annotation = binding.editAnnotation.text.toString()

            val model = NoteModel().apply {
                this.id = noteId
                this.title = title
                this.cxtext = annotation
            }
            viewModel.save(model)
        }
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            noteId = bundle.getInt(DataBaseConstants.NOTE.ID)
            noteTitle = bundle.getInt(DataBaseConstants.NOTE.COLUMNS.TITLE).toString()
            noteAnnotation = bundle.getInt(DataBaseConstants.NOTE.COLUMNS.ANNOTATION).toString()
            viewModel.get(noteId)
            viewModel.getText(noteTitle, noteAnnotation)
        }
    }

    private fun observe() {

        viewModel.saveNote.observe(this, Observer {
            if (it != "") {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }
}


