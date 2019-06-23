package lectures.part3fp

object HOFsCurries extends App{

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int, Int) = null
  //higher order functions

  //map, flatMap, filter in MyList

  //function that defines a function n times over a value x
  //nTimes(f,3,x) = f(f(f(x))) = nTimes(f,2,f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if(n <= 0) x
    else nTimes(f,n-1,f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne,10,1))

  def nTimesBetter(f: Int => Int, n: Int):(Int => Int) =
    if(n<=0)(x: Int)=> x
    else x => nTimesBetter(f,n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

//curries expressions

  //functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormatter: (Double=> String) = curriedFormatter("%4.2f")
  val preciseFormatter: (Double=> String) = curriedFormatter("%10.8f")

  println(standardFormatter(Math.PI))
  println(preciseFormatter(Math.PI))

}
