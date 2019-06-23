package lectures.part2oop

object Exceptions extends App {

  val x : String = null
  //println(x length)
  //this ^^ will crash with a null pointer exception
  //1. throwing and catching exceptions

  //val aWeirdValue : String = throw new NullPointerException

  //throwable classes extend the Throwable class
  //Exception(wrong program-npe) and Error(something wrong with the system-stackOverflow) are the major Throwable subtypes

  //2. how to catch exceptions
  def getInt(withExceptions : Boolean) : Int =
    if(withExceptions)throw new RuntimeException("no int value for you")
    else 42


  val potentialFail = try {
    //code that might throw
    getInt(true)
  }
  catch{
    case e : RuntimeException => println("caught a runtime exception "+ e)//if any other exception is stated then runtime will occur
  }
  finally{
    //code that will execute no matter what
    println("finally")
  }

  //3. how to define your own exceptions
//  class MyException extends Exception
//  val exception = new MyException
//
//  throw exception

  /*
  1. Crash your program with an OutOfMemory Error
  2. Crash with SOError
  3.  PocketCalculator
    -add(x,y)
    -multiply(x,y)
    -subtract(x,y)
    -division(x,y)

    Throw
    -OverFlowException if add(x,y) exceeds Int.MAX_VALUE
    -UnderFlowException if subtract(x,y) exceeds Int.MIN_VALUE
    -MathCalculationException fot division by 0
   */

  //1. val array = Array.ofDim(Int.MaxValue)

  //2. def infinite :Int =  1 + infinite
  //val noLimit = infinite

  //3.

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("division by 0")
  object PocketCalculator{
    def add(x : Int,y : Int) : Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x : Int,y : Int) : Int = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new OverflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def multiply(x : Int,y : Int) : Int = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result < 0) throw new OverflowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x : Int,y : Int) : Int = {
      val result = x / y
      if(y == 0) throw new MathCalculationException
      else result
    }
  }
  println(PocketCalculator.add(Int.MaxValue,10))
  println(PocketCalculator.divide(5,0))
}
