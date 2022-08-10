package learn.project.digitalnoteapp.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.repository.NoteRepository

class EditNoteViewModel(application: Application) : ViewModel() {

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
    } else
    {
        if (repository.update(note)) {
            _saveNote.value = "Atualização com sucesso"
        } else {
            _saveNote.value = "Falha"
        }
    }
    }


}
