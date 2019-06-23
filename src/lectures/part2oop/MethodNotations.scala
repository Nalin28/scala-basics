package lectures.part2oop

object MethodNotations extends App{
    class Person(val name: String, favouriteMovie: String, val age: Int){
      def likes(movie: String): Boolean = movie == favouriteMovie
      def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
      def unary_! : String = s"$name hello world!"
      def isAlive: Boolean = true
      def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"

      def +(nickname: String): Person = new Person(s"$name ($nickname)",favouriteMovie,age)
      def unary_+ : Person = new Person(name ,favouriteMovie,age+1)
      def learns(things: String):String = s"$name learns $things"
      def learnScala = this learns "Scala"
      def apply(n: Int): String = s"$name watched $favouriteMovie $n times!"
    }
  val mary = new Person("Mary", "Inception", 12)
  println(mary.likes("Inception"))
  println(mary likes "Inception")//infix notation / operator notation(syntactic sugar)

  //"operators in Scala"
  val tom = new Person("Tom", "Fight Club",13)
  println(mary hangOutWith tom)//hangOutWith acts as an operator
  //all operators are methods e.g. 1.+(2)

  //Akka actors have ! ?

  //prefix notation
  val x = -1//equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_prefix only works with - + ~ !
  println(mary unary_!)

  //postfix notification(no parameters)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())//****


  /*
  1. overload the + operator
  mary + "the rockstar" => new person "Mary(the rockstar)"

  2.Add an age to the Person class
  Add a unary + operator => new person with the age +1
  +mary => mary with the age incremented

  3.Add a "learns" method in the Person class => "Mary learns Scala"
  Add a learnScala method, calls learns method "Scala".
  Use it in postfix notation.

  4.Overload the apply method
  mary.apply(2) => "Mary watched Inception 2 times"
   */

  //1
  println((mary + "rockstar")())//apply
  println((+mary).age)

  println(mary learnScala)
}
