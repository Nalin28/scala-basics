package lectures.part2oop

object ooBasics extends App{

  val person = new Person("Nalin", 21)
  println(person.age)
  println(person.x)
  person.greet("Rahul")
  person.greet()

 val author = new Writer("Nalin","Munshi",2017)
  val novel = new Novel("Champak",1861,author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))


  val counter1 = new counter(0)
  counter1.inc.print
  counter1.inc.inc.inc.print
  counter1.dec(10).print

}

//constructor
class Person(name: String, val age: Int = 0){
  //body
  val x = 2
  println(1+3)
  //if i print 2 val 4 will also be printed with it because when instantiated every expression inside the class will be evaluated including side effects

  def greet(name: String): Unit = println(s"${this.name} says : Hi, $name")
  def greet(): Unit = println(s"Hi, I am $name")//this is understood

  def this(name: String) = this(name, 0)//auxillary constructor
  def this() = this("John Doe")
  //instead of aux constructor we can directly give a value to the constructor in class def
/*
Novel and a Writer

Writer: first name, surname, year
-method fullName

Novel: name, year of release, author
-authorAge
-isWrittenBy(author)
-copy (new year of release) = new instance of Novel

counter class
-receive an int value
-method current count
-method to increment/decrement => new Counter
-overload inc./dec. to receiver an amount
 */

}

class Writer(firstName: String, surname: String, val year: Int)
{
  def fullName(): String = firstName+" "+surname
}
class Novel(name: String, year: Int, author: Writer)
{


  def authorAge = year - author.year

  def isWrittenBy(author: Writer)= author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}



class counter(val count: Int)
{
  def inc = {println("incrementing")
    new counter(count+1)}//immutability-sending a new counter the old one is gone no overlap
  def dec = {println("decrementing")
    new counter(count-1)}//instances are fixed and cant be modified

  def inc(n: Int): counter =
  {
    if(n<=0) this
    else
      inc.inc(n-1)
  }
  def dec(n: Int): counter =
  {
    if(n<=0) this
    else
      dec.dec(n-1)
  }
  def print = println(count)
}
//age is a class parameter and cant be accessed by class by dot operator since its not a field(class member)
//in order to convert it into a field is by adding val before it

