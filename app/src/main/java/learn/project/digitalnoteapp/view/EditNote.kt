package learn.project.digitalnoteapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import learn.project.digitalnoteapp.R
import learn.project.digitalnoteapp.databinding.ActivityEditNoteBinding
import learn.project.digitalnoteapp.viewmodel.EditNoteViewModel

class EditNote : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityEditNoteBinding
    private lateinit var viewModel: EditNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(EditNoteViewModel::class.java)

        binding.btnSalvar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.btnSalvar) {
            val title = binding.editTitle.text.toString()
            val annotation = binding.editAnnotation.text.toString()



            }
        }
    }
