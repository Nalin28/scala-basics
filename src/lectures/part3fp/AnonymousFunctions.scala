package lectures.part3fp

object AnonymousFunctions extends App {

//  val doubler = new Function1[Int, Int] {
//  override def apply(x: Int): Int = x*2
//  }

  //anonymous function or lambda
//  val doubler = (x:Int) => x*2
  val doubler: Int=> Int = x => x*2

  //multiple parameters in a lambda
  val adder: (Int, Int)=> Int = (a,b)=> a+b

  //no parameters
  val justDoSomething : () => Int = () => 3

  println(justDoSomething)//function itself
  println(justDoSomething())//actual call


  //curly braces with lambdas
  val strToInt ={(str: String)=>
    str.toInt
  }

  //MORE syntactic sugar
  //val niceIncrementer: Int => Int = x => x+1
  //or
  val niceIncrementer: Int => Int = _+1
  val niceAdder: (Int, Int) => Int = _+_//equivalent to (a,b)=> a+b

  /*
  1. MyList: replace all functionX calls with lambdas
  2. rewrite the specialAdder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x+y
  println(superAdd(3)(4))

}
