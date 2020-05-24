package example;

public class JavaRun {
    public static void runNow(Runnable runnable) {
        runnable.run();
    }
}

fun runExample() {
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a Runnable")
        }
    }
    JavaRun.runNow(runnable)
}

//fun runExample() {
//    JavaRun.runNow {
//        println("Last parameter is a lambda as a Runnable")
//    }
//}

fun main () {
    runExample()
}