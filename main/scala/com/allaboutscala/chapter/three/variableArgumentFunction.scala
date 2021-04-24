package com.allaboutscala.chapter.three

object variableArgumentFunction extends App{

  def donutReport(names: String*): Unit = {
    println(s"Donut report - ${names.mkString(" - ")}")
  }

  println("\nStep 2: How to call function which takes variable number of String arguments")
  donutReport("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  donutReport("Chocolate Donut")

  val listOfDonuts: List[String] = List("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  val seqOfDonuts: Seq[String] = Seq("Glazed Donut", "Strawberry Donut")
  val arrayOfDonuts: Array[String] = Array("Glazed Donut")

  //if we use donutReport(listOfDonuts) it will throw error ,
  // instead you will need to use a special syntax called type ascription
  donutReport(listOfDonuts: _*)
  donutReport(seqOfDonuts: _*)
  donutReport(arrayOfDonuts: _*)
}
