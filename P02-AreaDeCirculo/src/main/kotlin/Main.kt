//Programa que calcula el area de un circulo

fun main() {
    //Costante
    val PI = 3.1416
    //Variable declarada de forma explicita
    var radio:Double

    print("Ingrese el radio del circulo:");
    radio = readLine()?.toDouble() as Double

    //Variable declarada de forma implicita
    var area = PI * radio * radio

    print("El Area del circulo es:" + area)

}