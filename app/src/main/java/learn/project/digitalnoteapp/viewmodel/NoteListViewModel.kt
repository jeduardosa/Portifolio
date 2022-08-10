package learn.project.digitalnoteapp.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.repository.NoteRepository

class NoteListViewModel(application: Application): ViewModel() {

    private val repository = NoteRepository.getInstance(application.applicationContext)

    private val noteModel = MutableLiveData<NoteModel>()
    val note: LiveData<NoteModel> = noteModel

    private val notelist = MutableLiveData<List<NoteModel>>()
    val notes: LiveData<List<NoteModel>> = notelist

    fun get(id: Int) {
        noteModel.value = repository.get(id)
    }

    fun delete(id: Int){
        repository.delete(id)
    }
}