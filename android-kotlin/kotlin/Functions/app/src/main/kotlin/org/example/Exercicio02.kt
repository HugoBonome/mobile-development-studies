package org.example

fun imprimirTemperatura(
temperatura: Double,
unidadeOrigem: String = "Celsius",
unidadeDestino: String = "Fahrenheit",
conversao: (Double) -> Double
) {
    val resultado = conversao(temperatura)
    println("A temperatura $temperatura $unidadeOrigem é equivalente a $resultado $unidadeDestino.")
}

fun main() {
    var cToF: (Double) -> Double = { celsius -> (celsius * 9/5) + 32 } // calculo C to F
    var cToK: (Double) -> Double = { celsius -> celsius + 273.15 } // calculo C to K
    var fToC: (Double) -> Double = { fahrenheit -> (fahrenheit - 32) * 5/9 } // calculo F to C
    var fToK: (Double) -> Double = { fahrenheit -> (fahrenheit - 32) * 5/9 + 273.15 } // calculo F to K
    var kToC: (Double) -> Double = { kelvin -> kelvin - 273.15 } // calculo K to C
    var kToF: (Double) -> Double = { kelvin -> (kelvin - 273.15) * 9/5 + 32 } // calculo K to F

    var temp: Double? = null
    var origem: String
    var destino: String

    do {
        print("Digite a temperatura a ser modificada: ")
        temp = readlnOrNull()?.toDoubleOrNull() ?: 0.0;
        println()
        if (temp == null) {
            print("digite um valor numérico válido ")
        }
    } while (temp == null)

    do {
        print("Digite a temperatura de origem: ")
        origem = readlnOrNull() ?: ""
        println()
        if (origem != "Celsius" && origem != "Fahrenheit" && origem != "Kelvin") {
            print("digite uma unidade válida (Celsius, Fahrenheit ou Kelvin)")
            println()
        }
    } while (origem != "Celsius" && origem != "Fahrenheit" && origem != "Kelvin")

    do {
        print("Digite a temperatura de destino: ")
        destino = readlnOrNull() ?: ""
        println()
        if (destino != "Celsius" && destino != "Fahrenheit" && destino != "Kelvin") {
            print("digite uma unidade válida (Celsius, Fahrenheit ou Kelvin)")
            println()
        }
    } while (destino != "Celsius" && destino != "Fahrenheit" && destino != "Kelvin")

    when (origem) {
        "Celsius" -> when (destino) {
            "Fahrenheit" -> imprimirTemperatura(temp, origem, destino, cToF)
            "Kelvin" -> imprimirTemperatura(temp, origem, destino, cToK)
            else -> println("A temperatura $temp $origem é equivalente a $temp $destino.")
        }
        "Fahrenheit" -> when (destino) {
            "Celsius" -> imprimirTemperatura(temp, origem, destino, fToC)
            "Kelvin" -> imprimirTemperatura(temp, origem, destino, fToK)
            else -> println("A temperatura $temp $origem é equivalente a $temp $destino.")
        }
        "Kelvin" -> when (destino) {
            "Celsius" -> imprimirTemperatura(temp, origem, destino, kToC)
            "Fahrenheit" -> imprimirTemperatura(temp, origem, destino, kToF)
            else -> println("A temperatura $temp $origem é equivalente a $temp $destino.")
        }
    }
}

