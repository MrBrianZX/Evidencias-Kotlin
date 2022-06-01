fun main(args: Array<String>) {
    val a = 1
    val b = 2

    operadoresSigno(a)
    operadoresAritmeticos(a,b)
    operadoresRelYLog(a,b)
    operadoresNivelBit(a,b)

}

fun operadoresSigno(a:Int){
    println("Prueba de operadores de signo")
    println("+($a) = ${+a}")
    println("-($a) = ${-a}")
}

fun operadoresAritmeticos(a:Int, b:Int){
    println("Prueba de operadores aritmeticos")
    println("$a + $b = ${a + b}")
    println("$a - $b = ${a - b}")
    println("$a * $b = ${a * b}")
    println("$a / $b = ${a / b}")
    println("$a % $b = ${a % b}")

}

fun operadoresRelYLog(a:Int, b:Int){
    println("Prueba de operadores logicos y relacionales");
    println("$a == $b = ${a == b}")
    println("$a != $b = ${a != b}")
    println("$a <  $b = ${a < b}")
    println("$a >  $b = ${a > b}")
    println("$a <= $b = ${a <= b}")
    println("$a >= $b = ${a >= b}")
    println("$a != $b  && $a < $b = ${a != b && a < b }")
    println("$a != $b  || $a < $b = ${a != b && a < b }")
    println("!($a != $b  && $a < $b) = ${!(a != b && a < b)}")
}

fun operadoresNivelBit(a:Int, b:Int){
    println("Prueba de operadores nivel bit")
    println("${a.toString(2)} and  ${b.toString(2)} = ${(a and b).toString(2)}")
    println("${a.toString(2)} or   ${b.toString(2)} = ${(a or b).toString(2)}")
    println("${a.toString(2)} xor  ${b.toString(2)} = ${(a xor b).toString(2)}")
    println("${a.toString(2)} shl  ${b} = ${(a shl b).toString(2)}")
    println("${a.toString(2)} shr  ${b} = ${(a shr b).toString(2)}")
    println("${a.toString(2)} ushr ${b} = ${(a ushr b).toString(2)}")
    println("${a.toString(2)}.inv() = ${a.inv().toString(2)}")
    
}