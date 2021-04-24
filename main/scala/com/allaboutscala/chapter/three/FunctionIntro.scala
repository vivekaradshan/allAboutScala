package com.allaboutscala.chapter.three

import com.allaboutscala.chapter.two.Interpolation.Donut

object FunctionIntro extends App{

  println("Step 1: How to define and use a function which has no parameters and has a return type")
  def favDonut():String = {
    "Glazed Donut"
  }
  val myFavDonut = favDonut()
  println(s"My favourite donut is $favDonut")


  println("\nStep 2: How to define and use a function with no parenthesis")
  //In general, you should define your functions without parenthesis if you are defining a function that does not have any side effects.
  def leastFavoriteDonut = "Plain Donut"
  println(s"My least favorite donut is $leastFavoriteDonut")

  //3. How to define and use a function with no return type
  println("\nStep 3: How to define and use a function with no return type")
  def printDonutReport() = println("Printing donut sales report... done!")
  printDonutReport()

  println("Step 1: How to define function with parameters")
  def printDonutCost(donutName:String,quantity:Int):Double = {
    println(s"$donutName = $quantity")
    2.50 * quantity
  }

  println("\nStep 2: How to call a function with parameters")
  val totalCost = printDonutCost("Glazed Donut", 5)
  println(s"Total cost of donuts = $totalCost")


  println("\nStep 3: How to add default values to function parameters")
  def calculateDonutCost2(donutName: String, quantity: Int, couponCode: String = "NO CODE"): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity, couponCode = $couponCode")
    // make some calculations ...
    if (couponCode != "NO CODE") 2 * quantity
    else 2.50 * quantity
  }

  val totalCostWithCoupon = calculateDonutCost2("Glazed Donut", 5, "COUPON250")
  val totalCostWithoutCoupon = calculateDonutCost2("Glazed Donut", 5)

  println(s"totalCostWithCoupon: $totalCostWithCoupon")
  println(s"totalCostWithoutCoupon: $totalCostWithoutCoupon")

  println("Step 1: How to define an Option in a function parameter")
  def calculateDonutCost3(donutName: String, quantity: Int, couponCode: Option[String] = None):Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity, couponCode = $couponCode")

    couponCode match {
      case Some(coupon) =>
        val totalCost = 2.50 * quantity * 0.9
        totalCost
      case _ => 2.50 * quantity
    }
  }
    println("\nStep 2: How to call a function which has an Option parameter")
    println(s"""Total cost = ${calculateDonutCost3("Glazed Donut", 5, None)}""")
    println(s"""Total cost = ${calculateDonutCost3("Plain Donut", 5, Some("SOME_CODE"))}""")

  println(s"\nTip 1: Use the map function to extract a valid Option value")
  val favouriteDonut:Option[String] = Some("Chocolate Donut")
  favouriteDonut.map(d => println(s"favourite donut: $d"))

  val leastFavouriteDonut:Option[String] = None
  leastFavouriteDonut.map(d => println(s"least favourite donut: $d"))

  //How To Create Function With Option Return Type
  println(s"Step 1: Define a function which returns an Option of type String")
  def dailyCouponCode():Option[String] = {
//    val couponCode = "COUPON250"
      val couponCode = ""
    Option(couponCode).filter(_.nonEmpty)
  }

  println(s"\nStep 2: Call function with Option return type using getOrElse")
  val todayCoupon:Option[String] = dailyCouponCode()
  println(s"Today's Coupon Code: ${todayCoupon.getOrElse("No coupon today")}")

  println(s"\nStep 3: Call function with Option return type using pattern matching")
  dailyCouponCode() match {
    case Some(couponCode) => println(s"Today's coupon code $couponCode")
    case _ => println("Sorry there is no coupon code today")
  }

  //However, if you only care about valid values from the Option, you can use the map() function.
  println(s"\nStep 4: Call function with Option return type using map")
  dailyCouponCode().map(couponCode => println(s"Today's coupon code $couponCode"))

  println(s"""Total cost with daily coupon code = ${calculateDonutCost3("Glazed Donut", 5, dailyCouponCode())}""")

  //Learn How To Create Function With Implicit Parameters
  println(s"Step 1: How to define a function with an implicit parameter")
  def totalCost(donutType: String, quantity: Int)(implicit discount:Double)={
    println(s"Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
      totalCost
  }
  implicit val discount = 0.10
  println(s"All customer will receive a ${discount * 100}% discount")

  println("\nStep 2: How to call a function which has an implicit parameter")
  println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost("Glazed Donut", 5)}""")

  println("\nStep 3: How to define a function which takes multiple implicit parameters")
  def totalCost2(donutType: String, quantity: Int)(implicit discount: Double, storeName: String): Double = {
    println(s"[$storeName] Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }

  println("\nStep 4: How to manually pass-through implicit parameters")
  println(s"""Total cost with discount of 5 Glazed Donuts, manually passed-through = ${totalCost2("Glazed Donut", 5)(0.1, "Scala Donut Store")}""")
}
