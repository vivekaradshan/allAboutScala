package com.allaboutscala.chapter.three

object typedFunctions extends App{

  //create typed functions which will allow you to specify the types of the parameters when calling the function
  println("Step 1: How to define a function which takes a String parameter")
  def applyDiscount(couponCode:String) = {
    println(s"The coupon code for today $couponCode")
  }

  println("\nStep 2: How to define a function which takes a parameter of type Double")
  def applyDiscount(amount:Double) ={
    println(s"The amount of discount for today $amount")
  }


  println("\nStep 3: Calling applyDiscount function with String or Double parameter types")
  applyDiscount("COUPON_1234")
  applyDiscount(10)

  println("\nStep 4: How to define a generic typed function which will specify the type of its parameter")
  def applyDiscount[T](discount:T) = {
    discount match {
      case d: String =>
        println(s"Lookup percentage discount in database for $d")
      case d: Double =>
        println(s"$d discount will be applied")
      case _ =>
        println("Unsupported type function")
    }
  }

  applyDiscount[String]("COUPON_1234")
  applyDiscount[Double](20.50)

  println("\nStep 3: How to define a generic typed function which also has a generic return type")
  def applyDiscountWithReturnType[T](discount:T):Seq[T] = {
    discount match {
      case d : String =>
        println(s"Lookup percentage discount in database for $d")
        Seq[T](discount)
      case d : Double =>
        println(s"$d discount will be applied")
        Seq[T](discount)
      case d @_ =>
        println("Unsupported type function")
        Seq[T](discount)
    }
  }

  println("\nStep 4: How to call a generic typed function which also has a generic return type")
  println(s"Result of applyDiscountWithReturnType of return type string: ${applyDiscountWithReturnType[String]("COUPON_1234")}")
  println(s"Result of applyDiscountWithReturnType of return type double: ${applyDiscountWithReturnType[Double](20.50)}")
  println(s"Result of applyDiscountWithReturnType of return type char: ${applyDiscountWithReturnType[Char]('C')}")
}
