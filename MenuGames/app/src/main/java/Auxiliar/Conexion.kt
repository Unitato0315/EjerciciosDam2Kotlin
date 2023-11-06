package Auxiliar

import Conexion.AdminSQLiteConexion
import Modelo.Jugador
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity

object Conexion {
    private  var DATABASE_NAME = "jugadores.db3"
    private  var DATABASE_VERSION = 1



    fun addJugador(contexto: AppCompatActivity, j: Jugador):Long{
        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.writableDatabase //habilito la BBDD para escribir en ella, tambié deja leer.
        val registro = ContentValues() //objeto de kotlin, contenido de valores, un Map. Si haceis ctrl+clic lo veis.
        registro.put("nombre",j.nombre)
        registro.put("nivel", j.nivel.toString())
        val codigo = bd.insert("jugadores", null, registro)
        bd.close()
        return codigo
    }

    fun modJugador(contexto: AppCompatActivity, nombre:String, j: Jugador):Int {
        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", j.nombre)
        registro.put("nivel", j.nivel)
        // val cant = bd.update("personas", registro, "dni='${dni}'", null)
        val cant = bd.update("jugadores", registro, "nombre=?", arrayOf(nombre.toString()))
        //val cant = bd.update("personas", registro, "dni=? AND activo=?", arrayOf(dni.toString(), activo.toString()))
        //Esta línea de más arriba es para tener un ejemplo si el where tuviese más condiciones
        //es mejor la forma de la línea 43 que la de la línea 42, ya que es peligroso inyectar sql directamente al controlarse peor los errores
        //cant trae los datos actualizados.
        bd.close()
        return cant
    }

    fun buscarJugador(contexto: AppCompatActivity, nombre:String): Jugador? {
        var j: Jugador? = null //si no encuentra ninguno vendrá null, por eso la ? y también en la devolución de la función.
        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.readableDatabase
        /*Esta funciona pero es mejor como está hecho justo debajo con ?
        val fila = bd.rawQuery(
            "select nombre,edad from personas where dni='${dni}'",
            null
        )*/
        val fila =bd.rawQuery(
            "SELECT nombre, nivel FROM jugadores WHERE nombre=?",
            arrayOf(nombre.toString())
        )
        //en fila viene un CURSOR, que está justo antes del primero por eso lo ponemos en el primero en la siguiente línea
        if (fila.moveToFirst()) {//si no hay datos el moveToFirst, devuelve false, si hay devuelve true.
            j = Jugador(nombre,  fila.getInt(1))
        }
        bd.close()
        return j
    }


}