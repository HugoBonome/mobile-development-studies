package org.example

open class Animal(var nome: String){
    open fun fazerSom(): String{
        return "Som Genérico"
    }

    fun dormir() {
        println("$nome está dormindo")
    }
}

class Cachorro(nome: String) : Animal(nome){
    override fun fazerSom(): String {
        return "--Latindo--"
    }
}