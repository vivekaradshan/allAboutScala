package com.allaboutscala.chapter.two

object enumerationTutorial extends App{
  /*
  Scala there is no enum keyword.
  Instead, Scala provides an Enumeration class which you can extend in order to create your enumerations
   */

  println("Step 1: How to create an enumeration")
  object Donut extends Enumeration {
    type Donut = Value
    val Glazed = Value("Glazed")
    val Strawberry  = Value("Strawberry")
    val Plain       = Value("Plain")
    val Vanilla     = Value("Vanilla**")
  }
  import Donut._

  println(Vanilla.id, Vanilla)
  println("\nStep 2: How to print the String value of the enumeration")
  println(s"Vanilla donut string value = ${Donut.Vanilla}")

  println("\nStep 3: How to print the String value of the enumeration Id")
  println(s"Vanilla donut string value = ${Donut.Vanilla.id}")

  println("\nStep 4: How to print all the values listed in Enumeration")
  println(s"Donut Types = ${Donut.values}")

  println("\nStep 5: How to pattern match on enumeration values")
  Donut.values.foreach{
    case  d if (d == Donut.Strawberry)||(d == Donut.Glazed) => println(s"My favourite donut $d")
    case _ => None
  }

  println("\nStep 6: How to change the default ordering of enumeration values")

  object DonutTaste extends Enumeration {
    type DonutTaste = Value
    val Tasty = Value(2, "Glazed")
    val VeryTasty = Value(3, "Choclate")
    val Ok = Value(1, "Plain")
  }
  println(s"${DonutTaste.Tasty.id} - ${DonutTaste.Tasty}")
}
