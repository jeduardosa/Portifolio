package learn.project.digitalnoteapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import learn.project.digitalnoteapp.databinding.NoteModelListBinding
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.view.holder.NoteViewHolder
import learn.project.digitalnoteapp.view.listener.OnNoteListener

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    private var noteList: List<NoteModel> = listOf()
    private lateinit var listener: OnNoteListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val item = NoteModelListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.count()
    }

    fun updateNotes(list: List<NoteModel>) {
        noteList = list
        notifyDataSetChanged()
    }

    fun attachListener(noteListener: OnNoteListener) {
        listener = noteListener
    }
}

