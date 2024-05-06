import java.io.File

interface IGestorFichero {

    fun crearFichero(ruta: String, info:String = "", sobreescribir:Boolean = true): File?

    fun leer(fichero:File): List<String>?

    fun escribir(fichero: File, texto:String): String

    fun crearDirectorio(ruta:String): String
}