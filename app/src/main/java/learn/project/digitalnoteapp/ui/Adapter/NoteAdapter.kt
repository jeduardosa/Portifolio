package learn.project.digitalnoteapp.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import learn.project.digitalnoteapp.Note
import learn.project.digitalnoteapp.databinding.ListNoteModelBinding

class NoteAdapter(private val context: Context, private val noteList: MutableList<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemLista = ListNoteModelBinding.inflate(LayoutInflater.from(context), parent, false)
        return NoteViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.edtTitulo.setText(noteList[position].titulo)
        holder.edtCXtexto.setText(noteList[position].cxtexto)
        holder.txtDate.setText(noteList[position].txtDate)

    }

    override fun getItemCount() = noteList.size

    inner class NoteViewHolder(binding: ListNoteModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val edtTitulo = binding.edtTitulo
        val edtCXtexto = binding.edtCXtexto
        val txtDate = binding.txtDate
    }

}

