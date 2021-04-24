package com.allaboutscala.chapter.two

object tuplesAndPatternMatching extends App{
  //PATTERN-MATCHING

  println("Step 1: Pattern matching 101 - a very basic example")
  val donutType = "Glazed Donut"
  donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Strawberry Donut" => "Tasty"
  }

  println("\nStep 2: Pattern matching and return the result")

  val tasteLevel = donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Strawberry Donut" => "Tasty"
  }
  println(s"$tasteLevel - $donutType")

  println("\nStep 3: Pattern matching using the wildcard operator")
  val donutType2 = "Plain Donut"
  val tasteLevel2 = donutType2 match {
    case "Glazed Donut" => "Very tasty"
    case "Strawberry Donut" => "Tasty"
    case _ => "Normal"
  }
  println(s"$tasteLevel2 - $donutType2")

  println("\nStep 4: Pattern matching with two or more items on the same condition")
  val tasteLevel3 = donutType match {
    case "Strawberry Donut"|"Glazed Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Normal"
  }

  println(s"$tasteLevel3 - $donutType")

  println("\nStep 5; Pattern matching and using if expressions in the case clause")
  val tasteLevel4 = donutType match {
    case donut if donut.contains("Strawberry") || donut.contains("Glazed") => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Normal"
  }
  println(s"$tasteLevel3 - $donutType")

  println("\nStep 6: Pattern matching by types")
  val priceOfDonut: Any = 2.50
  val priceType = priceOfDonut match {
    case price: Int => "Int"
    case price: Double => "Double"
    case price: Float => "Float"
    case price: String => "String"
    case price: Boolean => "Boolean"
    case price: Char => "Char"
    case price: Long => "Long"
  }
  println(s"Donut price type: $priceType")

  //TUPLES
  println("Step 1: Using Tuple2 to store 2 data points")
  val glazedDonutTuple = Tuple2("Glazed Donut", "Very Tasty")
  println(s"Glazed Donut with 2 data points = $glazedDonutTuple")

  println("\nStep 2: Access each element in tuple")
  println(s"${glazedDonutTuple._1} is ${glazedDonutTuple._2}")


  println("\nStep 3: How to use pattern matching on Tuples")
  val glazedDonut = Tuple3("Glazed Donut", "Very Tasty", 2.50)
  val strawberryDonut = Tuple3("Strawberry Donut", "Very Tasty", 2.50)
  val plainDonut = Tuple3("Plain Donut", "Tasty", 2)
  val donutList = List(glazedDonut, strawberryDonut, plainDonut)

  val priceOfDonutTuple = donutList.foreach(tuple =>
  tuple match {
    case ("Plain Donut", taste,price) => println(plainDonut)
    case d if d._1 == "Glazed Donut" => println(glazedDonut)
    case _ => None
  })
  println("\nStep 4: Elegant Way of pattern matching")

  val priceOfDonutTupleElegant = donutList.foreach{
      case ("Plain Donut", taste,price) => println(plainDonut)
      case d if d._1 == "Glazed Donut" => println(glazedDonut)
      case _ => None
    }

  println("\nStep 5: Shortcut for creating Tuples")
  val chocolateDonut = ("Chocolate Donut", "Very Tasty", 3.0)
  println(s"Chocolate donut taste level = ${chocolateDonut._2}, price = ${chocolateDonut._3}")
}
