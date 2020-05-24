//A break qualified with a label jumps to the execution point right after the loop marked with that label. This is particularly useful when dealing with nested loops.
//Any expression in Kotlin may be marked with a label. Labels have the form of an identifier followed by the @ sign.


//A labeled break in Kotlin can only be used to break out of loops, unlike goto in C++ or C#.
fun labels() {
    outerLoop@ for (i in 1..100) {
         print("$i ")
         for (j in 1..100) {
             if (i > 10) break@outerLoop  // breaks to outer loop
        }
    }
}

fun main() {
    labels()
}