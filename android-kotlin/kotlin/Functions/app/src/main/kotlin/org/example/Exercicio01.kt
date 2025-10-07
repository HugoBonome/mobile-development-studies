package org.example

//fun calculaIdade(idade: Double, valor: (String) -> Double): Double{
//
//}

fun calcularIdadePorPlaneta(planeta: String): (Double) -> Double {
    var valor = when (planeta){
        "Mercúrio" -> 0.2408467;
        "Vênus" -> 0.61519726;
        "Terra" -> 1.0;
        "marte" -> 1.8808158;
        "júpiter" -> 11.862615;
        "Saturno" -> 29.447498;
        "Urano" -> 84.016846;
        "Netuno" -> 164.79132;
        else -> -1.0
    }
//    if (valor < 0) {valor = 1.0}
    return {idade: Double -> idade / valor}
}

fun main() {

    do {
        var option: String
        var idade: Double = 0.0

        do {
            print("Digite a idade da pessoa em anos terrestres: ")
            idade = readlnOrNull()?.toDoubleOrNull() ?: 0.0;
            println()
            if (idade == 0.0) {
                print("digite um valor numérico válido acima de 0")
            }
        } while (idade == 0.0)

        print("Digite o planeta no qual quer saber a idade da pessoa: ")
        var planeta = readlnOrNull() ?: ""
        println()
        if (planeta == "0") {
            print("digite um valor numérico válido acima de 0")
        }

        val calculoPlaneta = calcularIdadePorPlaneta(planeta)
        println(calculoPlaneta(idade))

        print("______________")
        print("Deseja calcular uma nova idade? (y/n): ")
        option = readlnOrNull() ?: ""
    }  while(option == "y")


}