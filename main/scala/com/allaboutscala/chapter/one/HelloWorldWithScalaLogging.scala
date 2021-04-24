package com.allaboutscala.chapter.one
import com.typesafe.scalalogging.LazyLogging

object HelloWorldWithScalaLogging extends App with LazyLogging {
  logger.info("Hello World from Scala Logging")

  println("Step 1: How to escape a Json String")
  val donutJson: String ="{\"donut_name\":\"Glazed Donut\",\"taste_level\":\"Very Tasty\",\"price\":2.50}"
  val donutJson3: String = """{"donut_name":"Glazed Donut","taste_level":"Very Tasty","price":2.50}"""
  println(s"donutJson: $donutJson")
  println(s"donutJson: $donutJson3")

  val donutJson4: String =
    """
      |{
      |"donut_name":"Glazed Donut",
      |"taste_level":"Very Tasty",
      |"price":2.50
      |}
      """
      .stripMargin
  println(s"donutJson: $donutJson4")

  println("\nTip: stripMargin using a different character")
  val donutJson5: String =
    """
      #{
      #"donut_name":"Glazed Donut",
      #"taste_level":"Very Tasty",
      #"price":2.50
      #}
    """ .stripMargin('#')
  println(s"donutJson5 = $donutJson4")

  //IF-ELSE STATEMENT
  val numberOfPeople = 20
  val donutsPerPerson = 2
  val defaultDonutsToBuy = 8

  println("\nStep 3: Using if, else if, and else clause as a statement")
  if(numberOfPeople > 10) {
    println(s"Number of donuts to buy = ${numberOfPeople * donutsPerPerson}")
  } else if (numberOfPeople == 0) {
    println("Number of people is zero.")
    println("No need to buy donuts.")
  } else {
    println(s"Number of donuts to buy = $defaultDonutsToBuy")
  }


  println("\nStep 4: Using if and else clause as expression")
  val numberOfDonutsToBuy = if(numberOfPeople > 10) (numberOfPeople * donutsPerPerson) else defaultDonutsToBuy
  println(s"Number of donuts to buy = $numberOfDonutsToBuy")

  //FOR LOOP STATEMENT
  println("Step 1: A simple for loop from 1 to 5 inclusive")
  for(numberOfDonuts <- 1 to 5)
    println(s"Number of donuts to buy = $numberOfDonuts")

  println("Step 1: A simple for loop from 1 to 5 inclusive")
  for(numberOfDonuts <- 1 until 5)
    println(s"Number of donuts to buy = $numberOfDonuts")

  println("\nStep 3: Filter values using if conditions in for loop")
  val donutIngredients = List("flour", "sugar", "egg yolks", "syrup", "flavouring")

  for(ingredients <- donutIngredients if ingredients == "sugar")
    println(s"Key Ingredient: $ingredients")

  println("\nStep 4: Filter values using if conditions in for loop and return the result back using the yield keyword")

  val sweeteningIngredients = for{
    ingredient <- donutIngredients
    if(ingredient == "sugar" || ingredient == "syrup")
  } yield ingredient
  println(s"Sweeting Ingredients are : $sweeteningIngredients")

  println("\nStep 5: Using for comprehension to loop through 2-Dimensional array")
  val twoDimensionalArray = Array.ofDim[String](2,2)
  twoDimensionalArray(0)(0) = "flour"
  twoDimensionalArray(0)(1) = "sugar"
  twoDimensionalArray(1)(0) = "egg"
  twoDimensionalArray(1)(1) = "syrup"

  for {x <- 0 until 2
       y <- 0 until 2} println(s"Donut Ingredients at ${(x,y)} = ${twoDimensionalArray(x)(y)}")

  println("\nStep 6: Storing our ranges into collections")
  val listFrom1To5 = (1 to 5).toList
  println(s"Range to list = ${listFrom1To5}")

  val setFrom1To5 = (1 to 5).toSet
  println(s"Range to set = ${setFrom1To5}")

  val sequenceFrom1To5 = (1 to 5).toSeq
  println(s"Range to sequence = ${sequenceFrom1To5}")

  val arrayFrom1To5 = (1 to 5).toArray
  println(s"Range to array = `${arrayFrom1To5.mkString(" ")}")

  arrayFrom1To5.foreach{i:Int => print(i)}
  sequenceFrom1To5.foreach(println(_))



}
