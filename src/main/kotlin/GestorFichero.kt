import java.io.File

class GestorFichero : IGestorFichero {

    override fun leer(fichero: File): List<String>? {
        if (fichero.exists()){
            try {
                if (fichero.useLines { it.toList() }.isNotEmpty()){
                    return fichero.useLines { it.toList() }
                }
            }
            catch (e:Exception){
                return null
            }
        }
        return null
    }

    override fun escribir(fichero: File,texto: String):String {
        try {
            fichero.appendText(texto)
        }
        catch (e:Exception){
            return "No existe el fichero"
        }
        return ""
    }

    override fun crearFichero(ruta: String, info: String, sobreescribir: Boolean): File? {
        val fichero = File(ruta)
        crearDirectorio(fichero.parent)
        try {
            if (sobreescribir) {
                fichero.writeText(info)
            } else {
                fichero.createNewFile()
                if (info.isNotEmpty()) {
                    fichero.appendText(info)
                }
            }
        } catch (e: Exception) {
            return null
        }
        return fichero
    }

    override fun crearDirectorio(ruta: String): String {
        val dirRuta = File(ruta)
        try {
            if (!dirRuta.isDirectory) {
                if (!dirRuta.mkdirs()) {
                    return "No fue posible crear la ruta de directorios"
                }
            }
        } catch (e: Exception) {
            return "Error al crear el directorio $ruta: ${e.message}"
        }
        return ""
    }


}