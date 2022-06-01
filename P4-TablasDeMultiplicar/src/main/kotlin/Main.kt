/*
    Programa que imprime la tabla de multiplicar usando un ciclo diferente segun el valor
    si num es Par pero no multiplo de 3 lo hará usando for
    si num es multiplo de 3 usará while
    y en cualquier otro caso usará doWhile
 */

fun main(args: Array<String>) {
    var num:Int
    print("Digite el numero del que quiere la tabla:");
    num = readLine()?.toInt() as Int

    if(num % 2 == 0 && num % 3 != 0)
        tablasFor(num)
    else if(num % 2 == 1 && num % 3 == 0)
    tablasWhile(num)
    else
    tablasDoWhile(num)
}

fun tablasFor(num:Int){
    println("Ciclo For")
    for ( i in 1..10){
        println("$num x $i = ${num * i}")
    }
}

fun tablasWhile(num:Int){
    println("Ciclo While")
    var i = 0
    while(i < 10){
        i++
        println("$num x $i = ${num * i}")
    }
}

fun tablasDoWhile(num:Int){
    println("Ciclo DoWhile")
    var i = 0
    do{
        i++
        println("$num x $i = ${num * i}")
    }while(i < 10)
}