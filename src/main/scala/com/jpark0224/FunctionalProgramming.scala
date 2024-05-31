package com.juliepark0224

object FunctionalProgramming extends App {

    // Scala is Object-oriented
    class Person(name: String) {
        def apply(age: Int) = println(s"I have aged $age years")
    }

    val bob = new Person("Bob")
    bob.apply(43)
    bob(43) // INVOKING bob as a function === bob.apply(43)

    /* 
        Scala runs on the JVM 
        Functional programming: 
        - compose functions
        - pass functions as args
        - return functions as results
     
     Conclusion: FunctionX = Function1, FGunction2, ... Function22
     */

     // [Int, Int] means the function takes in Int and returns Int
     val SimpleIncrementer = new Function1[Int, Int] {
        override def apply(arg: Int): Int = arg + 1

        SimpleIncrementer.apply(23) // 24
        SimpleIncrementer(23) // same as above
        // we defined a function because the only thing this does is a function

        // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION X TYPE
     }

     // function with 2 arguments and a String return type
     val stringConcatenator = new Function2[String, String, String] {
        override def apply(arg1: String, arg2: String): String = arg1 + arg2
     }

     stringConcatenator("I love", "Scala") // "I love Scala"

     // syntactic sugars
     val doubler: Function1[Int, Int] = (x: Int) => 2 * x
     doubler(4) // 8

     // same as above
     val doubler2: Int => Int = (x: Int) => 2 * x

     /* 
     equivalent to much longer:
        new Function1[Int, Int] {
            override def apply(x: Int) = 2 * x
        }
      */

      // higher-order functions: take functions as args/return functions as results
      // x => x + 1 anonymous function is passed as an argument to the map method
      val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) // HOF
      val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))

      /* 
      alternative syntax
        val aFlatMappedList = List(1,2,3).flatMap { x =>
            List(x, 2 * x)
        }
       */
      val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3)
      // alternative syntax
      val aFilteredList2 = List(1,2,3,4,5).filter(_ <= 3)

      // chaining is possible because all methods return a new list
      // example: all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
      val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))

      // for comprehensions
      val alternativePairs = for {
        number <- List(1,2,3)
        letter <- List('a', 'b', 'c')
      } yield s"$number-$letter"
      // equivalent to the map/flatMap chain above

      /* 
        Collections
       */

       // lists
       val aList = List(1,2,3,4,5)
       val firstElement = aList.head
       val rest = aList.tail
       val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
       val anExtendedList = 0 :+ aList + 6 // List(1,2,3,4,5,6)

       // sequences
       // https://www.geeksforgeeks.org/difference-between-a-seq-and-a-list-in-scala/
       val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
       val accessedElement = aSequence(1) // the element at index 1: 2

       // vectors: fast Seq implementation
       val aVector = Vector(1,2,3,4,5)

       // sets = no duplicates, no order
       val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
       val setHas5 = aSet.contains(5) // false
       val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
       val aRemovedSet = aSet - 3 // Set(1,2,4)

       // ranges
       val aRange = 1 to 1000
       val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6..., 2000)

       // tuples = groups of values under the same value
       val aTuple = ("Bon Jovi", "Rock", 1982)

       // maps
       val aPhonebook: Map[String, Int] = Map(
        ("Daniel", 2342355),
        "Jane" -> 34345 // equivalent to ("Jane", 34345)
       )

}