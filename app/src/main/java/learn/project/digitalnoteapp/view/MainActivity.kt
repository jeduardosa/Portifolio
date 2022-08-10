package learn.project.digitalnoteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.view.adapter.NoteAdapter
import learn.project.digitalnoteapp.R
import learn.project.digitalnoteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var noteModelList: MutableList<NoteModel> = mutableListOf()
    private lateinit var noteAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.FloatingActionButtonAdd.setOnClickListener {
            val Intent = Intent(this, EditNote::class.java)
            startActivity(Intent)
        }



    }

}