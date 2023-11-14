package learn.project.digitalnoteapp.view.holder

import android.graphics.Color
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import learn.project.digitalnoteapp.databinding.NoteModelListBinding
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.view.listener.OnNoteListener

class NoteHolder(private val bind: NoteModelListBinding, private val listener: OnNoteListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(note: NoteModel) {

        bind.textTitle.text = note.title
        bind.textAnnotation.text = note.annotation
        //bind.txtCreateDate.text = note.createDate

        //color


        bind.textAnnotation.setOnClickListener {
            listener.onClick(note.id)
        }
        bind.masterConstraint.setOnClickListener {
            listener.onClick(note.id)
        }

        //Confirmação de delete
        bind.textAnnotation.setOnLongClickListener {

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