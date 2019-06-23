package lectures.part2oop

import playground.{Cinderella, PrinceCharming}
//or
//import playground._

import java.sql.{Date=>sqlDate}
import java.util.Date

object PackagingAndImports extends App {

  //package members are available by their simple package name
  val writer = new Writer("nalin","munshi",2019)

  //import the package
  val princess = new Cinderella // fully qualified name - playground.Cinderella

  //packages are in a hierarchy
  //matching folder structure.

  //package object - to write methods, constants etc. outside everything else but we may also need some universal constants and methods so we have package objects
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming

  //1. use fully qualified name
  val d = new Date
  //val Sqld = new java.sql.Date(2019,5,4)
  //2. aliasing
  val Sqld = new sqlDate(2019,5,4)


}
