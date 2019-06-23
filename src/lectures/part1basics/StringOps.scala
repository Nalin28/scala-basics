package lectures.part1basics

object StringOps extends App{

  val str: String= "Hello, I am learning Scala"

  println(str.charAt(2))//l
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  println(str.toLowerCase())
  println(str.length())


  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a'+: aNumberString :+ 'Z')//PREPEND AND APPEND OPS
  println(str.reverse)
  println(str.take(2))

  //Scala-specific: String interpolator.
  //s-interpolator
  val name = "Nalin"
  val age = 12
  val greeting = s"Hello, my name is $name and I am ${age+1} years old!"
  println(greeting)

  //f-interpolation
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute."
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
