package example.myapp

// Compact class style having constructor in parameters
// By Default Public
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    //Secondary Constructor
    //Every secondary constructor must call the primary constructor first, 
    //either directly using this(), or indirectly by calling another secondary constructor. 
    //This means that any init blocks in the primary will be called for all constructors, 
    //and all the code in the primary constructor will be executed first.
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1

        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    init {
        println("aquarium initializing")
    }

    //Properties within a class, or member variables, are public by default. 
    //If you define them with var, they are mutable, that is, readable and writable. 
    //If you define them with val, they are read-only after initialization.
    var volume: Int
    get() = width * height * length / 1000
    set(value) {
        height = (value * 1000) / (width * length)
    }

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l")
    }
}

fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()
}

fun main() {
    buildAquarium()
}