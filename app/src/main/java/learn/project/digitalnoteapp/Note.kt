package learn.project.digitalnoteapp

import android.text.Editable


data class Note( val titulo: String, val cxtexto: String,
    var id: Int = getAutoId()
) {


    companion object {
        fun getAutoId(): Int {
            val random = java.util.Random()
            return random.nextInt(100)

        }
    }
}