package learn.project.digitalnoteapp.viewmodel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import learn.project.digitalnoteapp.constants.DataBaseConstants
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.repository.NoteRepository

class CreateNoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NoteRepository.getInstance(application)

    private val noteModel = MutableLiveData<NoteModel>()
    val note: LiveData<NoteModel> = noteModel

    private val _saveNote = MutableLiveData<String>()
    val saveNote: LiveData<String> = _saveNote


    fun save(note: NoteModel) {
        if (note.id == 0) {
            if (repository.insert(note)) {

                _saveNote.value = DataBaseConstants.MENSSAGE.SAVE
            } else {
                _saveNote.value = DataBaseConstants.MENSSAGE.FAIL
            }
        } else {
            if (repository.update(note)) {
                _saveNote.value = DataBaseConstants.MENSSAGE.UPDATE
            } else {
                _saveNote.value = DataBaseConstants.MENSSAGE.FAIL
            }
        }
    }

    fun get(id: Int) {
        noteModel.value = repository.get(id)
    }

}
