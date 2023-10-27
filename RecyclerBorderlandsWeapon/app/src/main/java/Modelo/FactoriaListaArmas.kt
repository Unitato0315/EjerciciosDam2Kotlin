package Modelo

object FactoriaListaArmas {
    fun generaLista(cant:Int):ArrayList<Arma> {
        var lista = ArrayList<Arma>(1)
        for(i in 1..cant){
            lista.add(FactoriaArma.generarArma())
        }
        return lista
    }
}