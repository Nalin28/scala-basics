package lectures.part3fp

object WhatsaFunction extends App{


  def compose[A,B,T](f: A=>B, g:T=> A):T=>B =
    x => f(g(x))
//  def compose[A,B,T](g: A=>B, f:T=> A):T=>B =
//    x => g(f(x))

  //DREAM: use as first class elements
  //problem: oop

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element*2
  }

  println(doubler(2))


  //function types = Function1[A, B] -> default upto 22 parameters
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

println(stringToIntConverter("3")+4)

  val adder: ((Int, Int)=>Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int):Int = a+b
  }

  val concat: ((String,String)=>String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concat("nalin","munshi"))


  //Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]]{
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int):Int = x+y
    }
  }
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4))//curried function
  }



// ALL SCALA FUNCTIONS ARE OBJECTS

/*
1. 2 strings and concatenate them
2. transform myPredicate and myTransformer into function types
3. define a function that takes an Int and returns another function that returns an Int
  -what's the type of this function
  -how to do it

 */

trait MyFunction[A, B]{
  def apply(element: A): B
}
