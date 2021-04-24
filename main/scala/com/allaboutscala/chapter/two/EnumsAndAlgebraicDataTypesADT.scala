package com.allaboutscala.chapter.two

object EnumsAndAlgebraicDataTypesADT extends App{

  object Weekday extends Enumeration {
    type Weekday = Value
    val Mon, Tue, Wed, Thurs, Fri, Sat, Sun = Value
  }

  import Weekday._

  def isWorkingDay(d:Weekday) = !(d == Sat || d == Sun)

  Weekday.values filter isWorkingDay foreach println


}
