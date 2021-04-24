package com.allaboutscala.chapter.three

object curriedFunctions extends App{

  // allows you to create functions where each parameter is enclosed within its own group using the ()
  println("Step 1: How to define function with curried parameter groups")
  def totalCost(donutType: String)(quantity: Int)(discount: Double) = {
    println(s"Calculating total cost for $quantity $donutType with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }

  println("\nStep 2: How to call a function with curried parameter groups")
  println(s"Total cost = ${totalCost("Glazed Donut")(10)(0.1)}")

  println("\nStep 3: How to create a partially applied function from a function with curried parameter groups")
  val totalCostForGlazedDonut = totalCost("Glazed Donut")_

  //totalCostForGlazedDonuts is a partially applied function because it only fills in the first parameter Glazed Donut. It uses the wildcard _ as a placeholder for the other parameters.
  //Note that the return type of the partially applied function totalCostForGlazedDonuts is Int => Double => Double. The first Int is for our quantity parameter, the Double is for discount parameter and the last Double the return type of the function.
  // In short, the partially applied function creates a chain of functions.
  println("\nStep 3: How to call a function with partially applied functions")
  println(s"Total cost = ${totalCostForGlazedDonut(10)(0.05)}")
}
