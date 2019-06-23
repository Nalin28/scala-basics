package lectures.part2oop

object Generics extends App{

  //  class MyList[A]{ // generic type
  //    //use of type A
  //  }
  //  trait MyList1[A]{
  //
  //  }
  //works for traits as well
  class MyMap[Key,Value]

  //  val listOfIntegers = new MyList[Int]
  //  val listOfStrings = new MyList[String]


  //generic methods
  //  object MyList{
  //    def empty[A] : MyList[A] = ???
  //  }
  //val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. so does a list[Cat] extends a list[Animal] - yes = COVARIANCE
  //similarly a list[Dog] extends list[Animal]

  class CovariantList[+A]
  val animal : Animal = new Cat
  val animalList : CovariantList[Animal] = new CovariantList[Cat]

  //animalList.dd(new Dog) ??? HARD QUESTION(it pollutes the animal list and makes it cat+dog which = animals) => we return a list of animals
  //2. No = INVARIANCE

  class InvariantList[A]
  //val invariantAnimal : InvariantList[Animal] = new InvariantList[Cat] => cannot be done


  //Hell! no!
  //3. CONTRAVARIANCE
  class ContravariantList[-A]//replacing cats with animals

  val contravariantList : ContravariantList[Cat] = new ContravariantList[Animal]//counter intuitive since how can cats be substituted with any animal
  //eg:-
  class Trainer[-A]
  val trainer : Trainer[Cat] = new Trainer[Animal]//makes sense since a trainer for any animal can train cats




  //bounded types - allow to use generics only for subclass of diff. type or super class of diff. type
  //only accepts type parameters which are subtypes of animal
  class Cage[A <: Animal] (animal : A)
  //class Cage[A >: Animal] (animal : A) => only takes supertypes
  val cage = new Cage(new Dog)

  //val newCage = new Cage(new Car) => wrong

class MyList[+A]{
  def add[B>:A](element: B) : MyList[B] = ???
  /*
  A = Cat
  B = Dog = Animal
  this implies if I put in dogs in the cat(A) list then it becomes animal(B) so the resultant of it will be a list of animals(B)
   */
}



}
