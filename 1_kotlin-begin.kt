import java.util.*    // required import for random function

fun printHello() {
    println ("Hello World")
}

// return type as string
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// Return type as string and day input as string
fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

//With Random function
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
}

// Default Values
fun swim(speed: String = "fast") {
   println("swimming $speed")
}

//Compact Functions
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}


//Main Function
fun main(args: Array<String>){  
    printHello()

    println("Enter your name:")
    //var name = readLine()
    var name = "Ak"
    println("Welcome ${name}, Length is ${name?.length}")

val i: Int = 6
println(i)

val b2: Byte = 1 // OK, literals are checked statically
println(b2)

//val i1: Int = b2      //type mismatch: inferred type is Byte but Int was expected


//Because Kotlin is strongly typed, the compiler can usually infer the type for variables, so you don't need to explicitly declare it.
val oneMillion = 1_000_000
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010

println(oneMillion + socialSecurityNumber + hexBytes + bytes)

val fish = 50
if (fish in 1..100) {   //Range
    println(fish)
}

var fishFoodTreats: Int? = null        // Defining variable can be null else gives error "null can not be a value of a non-null type Int"
//fishFoodTreats = fishFoodTreats?.dec()  //Not Null Check
println(fishFoodTreats)

fishFoodTreats = fishFoodTreats?.dec() ?: 0     
//It's shorthand for "if fishFoodTreats is not null, decrement and use it; 
//otherwise use the value after the ?:, which is 0." If fishFoodTreats is null, evaluation is stopped, and the dec() method is not called.

println(fishFoodTreats)

var s = ""
val len = s!!.length   // throws NullPointerException if s is null

println(len)
//In programming slang, the exclamation mark is often called a "bang," so the not-null assertion operator is sometimes called the "double-bang" or "bang bang" operator.


val school = listOf("mackerel", "trout", "halibut")
println(school)


val myList = mutableListOf("tuna", "salmon", "shark")
myList.remove("shark")

println(myList)

val mix = arrayOf("fish", 2)
println(mix)        //When you don't use the array utility to print it, Kotlin prints the address instead of the contents of the array.
println(java.util.Arrays.toString(mix))

val numbers = intArrayOf(1,2,3)
val numbers3 = intArrayOf(4,5,6)
val foo2 = numbers3 + numbers       //4, 5, 6, 1, 2, 3
println(foo2[5])


val array = Array (5) { it * 2 }
println(java.util.Arrays.toString(array))


for ((index, element) in school.withIndex()) {
    println("Item at $index is $element\n")
}


for (j in 1..5) print(j)
println()
for (k in 5 downTo 1) print(k)
println()
for (l in 3..6 step 2) print(l)
println()
for (m in 'd'..'g') print(m)
println()

//functions
val isUnit = println("This is an expression")
println(isUnit)

val temperature = 10
val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
println(message)


feedTheFish()

swim()   // uses default speed
swim("slow")   // positional argument
swim(speed="turtle-like")   // named parameter


println(shouldChangeWater("Monday"))

//By default, filter is eager, and each time you use the filter, a list is created.
val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
println( decorations.filter {it[0] == 'p'})


val lazyMap = decorations.asSequence().map {
println("access: $it")
it
}

println("lazy: $lazyMap")
println("-----")
println("first: ${lazyMap.first()}")
println("-----")
println("all: ${lazyMap.toList()}")

//Lambda fn
var dirtyLevel = 20
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
println(waterFilter(dirtyLevel))

//HOC
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
   return operation(dirty)
}
println(updateDirty(30, waterFilter))

fun increaseDirty( start: Int ) = start + 1
println(updateDirty(15, ::increaseDirty))
}



