/*
    Programa que imprime una frase dependiendo del numero que ingrese el usuario
    si el numero es par el programa dirá "Pareja dispareja"
    si el numero es multiplo de 3 dirá "Esto es tripiante"
    si el numero es impar dirá "Yo soy IMPARcial"
 */

fun main(args: Array<String>) {
    var num:Int
    print("Digite el numero de frase:")
    num = readLine()?.toInt() as Int
    var frase =when{
        num % 2 == 0 && num % 3 != 0 -> "Pareja dispareja"
        num % 3 == 0 ->  "Esto es tripiante"
        else -> "Yo soy IMPARcial"
    }
    println(frase)
}