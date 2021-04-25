package com.allaboutscala.chapter.three

object HOFs extends App{
  println("\nStep 2: How to define a higher order function which takes another function as parameter")
  def totalCostWithDiscountFunctionParameter(donutType: String)(quantity: Int)(f: Double => Double) = {
    println(s"Calculating total cost for $quantity $donutType")
    val totalCost = 2.50 * quantity
    f(totalCost)
  }

  println("\nStep 3: How to call higher order function and pass an anonymous function as parameter")
  val totalCostOf5Donuts = totalCostWithDiscountFunctionParameter("Glazed Donut")(10){totalCost =>
  val discount = 0.2
  totalCost - discount}
  println(s"Total cost of 5 Glazed Donuts with anonymous discount function = $totalCostOf5Donuts")

  println("\nStep 4: How to define and pass a function to a higher order function")
  def applyDiscount(totalCost: Double) = {
    val discount = 0.2
    totalCost - discount
  }

  val totalCostOf5DonutsUsingFunction = totalCostWithDiscountFunctionParameter("Glazed Donut")(10)(applyDiscount(_))
  println(s"Total cost of 5 Glazed Donuts with anonymous discount function = $totalCostOf5DonutsUsingFunction")
}
