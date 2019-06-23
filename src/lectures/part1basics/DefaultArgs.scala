package lectures.part1basics

object DefaultArgs extends App{

  def trFact(n: Int, acc: Int = 1): Int =
    if(n<=1)
      acc
    else
      trFact(n-1, acc*n)

  val fact10 = trFact(10)
  //I pass default value 1 in the function itself so that the function is not polluted
  //we can also pass some other value even though it has been given a default value

  def savePicture(format: String= "jpg", width: Int, height: Int): Unit = println("saving picture")
  //savePicture(800, 600)- compiler will be confused about the parameter

  //soln.
  savePicture(width= 800, height = 600)

}
