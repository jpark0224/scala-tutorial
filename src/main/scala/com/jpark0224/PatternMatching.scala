package com.juliepark0224

object PatternMatching extends App {
  
    // swtich expression
    val anInterger = 55
    val order = anInterger match {
        case 1 => "first"
        case 2 => "second"
        case 3 => "third"
        case _ => anInterger + "th"
    }

    // pattern match is an EXPRESSION

    // Case class decomposition
    case class Person(name: String, age: Int)
    val bob = Person("Bob", 43)

    val personGreeting = bob match {
        case Person(n, a) => s"Hi, my name is $n and I am $a years old."
        case _ => "Something else"
    }

    // deconstructing tuples
    val aTuple = ("Bon Jovi", "Rock")
    val bandDescription = aTuple match {
        case (band, genre) => s"$band belongs to the genre $genre"
        case _ => "I don't know what you're talking about"
    }

    // decomposig lists
    val aList = List(1,2,3)
    val listDescriptiob = aList match {
        case List(_, 2, _) => "List containing 2 on its second position"
        case _ => "unknown list"
    }

    // if PM doesn't match anything, it will throw a MatchError and crash the program. 
    // PM will try all cases in sequence. If case _ comes first, its return value will be returned.
}
