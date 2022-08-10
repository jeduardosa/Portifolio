package learn.project.digitalnoteapp.view.holder

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import learn.project.digitalnoteapp.databinding.NoteModelListBinding
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.view.listener.OnNoteListener

class NoteViewHolder(private val binding: NoteModelListBinding, private val listener: OnNoteListener) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(note: NoteModel) {
        val edtTitulo = binding.editTitle
        val edtCXtexto = binding.editAnnotation

        binding.newBox2.setOnClickListener {
            listener.onClick(note.id)
        }
        //Confirmação de delete
        binding.newBox2.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim"
                ) { dialog, which ->
                    listener.onDelete(note.id)
                }
                .setNegativeButton("Não", null)
                .create()
                .show()

            true
        }
    }

}