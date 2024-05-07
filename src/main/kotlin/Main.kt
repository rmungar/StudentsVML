package Ventana_1_Funcion

import GestorFichero
import IStudentsVM
import StudentsViewModel
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File


fun main() = application{
    val archivoEstudiantes = "Students.txt"
    val gestorFichero = GestorFichero()
    val studentsViewModel :IStudentsVM = StudentsViewModel(gestorFichero, File(archivoEstudiantes))

    Window(
       visible = true ,
        onCloseRequest = ::exitApplication
    ){
        Ventanas(
            studentsViewModel)
    }

}

