package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {
    println("by value:" +x)
    println("by value:" +x)
  }

  def calledByName(x: => Long): Unit = {//useful in lazy streams
    println("by name:" +x)
    println("by name:" +x)
  }

  calledByValue(System.nanoTime())//evaluates the first exp. and uses the same value throughout the function
  calledByName(System.nanoTime())//evaluated every time


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(infinite(), 34)//stack overflow
  printFirst(34, infinite())//prints 34 since in the function def infinite() is not used hence delays(does not) its evaluation
}
