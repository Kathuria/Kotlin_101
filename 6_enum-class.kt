//Declare an enum by prefixing the declaration with the keyword enum. 
//A basic enum declaration only needs a list of names, 
//but you can also define one or more fields associated with each name.

enum class Color(val rgb: Int) {
   RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun main() {
    println(Color.GREEN.name)
    println(Color.GREEN.ordinal)
    println(Color.GREEN.rgb)

    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}