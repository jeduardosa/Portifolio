package learn.project.digitalnoteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import learn.project.digitalnoteapp.constants.DataBaseConstants
import learn.project.digitalnoteapp.databinding.ActivityMainBinding
import learn.project.digitalnoteapp.view.adapter.NoteAdapter
import learn.project.digitalnoteapp.view.listener.OnNoteListener
import learn.project.digitalnoteapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.bottomNavMenu.FloatingActionButtonAdd.setOnClickListener { view ->
            startActivity(Intent(applicationContext, CreateNoteActivity::class.java))
        }

        val listener = object : OnNoteListener {

            override fun onClick(id: Int) {
                val intent = Intent(applicationContext, CreateNoteActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(DataBaseConstants.NOTE.ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getLoad()
            }
        }
        adapter.attachListener(listener)
        observe()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getLoad()
    }

    private fun observe() {
        viewModel.notes.observe(this) {
            adapter.updateNotes(it)
        }
    }
}