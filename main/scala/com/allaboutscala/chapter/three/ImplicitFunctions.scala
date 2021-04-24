package com.allaboutscala.chapter.three

object ImplicitFunctions extends App{
  //implicit function which will allow you to provide extension methods or functions to pretty much any type or class.

  println("Step 1: How to create a wrapper String class which will extend the String type")
  class DonutString(s:String) {
    def isFavouriteDonut:Boolean = s == "Glazed donut"
  }

  println("\nStep 2: How to create an implicit function to convert a String to the wrapper String class")
  object DonutConversion {
    implicit def stringToDonut(s:String) = new DonutString(s)
  }

  println("\nStep 3: How to import the String conversion so that it is in scope")
  import DonutConversion._

  println("\nStep 4: How to create String values")
  val glazedDonut = "Glazed donut"
  val plainDonut = "Plain donut"

  println("\nStep 5: How to access the custom String function called isFavaoriteDonut")
  println(s"Your favourite Donut is ${glazedDonut.isFavouriteDonut}")
  println(s"Your favourite Donut is ${plainDonut.isFavouriteDonut}")

}
