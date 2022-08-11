package learn.project.digitalnoteapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.repository.NoteRepository

class EditNoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NoteRepository.getInstance(application)

    private val noteModel = MutableLiveData<NoteModel>()
    val note: LiveData<NoteModel> = noteModel

    private val _saveNote = MutableLiveData<String>()
    val saveNote: LiveData<String> = _saveNote

    fun save(note: NoteModel) {
        if (note.id == 0) {
            if (repository.insert(note)) {
                _saveNote.value = "Inserção com sucesso"
            } else {
                _saveNote.value = "Falha"
            }
        } else {
            if (repository.update(note)) {
                _saveNote.value = "Atualização com sucesso"
            } else {
                _saveNote.value = "Falha"
            }
        }
    }

    fun get(id: Int) {
        noteModel.value = repository.get(id)
    }

    fun getText(title: String, annotation: String): NoteModel? {
        noteModel.value = getText(title, annotation)!!
    }

}
