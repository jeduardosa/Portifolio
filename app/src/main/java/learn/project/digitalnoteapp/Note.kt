package learn.project.digitalnoteapp


data class Note( val titulo: String, val cxtexto: String, val txtDate: String,
   var id: Int = getAutoId()) {


    companion object {
        fun getAutoId(): Int {
            val random = java.util.Random()
            return random.nextInt(100)

        }

    }
}


