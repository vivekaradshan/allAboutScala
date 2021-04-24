package com.allaboutscala.chapter.three

object functionAsSymbols extends App{


  class DonutCostCalculator {
    val totalCost = 100

    def minusDiscount(discount: Double):Double = {
      donutCostCalculator.totalCost - discount
    }

    def -(discount: Double): Double = {
      donutCostCalculator.totalCost - discount
    }

  }



  println("Step 1: How to create and instantiate a class")
  val donutCostCalculator = new DonutCostCalculator()


  println("\nStep 2: How to call a function from an instantiated class")
  println(s"Calling minusDiscount() function = ${donutCostCalculator.minusDiscount(10.5)}")
  println(s"Calling minusDiscount() function = ${donutCostCalculator.-(10.5)}")
  println(s"Calling minusDiscount() function = ${donutCostCalculator - 10.5}")

}
