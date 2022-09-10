package learn.project.digitalnoteapp.viewmodel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import learn.project.digitalnoteapp.model.NoteModel
import learn.project.digitalnoteapp.repository.NoteRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NoteRepository.getInstance(application.applicationContext)

    private val notelist = MutableLiveData<List<NoteModel>>()
    val notes: LiveData<List<NoteModel>> = notelist

    fun getLoad() {
        notelist.value = repository.getLoad()
    }

    fun delete(id: Int) {
        repository.delete(id)
    }

}

