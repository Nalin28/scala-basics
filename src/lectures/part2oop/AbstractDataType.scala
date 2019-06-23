package lectures.part2oop

object AbstractDataType extends App{

  //classes which contain unimplemented or abstract methods are called abstract classes
  //eg:-

  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }
//abstract classes cannot be instantiated
  //they are created to be extended later

  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat : Unit = println("crunch crunch")
  }



  //traits- ultimate abstract data types in scala

  trait ColdBlooded
  trait Carnivore {
    def eat(animal: Animal):Unit
    val preferedMeal : String = "fresh Meat"
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded{
    override val creatureType: String = "croc"
    def eat : Unit = println("nomnomnom")
    def eat(animal : Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  (croc.eat(dog))


  //traits vs abstract classes(both can have abstract as well as declared members)
  //1- traits cannot have constructor parameters
  //2- you can extend only one class but inherit multiple traits
  //3- traits="behaviour" abstract class="things"

}
