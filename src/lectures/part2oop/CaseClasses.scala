package lectures.part2oop

object CaseClasses extends App{

  //shortcut for defining companion objects and other boilerplate like equals, hashCode, toString

  case class Person(name : String, age : Int)

  //1. class parameters are fields
  val jim = new Person("Jim", 25)
  println(jim.name)

  //2. sensible toString
  //println(instance) = println(instance.toString()) => another form of syntactic sugar
  println(jim.toString)

  //3. equals and hashCode method implemented OOTB(out of the box)
  val jim2 = new Person("Jim",25)
  println(jim == jim2) // true

  //4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary",23)//no need for new they have apply methods so we can give it in this form as well

  //6. CCs are serializable
  //Akka

    //7. CCs have extractor patterns = CCs can be used in pattern matching


  case object UnitedKingdom{
    def name : String = "the UK of GB and NI"
  }

  /*
  expand MyList - use case classes and case objects
   */
}
