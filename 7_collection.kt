
fun main () {

//Pairs and triples are premade data classes for 2 or 3 generic items.
val equipment = "fish net" to "catching fish"
println("${equipment.first} used for ${equipment.second}")

//Create a triple and print it with toString(), then convert it to a list with toList(). 
//You create a triple using Triple() with 3 values.
val numbers = Triple(6, 9, 42)
println(numbers.toString())
println(numbers.toList())

//Create a pair where the first part of the pair is itself a pair.
val equipment2 = ("fish net" to "catching fish") to "equipment"
println("${equipment2.first} is ${equipment2.second}")
println("${equipment2.first.second}")

//Destructure a pair and print the values.
val (tool, use) = equipment
println("$tool is used for $use")

//Destructure a triple and print the values.
val (n1, n2, n3) = numbers
println("$n1 $n2 $n3")


//create a list of numbers and call sum() on it.
val list = listOf(1, 5, 3, 4)
println(list.sum())

//If the element isn't something List knows how to sum directly, such as a string, 
//you can specify how to sum it using .sumBy() with a lambda function
val list2 = listOf("a", "bbb", "cc")
println(list2.sumBy { it.length })

val list3 = listOf("a", "bbb", "cc")
for (s in list3.listIterator()) {
    println("$s ")
}

//you can map pretty much anything to anything else using hashMapOf(). 
//Hash maps are sort of like a list of pairs, where the first value acts as a key.
val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")

//You can then retrieve the disease value based on the symptom key, using get(), or even shorter, square brackets []
println(cures.get("white spots"))
println(cures["red sores"])
//specifying a symptom that isn't in the map.
println(cures["scale loss"])
//looking up a key that has no match, using getOrDefault()
println(cures.getOrDefault("bloating", "sorry, I don't know"))

//If you need to do more than just return a value, Kotlin provides the getOrElse() function.
println(cures.getOrElse("bloating") {"No cure for this"})

//Just like mutableListOf, you can also make a mutableMapOf. A mutable map lets you put and remove items. 
//Mutable just means able to change, immutable means unable to change.
val inventory = mutableMapOf("fish net" to 1)
inventory.put("tank scrubber", 3)
println(inventory.toString())
inventory.remove("fish net")
println(inventory.toString())

}