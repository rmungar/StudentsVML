import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
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

    fun addStudent() {
        if (_newStudent.value.isNotBlank()) {
            _students.add(_newStudent.value.trim())
            _newStudent.value = ""
        }
    }
    fun newStudentChange(name: String) {
        if (name.length <= MAXCARACTERES) {
            _newStudent.value = name
        }
    }

    private val _students = mutableStateListOf<String>()
    val students = _students

    private val _estadoBoton = _newStudent.value.isNotBlank()
    val estadoBoton = _estadoBoton


}