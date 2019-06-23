package exercises

abstract class MyList[+A] {

  /*
  head = first element in the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with element added
  (override) toString => a string representation of the list

   */

  def head() : A
  def tail() : MyList[A]
  def isEmpty(): Boolean
  def add[B>:A](element : B) : MyList[B]
  def printElements : String
  //polymorphic call
  override def toString() : String = "[" + printElements + "]"


  //higher-order functions => receive functions as parameters or return other functions as result
  def map[B] (transformer : A => B) : MyList[B]
  def flatMap[B](transformer : A => MyList[B]) : MyList[B]
  def filter(myPredicate: A => Boolean) : MyList[A]
  //concatenation
  def ++[B>:A](list : MyList[B]) : MyList[B]


  //hofs
  def foreach(f:A => Unit):Unit
  def sort(compare: (A,A)=> Int): MyList[A]
  def zipWith[B,C](list: MyList[B], zip: (A,B)=>C): MyList[C]
  def fold[B](start: B)(operator: (B,A)=>B): B
}

case object Empty extends MyList[Nothing]{
  def head() : Nothing = throw new NoSuchElementException
  def tail() : MyList[Nothing] = throw new NoSuchElementException
  def isEmpty(): Boolean = true
  def add[B>:Nothing](element : B) : MyList[B] = new Cons(element,Empty)
  //def toString() : String = ???
  def printElements : String = " "

  def map[B] (transformer : Nothing => B) : MyList[B] = Empty
  def flatMap[B](transformer : Nothing => MyList[B]) : MyList[B] = Empty
  def filter(myPredicate: Nothing => Boolean) : MyList[Nothing] = Empty

  def ++[B>:Nothing](list : MyList[B]) : MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing)=>Int): MyList[Nothing] = Empty

  def zipWith[B,C](list: MyList[B], zip: (Nothing,B)=>C): MyList[C]={
    if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  }
  def fold[B](start: B)(operator: (B,Nothing)=>B): B = start
}

case class Cons[+A] (h: A, t: MyList[A]) extends MyList[A]{
  def head() : A = h
  def tail() : MyList[A] = t
  def isEmpty(): Boolean = false
  def add[B>:A](element : B) : MyList[B] = new Cons(element, this)
  //def toString() : String = ???
  def printElements : String =
    if(t.isEmpty()) h.toString()
    else h + " " + t.printElements



  /*
  [1,2,3].map(n*2)
  = new Cons(2,[2,3].map(n*2))
  = new Cons(2,new Cons(4,[3].map(n*2)))
  = new Cons(2,new Cons(4,new Cons(6,Empty.map(n*2))))
  = new Cons(2,new Cons(4,new Cons(6,Empty)))
   */
  def map[B] (transformer : A => B) : MyList[B] =
    new Cons(transformer.apply(h),t.map(transformer))

  //[1,2].flatMap(n=>[n,n+1])
  /*
  =[1,2] ++ [2].flatMap(n=>[n,n+1])
  =[1,2] ++ [2,3] ++ Empty.flatMap(n=>[n,n+1])
  =[1,2,2,3]
   */
  def flatMap[B](transformer : A => MyList[B]) : MyList[B] =
    transformer.apply(h) ++ t.flatMap(transformer)

  /*
  [1,2,3].filter(n%2)
  = [2,3].filter(n%2)
  = new Cons(2,[3].filter(n%2))
  = new Cons(2,Empty.filter(n%2))
  = new Cons(2,Empty)
   */
  def filter(predicate: A => Boolean) : MyList[A] =
    if(predicate.apply(h)) new Cons(h,t.filter(predicate))
    else t.filter(predicate)

  /*
  [1,2] ++ [3,4,5]
  (after several steps)=new Cons(1,new Cons(2,new Cons(3,new Cons(4,new Cons(5,Empty)))))
   */
  def ++[B>:A](list : MyList[B]) : MyList[B] =
    new Cons(h, t ++ list)


  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }


  def sort(compare: (A, A)=>Int): MyList[A] ={
    def insert(x: A, sortedList: MyList[A]): MyList[A]=
      if(sortedList.isEmpty) new Cons(x,Empty)
      else if(compare(x,sortedList.head) <= 0) new Cons(x,sortedList)
      else new Cons(sortedList.head,insert(x,sortedList.tail))
    val sortedTail = t.sort(compare)
    insert(h,sortedTail)
  }

  def zipWith[B,C](list: MyList[B], zip: (A,B)=>C): MyList[C] ={
    if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h,list.head), t.zipWith(list.tail,zip))
  }

  /*
  [1,2].fold(0)(+)
  [2].fold(1)(+)
  [].fold(3)(+)
   */
  def fold[B](start: B)(operator: (B,A)=>B): B = {
    val newStart = operator(start, h)
    t.fold(newStart)(operator)
  }

}


object ListTest extends App{
//  val list = new Cons(1,new Cons(2, new Cons(3,Empty)))
  ////  println(list.head())
  ////  println(list.tail.head)
  ////  println(list.add(4).head)
  ////
  ////  println(list.toString())

  val listOfIntegers : MyList[Int] = new Cons(1,new Cons(2, new Cons(3,Empty)))
  val cloneListOfIntegers : MyList[Int] = new Cons(1,new Cons(2, new Cons(3,Empty)))
  val listOfStrings : MyList[String] = new Cons("hello",new Cons("scala",Empty))
  val anotherListOfIntegers : MyList[Int] = new Cons(4,new Cons(5,Empty))
    println(listOfIntegers.head())
    println(listOfIntegers.tail.head)
    println(listOfIntegers.add(4).head)

    println(listOfStrings.toString())

    println(listOfIntegers.map(_*2).toString)

    println(listOfIntegers.filter(_%2==0))

    println(listOfIntegers ++ anotherListOfIntegers)

    println(listOfIntegers.flatMap(elem => new Cons(elem,new Cons(elem+1,Empty))).toString)


    println(cloneListOfIntegers == listOfIntegers)  // true


  listOfIntegers.foreach(x => println(x))
  listOfIntegers.sort((x,y) => y-x)
  listOfIntegers.zipWith[String,String](listOfStrings,_+"-"+_)
  listOfIntegers.fold(0)(_ + _)

  /*
  1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
  2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
  3. MyList
    - map(transformer) => MyList
    - filter(predicate) => MyList
    -flatMap(transformer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends Transformer[String, Int]
    eg:-
    [1,2,3].map(n*2) => [2,4,6]
    [1,2,3,4].filter(n%2) => [2,4]
    [1,2,3].flatMap(n => [n,n+1]) => [1,2,2,3,3,4]
   */



}

//class imp(list: List[Int]) extends MyList{
//
//  override def head(): Int = list(0)
//
//  override def tail(): Unit = println(list)
//
//  override def isEmpty(): Boolean = if (list == null) true else false
//
//  override def add(a: Int): List[Int] = list :+ a
//
//  override def toString() : String = list.toString
//}
//
//object nam extends App{
//  List(1,2,3,4)
//
//  val mylist = new imp(List(1,2,3))
//  println(mylist.head())
//  println(mylist.tail())
//  println(mylist.isEmpty())
//  println(mylist.add(4))
//
//  println(mylist.toString())
//}