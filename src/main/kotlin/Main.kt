package Ventana_1_Funcion

import StudentsViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File

fun main(
    studentsViewModel: StudentsViewModel
) = application{



    Window(
       visible = true ,
        onCloseRequest = ::exitApplication
    ){
        Ventanas(
            studentsViewModel,
            psswd,
            psswdVisible,
            estudiante,
            students,
            estadoBoton,
            estadoBotonLogin,
            verVentanaPrincipal,
            verVentanaSecundaria,
            onEntrada = { estudiante = it },
            onClick = { added.add(it) },
            onSave = {
                added.forEach {
                    archivoEstudiantes.appendText("\n$it")
                }
                verVentanaPrincipal = true
                verVentanaSecundaria = false
            },
            onDelete = {
                archivoEstudiantes.delete()
                archivoEstudiantes.createNewFile()
            },
            onEntrada1 = {user = it },
            onEntrada2 = {psswd = it},
            onLogin = {
                verVentanaPrincipal = false
                verVentanaSecundaria = true
                user = ""
                psswd = ""
            },
            {
                val lista = archivoEstudiantes.useLines { it.toMutableList() }
                lista.remove(it)
            }
        )
    }

}