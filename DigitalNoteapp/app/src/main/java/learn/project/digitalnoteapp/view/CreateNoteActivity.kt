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
import learn.project.digitalnoteapp.databinding.NoteModelListBinding
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.viewmodel.CreateNoteViewModel
import java.text.SimpleDateFormat

class CreateNoteActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityEditNoteBinding
    private lateinit var viewModel: CreateNoteViewModel
    private var noteId = 0



        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        viewModel = ViewModelProvider(this).get(CreateNoteViewModel::class.java)

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
                this.annotation = annotation
            }
            viewModel.save(model)
        }
    }

    private fun observe() {
        viewModel.note.observe(this) {
            binding.editTitle.setText(it.title)
            binding.editAnnotation.setText(it.annotation)

        }

        viewModel.saveNote.observe(this, Observer {
            if (it != "") {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            noteId = bundle.getInt(DataBaseConstants.NOTE.ID)
            viewModel.get(noteId)
        }
    }

}


