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
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy")



        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        viewModel = ViewModelProvider(this).get(CreateNoteViewModel::class.java)

        binding.btnSalvar.setOnClickListener(this)

        //chooseColor()
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
/*
    private fun chooseColor() {

        binding.imgBlue.setOnClickListener {
            selectedNoteColor = binding.imgBlue.setImageResource(R.drawable.ic_check)
            binding.imgPink.setImageResource(0)
            binding.imgWine.setImageResource(0)
            binding.imgGreen.setImageResource(0)
            binding.imgLightGray.setImageResource(0)
            binding.imgYellow.setImageResource(0)
            binding.imgWhite.setImageResource(0)

        }

        binding.imgPink.setOnClickListener {
            selectedNoteColor = binding.imgPink.setImageResource(R.drawable.ic_check)
            binding.imgBlue.setImageResource(0)
            binding.imgWine.setImageResource(0)
            binding.imgGreen.setImageResource(0)
            binding.imgLightGray.setImageResource(0)
            binding.imgYellow.setImageResource(0)
            binding.imgWhite.setImageResource(0)

        }

        binding.imgWine.setOnClickListener {
            selectedNoteColor = binding.imgWine.setImageResource(R.drawable.ic_check)
            binding.imgPink.setImageResource(0)
            binding.imgBlue.setImageResource(0)
            binding.imgGreen.setImageResource(0)
            binding.imgLightGray.setImageResource(0)
            binding.imgYellow.setImageResource(0)
            binding.imgWhite.setImageResource(0)

        }

        binding.imgGreen.setOnClickListener {
            selectedNoteColor = binding.imgGreen.setImageResource(R.drawable.ic_check)
            binding.imgPink.setImageResource(0)
            binding.imgWine.setImageResource(0)
            binding.imgBlue.setImageResource(0)
            binding.imgLightGray.setImageResource(0)
            binding.imgYellow.setImageResource(0)
            binding.imgWhite.setImageResource(0)

        }

        binding.imgLightGray.setOnClickListener {
            selectedNoteColor = binding.imgLightGray.setImageResource(R.drawable.ic_check)
            binding.imgPink.setImageResource(0)
            binding.imgWine.setImageResource(0)
            binding.imgGreen.setImageResource(0)
            binding.imgBlue.setImageResource(0)
            binding.imgYellow.setImageResource(0)
            binding.imgWhite.setImageResource(0)

        }

        binding.imgYellow.setOnClickListener {
            selectedNoteColor = binding.imgYellow.setImageResource(R.drawable.ic_check)
            binding.imgPink.setImageResource(0)
            binding.imgWine.setImageResource(0)
            binding.imgGreen.setImageResource(0)
            binding.imgLightGray.setImageResource(0)
            binding.imgBlue.setImageResource(0)
            binding.imgWhite.setImageResource(0)

        }

        binding.imgWhite.setOnClickListener {
            selectedNoteColor = binding.imgWhite.setImageResource(R.drawable.ic_check)
            binding.imgPink.setImageResource(0)
            binding.imgWine.setImageResource(0)
            binding.imgGreen.setImageResource(0)
            binding.imgLightGray.setImageResource(0)
            binding.imgYellow.setImageResource(0)
            binding.imgBlue.setImageResource(0)

        }
    }
*/
}


