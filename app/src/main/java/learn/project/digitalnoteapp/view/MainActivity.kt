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

/*
        binding.FloatingActionButtonAdd.setOnClickListener {
            val Intent = Intent(this, CreateNotesFragment::class.java)
            startActivity(Intent)
        } */

        //testeNotas()

    }
/*
    private fun testeNotas(){
        val notas1 = Note( "lista de compras", "Lorem ipsum bla bla bla", "Ultima edição: ")
        noteList.add(notas1)
        val notas2 = Note( "lista de compras1", "Lorem ipsum bla bla bla1", "Ultima edição: ")
        noteList.add(notas2)
        val notas3 = Note( "lista de compras2", "Lorem ipsum bla bla bla2", "Ultima edição: ")
        noteList.add(notas3)
        val notas4 = Note( "lista de compras3", "Lorem ipsum bla bla bla3", "Ultima edição: ")
        noteList.add(notas4)
    }*/
}