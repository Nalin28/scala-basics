package lectures.part1basics


import scala.math
object Functions extends App{

  def aFunction(a: String, b: Int): String =
    a +" "+ b
  //can make a block of this function as well

  println(aFunction("hello",3))

  def aParameterLessFunction(): Int = 42
    println(aParameterLessFunction())

  def aRepeatedFunction(aString: String, n:Int): String = {
    if(n == 1) aString
    else
      aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello",3))

  //WHEN YOU NEED LOOPS, USE RECURSION.

  //you can remove the return type as well for the function as the compiler can figure that out as well
  //but do'nt delete the return type of the recursive function as compiler wont fill it.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
      aSmallerFunction(n, n-1)
  }

  /*
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  2. factorial function
  3. fibonacci function
  4. Tests if a number is prime.
   */

  def greeting(name: String, age: Int): Unit = println(s"Hi, my name is $name and I am $age years old")

  greeting("Nalin", 21)

  def factorial(n: Int):Int={
    if(n<=1)
      1
    else
      n*factorial(n-1)
  }
  println(factorial(5))

  def Fibonacci(n: Int): Int = {
    if(n <=2)
      1
    else
      Fibonacci(n-1)+Fibonacci(n-2)
  }

  println(Fibonacci(5))

  def isPrime(n: Int): Boolean= {
    //6
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else
        n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2) //3

  }

  println(isPrime(4))
}
