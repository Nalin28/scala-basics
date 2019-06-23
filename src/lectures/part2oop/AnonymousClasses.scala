package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal{
    def eat: Unit
  }


  //anonymous class
  val funnyAnimal = new Animal{
    override def eat: Unit = println("ahahahahahhahahaah")//instantiation of an abstract class?
  }

  println(funnyAnimal.getClass)
  // internally what happens?
  /*
  class AnonymousClasses$$anon$1 extends Animal{
  override def eat: Unit = println("ahahahahahhahahaah")
  }
   */

  class Person(name : String){
    def sayHi: Unit=println(s"my name is $name, how can I help")
  }
  val jim = new Person("Jim"){
    override def sayHi : Unit = println("my name is Jim, how may I be of service?")
  }


  println(jim.sayHi)




}
