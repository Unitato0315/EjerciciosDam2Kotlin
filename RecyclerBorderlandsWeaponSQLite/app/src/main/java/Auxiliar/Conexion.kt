package Auxiliar

import Modelo.Arma
import Conexion.AdminSQLiteConexion
import android.content.ContentValues
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

object Conexion {
    private  var DATABASE_NAME = "armas.db3"
    private  var DATABASE_VERSION = 1


    fun cambiarBD(nombreBD:String){
        this.DATABASE_NAME = nombreBD
    }

    fun addArma(contexto: AppCompatActivity, a: Arma):Long{
        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.writableDatabase //habilito la BBDD para escribir en ella, tambié deja leer.
        val registro = ContentValues() //objeto de kotlin, contenido de valores, un Map. Si haceis ctrl+clic lo veis.
        registro.put("nombre", a.nombre)
        registro.put("fabricante",a.fabricante)
        registro.put("imagen", a.imagen)
        registro.put("tipo",a.tipo)
        registro.put("rareza", a.rareza)
        registro.put("gatillo",a.gatillo)
        registro.put("canion", a.canion)
        registro.put("elemento", a.elemento)
        registro.put("complemento",a.complemento)
        val codigo = bd.insert("armas", null, registro)
        bd.close()
        return codigo
    }

    fun delArma(contexto: AppCompatActivity, nombre: String):Int{
        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.writableDatabase
        //val cant = bd.delete("personas", "dni='${dni}'", null)
        val cant = bd.delete("armas", "nombre=?", arrayOf(nombre.toString()))
        bd.close()
        return cant
    }

    fun modArma(contexto: AppCompatActivity, nombre:String, a:Arma):Int {
        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("fabricante", a.fabricante)
        registro.put("tipo", a.tipo)
        // val cant = bd.update("personas", registro, "dni='${dni}'", null)
        val cant = bd.update("armas", registro, "nombre=?", arrayOf(nombre))
        //val cant = bd.update("personas", registro, "dni=? AND activo=?", arrayOf(dni.toString(), activo.toString()))
        //Esta línea de más arriba es para tener un ejemplo si el where tuviese más condiciones
        //es mejor la forma de la línea 43 que la de la línea 42, ya que es peligroso inyectar sql directamente al controlarse peor los errores
        //cant trae los datos actualizados.
        bd.close()
        return cant
    }

    fun buscarArma(contexto: AppCompatActivity, nombre:String):Arma? {
        var a:Arma? = null //si no encuentra ninguno vendrá null, por eso la ? y también en la devolución de la función.
        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.readableDatabase
        /*Esta funciona pero es mejor como está hecho justo debajo con ?
        val fila = bd.rawQuery(
            "select nombre,edad from personas where dni='${dni}'",
            null
        )*/
        val fila =bd.rawQuery(
            "SELECT * FROM armas WHERE nombre=?",
            arrayOf(nombre)
        )
        //en fila viene un CURSOR, que está justo antes del primero por eso lo ponemos en el primero en la siguiente línea
        if (fila.moveToFirst()) {//si no hay datos el moveToFirst, devuelve false, si hay devuelve true.
            a = Arma(nombre, fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4), fila.getString(5), fila.getString(6), fila.getString(7), fila.getString(8))
            Log.e("ACSCO","Paso por OnUpgrade del AdminSQLLite")
        }
        bd.close()
        return a
    }

    fun obtenerArmas(contexto: AppCompatActivity):ArrayList<Arma>{
        var armas:ArrayList<Arma> = ArrayList(1)

        val admin = AdminSQLiteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.readableDatabase
        val fila = bd.rawQuery("select * from armas", null)
        while (fila.moveToNext()) {
            var a:Arma = Arma(fila.getString(0),fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4), fila.getString(5), fila.getString(6), fila.getString(7), fila.getString(8))
            armas.add(a)
        }
        bd.close()
        return armas //este arrayList lo puedo poner en un adapter de un RecyclerView por ejemplo.
    }
}