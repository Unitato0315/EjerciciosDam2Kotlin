package Modelo

object FactoriaArma {

    fun generarArma(): Arma{

        var nombres = listOf("Baby Maker","ASMD","Dakora","Dark Army","Devastator","Flakker","Freeman","Hellshock","ION Laser","Lyuda","Infinity")
        var fabricantes = listOf("Tediore","Jackobs","Torgue","Maliwan")
        var elemento = mutableListOf<String>()
        var image = mutableListOf<String>()
        var complemento = listOf("Maxxed-Out","Creeping","Turbo","Dastardly","DeadEye","Double-Penetrating","Packin' Gratifying","Itchy","Stark")
        var tipo = mutableListOf<String>()
        var rarezas = listOf("Common","Uncommon","Rare","Epic","Legendary")

        var nombreArma = nombres[(nombres.indices).random()]
        var fabricanteArma = fabricantes[(fabricantes.indices).random()]
        var complementoArma = complemento[(complemento.indices).random()]
        var canionArma = fabricantes[(fabricantes.indices).random()]
        var gatilloArma = fabricantes[(fabricantes.indices).random()]
        var rarezaArma = rarezas[(rarezas.indices).random()]

        when(fabricanteArma){
            "Tediore" -> {
                elemento.addAll(listOf("No element","Fire","Electric","Corrosive","Cryo","Radiation"))
                tipo.addAll(listOf("Pistol","SMG","Shotgun"))
            }
            "Torgue" -> {
                elemento.addAll(listOf("No element","Fire","Electric","Corrosive","Cryo","Radiation"))
                tipo.addAll(listOf("Pistol","Assault Rifle","Shotgun","RocketLauncher"))
            }
            "Maliwan" -> {
                elemento.addAll(listOf("Fire","Electric","Corrosive","Cryo","Radiation"))
                tipo.addAll(listOf("Pistol","SMG","Shotgun","Sniper"))
            }
            "Jackobs" -> {
                elemento.addAll(listOf("No element"))
                tipo.addAll(listOf("Pistol","Assault Rifle","Shotgun","Sniper"))
            }
        }

        var tipoArma = tipo[(tipo.indices).random()]
        var elementoArma = elemento[(elemento.indices).random()]

        when(tipoArma){
            "Pistol" -> image.addAll(listOf("pistol1","pistol2","pistol3","pistol4"))
            "Assault Rifle" -> image.addAll(listOf("assault1","assault2"))
            "Shotgun" -> image.addAll(listOf("shotgun1","shotgun2","shotgun3","shotgun4"))
            "Sniper" -> image.addAll(listOf("sniper1","sniper2"))
            "SMG" -> image.addAll(listOf("smg1","smg2"))
            "RocketLauncher" -> image.addAll(listOf("rocketlauncher1"))
        }

        var imageArma = image[(image.indices).random()]

        var a = Arma(nombreArma,fabricanteArma,imageArma,rarezaArma,gatilloArma,canionArma,elementoArma,complementoArma)


        return a
    }


}