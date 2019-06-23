package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("computing the factorial of " + n + " - I first need the factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("computed factorial of " + n)
      result

    }

  println(factorial(10))
  //wont work for 5000

  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else
        factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }
println(anotherFactorial(5000))

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10*1)
  = factHelper(8, 9*10*1)
  = factHelper(7, 8*9*10*1)
  = ...
  = factHelper(2, 3*4*5*...*10*1)
  = factHelper(1, 2*3*4*...*10*1)
  = 1*2*3*...*10
   */

  //in the second implementation the recursive call is the last expression
  //this allows scala to preserve the same stack frame
  //and not use additional stack frames
  //this is TAIL RECURSION

  //when you need loops use tail recursion

  /*
  1. Concatenates a string n times.
  2. IsPrime function tail recursion.
  3. Fibonacci function, tail recursive.
   */

  def concat(str: String, n: Int): String= {
    def helpConcat(accumulator: String, x: Int): String =
      if (x < 1)
        accumulator
      else
        helpConcat(str + accumulator, x-1)

    helpConcat("", n)
  }
  println(concat("nal",2))

  def isPrime(n: Int): Boolean ={
    def isPrimeHelper(x: Int): Boolean=
      if(x <=1)
        true
      else
        {n%x!=0 && isPrimeHelper(x-1)}

    isPrimeHelper(n/2)
  }

  println(isPrime(232))

  def Fibonacci(n: Int): Int = {
    @tailrec
    def FibonacciHelper(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n)
        last
      else
        FibonacciHelper(i+1, last+nextToLast, last)
    if(n<=2) 1
    else
    FibonacciHelper(2,1,1)
  }

  println(Fibonacci(5))

  //no of accumulators = no of recursive calls
}