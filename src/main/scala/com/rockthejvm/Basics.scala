package com.rockthejvm

object Basics extends App {
  
    // defining a value
    val meaningOfLife: Int = 42

    // Int, Boolean, Char, Double, Float, String
    val aBoolean = false // type is optional

    // strings and string operations
    val aString = "I love Scala"
    val aComposedString = "I" + " " + "love" + " " + "Scala"
    val anInterpolatedString = s"The meaning of life is $meaningOfLife"

    // expressions = structures that can be reduced to a value
    val anExpression = 2 + 3

    // if-expression = assign a value depending on conditions
    val ifExpression = if (meaningOfLife > 43) 56 else 999 // in other languages: meaningOfLife > 43 ? 56 : 999
    val chainedIfExpression = 
        if (meaningOfLife > 43) 56
        else if (meaningOfLife < 0) -2
        else if (meaningOfLife > 999) 78
        else 0

    // code blocks
    val aCodeBlock = {
        // definitions
        val aLocalValue = 67

        // value of block is the value of the last expression
        aLocalValue + 3
    }

    // define a function. The value is the returned value
    def myFunction(x: Int, y: String): String = y + " " + x
    def mySecondFunction(x: Int, y: String): String = {
        y + " " + x
    }

    // recursive functions
    def factorial(n: Int): Int = 
        if (n <= 1) 1
        else n * factorial(n - 1)

    /* 
        factorial(5) = 5 * factorial(4)
        and so on
        factorial(1) = 1
     */

     // In Scala, we don't use loops or iteration. We use RECURSION!
     // variables or loops are heavily discouraged. 

     // the Unit type = no meaningful value === "void" in other languages
     // it is the type of SIDE EFFECTS
     println("I love Scala")

     def myUnitReturningFunction(): Unit = {
        println("I don't love returning Unit")
     }

}
