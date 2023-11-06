package Modelo

import java.io.Serializable

data class Arma(var nombre: String,
                var fabricante: String,
                var imagen:String,
                var tipo: String,
                var rareza: String,
                var gatillo: String,
                var canion: String,
                var elemento: String,
                var complemento: String): Serializable
