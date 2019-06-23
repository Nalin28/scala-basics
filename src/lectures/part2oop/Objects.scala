package lectures.part2oop

object Objects {//with main no need for App

  //acts as static-sharing the same instance

  //Scala does not have class level functionality("static")

  object Person {
    val N_EYES = 2;

    def canFly: Boolean = false

    //factory method - because the sole purpose of it is to build a person given some parameters
    def from(mother: Person, father: Person): Person = new Person("Bobbie ")

    // or def apply
  }

  class Person(val name: String) {
    //instance-level functionality from "static"/"class" levels
  }

  def main(args: Array[String]): Unit = {
    //THESE ARE CALLED COMPANIONS (give instance level as well as object level functionality)
    println(Person.N_EYES)
    println(Person.canFly)

    //Scala object = SINGLETON INSTANCE
    //val mary = Person
    //val john = Person
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john) //point to the same instance hence prints true and false in the instantiation case

    val bobbie = Person.from(mary, john)
    //val bobbie = Person(mary, john)

    //Scala Applications = Scala object with
    //def main(args: Array[String]): Unit
  }
}
