package example.myapp

//Abstract classes are always open; you don't need to mark them with open. 
//Properties and methods of an abstract class are non-abstract unless you explicitly mark them with the abstract keyword. 
//That means subclasses can use them as given. If properties or methods are abstract, the subclasses must implement them.

//abstract class for properties that are common to all fish. 
abstract class AquariumFish {
    abstract val color: String
}

//interface to define behavior common to all fish.
interface FishAction  {
    fun eat()
}

class Shark: AquariumFish(), FishAction {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main () {
    makeFish()
}