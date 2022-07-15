package learn.project.digitalnoteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import learn.project.digitalnoteapp.Note
import learn.project.digitalnoteapp.NoteAdapter
import learn.project.digitalnoteapp.R
import learn.project.digitalnoteapp.databinding.ActivityMainBinding
import learn.project.digitalnoteapp.repository.SQLiteHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var noteList: MutableList<Note> = mutableListOf()
    private lateinit var noteAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        noteAdapter = NoteAdapter(this, noteList)
        recyclerView.adapter = noteAdapter

        binding.FloatingActionButtonAdd.setOnClickListener {
            val Intent = Intent(this, EditDetailsNote::class.java)
            startActivity(Intent)
        }



    }

}