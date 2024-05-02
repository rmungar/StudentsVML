import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import java.io.File

class StudentsViewModel(
    private val gestorFichero : IGestorFichero,
    private val archivoEstudiantes : File
) {

    companion object{
        private const val MAXCARACTERES = 10
        private const val MAXIMOSVISIBLES = 7
    }

    private val _newStudent = mutableStateOf("")
    val newStudent: State<String> = _newStudent

    private val _students = mutableStateListOf<String>()
    val students = mutableListOf<String>()


}