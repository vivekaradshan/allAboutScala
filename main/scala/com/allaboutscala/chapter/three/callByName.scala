package com.allaboutscala.chapter.three

import scala.util.Random

object callByName extends App{
  println("Step 1: How to define a List with Tuple3 elements")
  val listOfOrders = List(("Glazed Donut", 5, 2.50),("Vanilla Donut", 10, 3.50))
  println("\nStep 2: How to define a function to loop through each Tuple3 of the List and calculate total cost")

  def placeOrder(orders: List[(String,Int,Double)])(exchangeRate:Double) = {
    var totalCost = 0.0
    orders.foreach{ order =>
      val costOfItem = order._2 * order._3 * exchangeRate
      println(s"Total cost of ${order._2} ${order._1} is ${costOfItem}")
      totalCost += costOfItem
    }
    totalCost
  }
  println("\nStep 3: How to call function with curried group parameter for List of Tuple3 elements")
  println(s"Total cost of order ${placeOrder(listOfOrders)(0.5)}")

  println("\nStep 4: How to define a call-by-name function")
  def placeOrderWithByNameParameter(orders: List[(String,Int,Double)])(exchangeRate: => Double) = {
    var totalCost = 0.0
    orders.foreach{ order =>
      val costOfItem = order._2 * order._3 * exchangeRate
      println(s"Total cost of ${order._2} ${order._1} is ${costOfItem}")
      totalCost += costOfItem
    }
    totalCost
  }

  println("\nStep 5: How to define a simple USD to GBP function")
  val randomExchangeRate = new Random(10)
  def usdToGbp: Double = {
    val rate = randomExchangeRate.nextDouble()
    println(s"Fetching USD to GBP exchange rate = $rate")
    rate
  }
  //The call-by-name function parameter exchangeRate: => Double will evaluate any exchangeRate function each time it is called.
  //This is in contrast to the function defined in Step 1 above which had a call-by-value function parameter for exchange rate.
  // This meant that any exchange rate passed through would be evaluated only once.

  println("\nStep 6: Substituting the USD to GBP for exchange rate in call-by-name function")
  println(s"Total cost of order ${placeOrderWithByNameParameter(listOfOrders)(usdToGbp)}")
  println("\nStep 7: Substituting the USD to GBP for exchange rate in call-by-value function")
  println(s"Total cost of order ${placeOrder(listOfOrders)(usdToGbp)}")
}
