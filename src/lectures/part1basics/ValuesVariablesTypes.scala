package lectures.part1basics

object ValuesVariablesTypes extends App{

  val x: Int = 42
  println(x)
  //x = 2(cant be reassigned)
  //vals are immutable
  //val x = 42 is also fine
  //compiler can infer types

  val aString: String = "hello"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 1341341414134123333L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //Variables
  var aVariable: Int = 4

  aVariable = 5// side effects(print on screen or console)

  //prefer vals over vars
}
