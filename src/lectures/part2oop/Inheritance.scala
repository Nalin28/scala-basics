package lectures.part2oop

object Inheritance extends App{


  //single class inheritance
  //inheritance calls only the non private members of the eat class
  /*sealed*/ class Animal{
    val creatureType = "wild"
    def eat = println("nomnom")
  }
  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }
  }
  val cat = new Cat
  cat.crunch
  //cat.eat - inaccessible


  //constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  //before calling the parameter of Adult we need to call the parameter of the super class this is how jvm works otherwise error

  class Dog(override val creatureType: String) extends Animal{
   // or override val creatureType = "domestic"
    //override def eat = println("crunch, crunch")
    override def eat = {
      super.eat//nomnom
      println("crunch, crunch")
    }
  }
  //the above lines are equivalent to :
  //class Dog(dogType: String) extends Animal {
  //override val creatureType = dogType
  //}

  val dog  = new Dog("K9")
  dog.eat
  println(dog.creatureType)


    //type substitution(broad sense : polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  //overriding vs overloading

  //super - reference a method or variable from parent class

  //preventing overrides:
  //1 - final(class / variables / methods )
  //seal the class = extend classes in THIS FILE, prevent extension in other files

}
