package generics


//A generic type allows you to make a class generic, and thereby make a class much more flexible.
open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
   fun addChemicalCleaners() {
       needsProcessing = false
   }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
   fun filter() {
       needsProcessing = false
   }
}

//val and var are about the VALUES of variables. val protects the variable value from being changed.

//in and out are about the TYPES of variables. in and out make sure that when working with generic types, only safe types are passed in and out of functions.

class Aquarium<out T: WaterSupply>(val waterSupply: T) {    
    fun addWater() {
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }    
    fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added to $aquarium")
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) =   waterSupply.addChemicalCleaners()
}

class Aquarium2<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }
}

fun genericsExample() {
    val aquarium = Aquarium<TapWater>(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

    //val aquarium2 = Aquarium("string")
    //println(aquarium2.waterSupply)

    //val aquarium3 = Aquarium(null)
    //if (aquarium3.waterSupply == null) {
      //  println("waterSupply is null")
    //}

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()

    val aquarium5 = Aquarium(TapWater())
    aquarium5.addItemTo(aquarium5)


    val cleaner = TapWaterCleaner()
    val aquarium6 = Aquarium2(TapWater())
    aquarium6.addWater(cleaner)
}

fun main() {
    genericsExample()
}