package com.allaboutscala.chapter.two

object optionSomeNone extends App{
  println("Step 1: How to use Option and Some - a basic example")
  val glazedDonutTaste: Option[String] = Some("Very Tasty")
  println(s"Glazed Donut taste = ${glazedDonutTaste.get}")

  println("Step 2: How to use Option and None - a basic example")
  val glazedDonutTasteNone: Option[String] = None
  println(s"Glazed Donut taste = ${glazedDonutTasteNone.getOrElse("Glazed Donut")}")

  println("\nStep 3: How to use Pattern Matching with Option")
  glazedDonutTasteNone match {
    case Some(name) => println(s"$name")
    case None => println("No value was found")
  }


}
