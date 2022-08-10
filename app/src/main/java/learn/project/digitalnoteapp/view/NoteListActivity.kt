package learn.project.digitalnoteapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import learn.project.digitalnoteapp.databinding.ActivityNoteListBinding
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.view.adapter.NoteAdapter
import learn.project.digitalnoteapp.viewmodel.NoteListViewModel

class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding
    private var noteModelList: MutableList<NoteModel> = mutableListOf()
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var viewModel: NoteListViewModel
    private val recyclerView = binding.recyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView.adapter = noteAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
       //viewModel.get()
    }

    override fun onDestroy() {
        super.onDestroy()
        //save()
    }

}