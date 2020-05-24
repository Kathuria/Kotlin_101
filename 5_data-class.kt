package example.myapp.decor

//A data class is similar to a struct in some other languages—it exists mainly to hold some data—but a data class object is still an object. 

// Here is a data class with 3 properties.
data class Decoration2(val rocks: String, val wood: String, val diver: String){
}

fun makeDecorations() {
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

// Assign all properties to variables.
    val (rock, _, diver) = d5
    println(rock)
    println(diver)
}

fun main () {
    makeDecorations()
}