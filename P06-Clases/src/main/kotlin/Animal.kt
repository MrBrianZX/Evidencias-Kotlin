open class Animal {
    var nombre:String = ""
    var edad: Int = 0
    var peso: Double = 0.0
    var tamanio: Double = 0.0

    constructor(){

    }
    constructor(nombre: String, edad1:Int, peso:Double, tamanio: Double){
        this.nombre = nombre
        this.edad = edad1
        this.peso = peso
        this.tamanio = tamanio
    }

    fun comer() {
        println("${this.nombre} esta comiendo")
    }

    fun dormir() {
        println("${this.nombre} esta dumiendo")
    }

    fun defecar() {
        println("${this.nombre} esta defecando")
    }

    fun reproducir() {
        println("${this.nombre} se esta reproduciendo")
    }
}