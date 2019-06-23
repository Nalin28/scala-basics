package lectures.part1basics

object Expressions extends App{

  val x = 1+2//expression
  println(x)

  println(2+3+4)
  //+ - * / & | ^ << >> >>>(right shift with 0 extension)

  println(1==x)//false
  // == != > >= < <=

  println(!(1 == x))//true

  var aVariable = 2
  aVariable += 3//-= *= /= .....side effects
  println(aVariable)

  //instructions(DO-execution) vs expressions(VALUE-evaluated)

  //ex: if expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  var i = 0
  while(i<10) {
    println(i)
    i +=1
  }
  //NEVER WRITE THIS AGAIN
  //Everything in Scala is an Expression!

  val aWeirdValue = (aVariable = 3)//Unit === void
  println(aWeirdValue)
  //side effects in Scala return unit
  //side effects: println(), whiles, reassigning

  //code blocks
  //code block is an expression
  //value of a block is the last evaluated expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z>2) "hello" else "goodbye"
  }

  //no variable inside code block is visible outside

 //1. difference btw. "hello world" and println("hello world")
  // string and side effect returning unit
 //2.
  val someValue = {
    2<3
  }
  //returns a boolean
//3.
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  //42- only the last expression is evaluated
}
