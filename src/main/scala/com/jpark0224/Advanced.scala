package com.juliepark0224

import java.util.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  
    // lazy evaluation: useful in infinite collections
    /* 
    The compiler does not immediately evaluate the bound expression of a lazy val. 
    It evaluates the variable only on its first access.
    Upon initial access, the compiler evaluates the expression and stores the result in the lazy val. 
    Whenever we access this val at a later stage, no execution happens, and the compiler returns the result.
     */
    lazy val aLazyValue = 2
    lazy val lazyValueWithSideEffect = {
        println("I am so very lazy!")
        43
    }

    val eagerValue = lazyValueWithSideEffect + 1

    // "pseudo-collections": Option, Try
    def methodWhichCanReturnNull(): String = "hello, Scala"
    val anOption = Option(methodWhichCanReturnNull()) 
    // If the method returns a valid value, it will be Some("hello, Scala"). Some is a subtype of the option abstract type.
    // option = "collection" which contains at most one element: Some(value) or None

    val stringProcessing = anOption match {
        case Some(string) => s"I have obtained a valid string: $string"
        case None => "I obtained nothing"
    }

    // in other languagues the below is necessary to guard against null.
    // Option guards agains the need to check for null.
    if (methodWhichCanReturnNull() === null) {
        // defunsive code agains null
    }

    def methodWhichCanThrowException(): String = throw new RuntimeException
    val aTry = Try(methodWhichCanThrowException())
    // a try = "collection" with either a value if the code went well, or an exception if the code went well

    val anotherStringProcessing = aTry match {
        case Success(validValue) => s"I have obtained a valid string: $validValue"
        case Failure(ex) => s"I have obtained an exception: $ex"
    }

    // normally in other langauges
    try {
        methodWhichCanThrowException()
    } catch {
        case e: Exception => "defend against this evil exception"
    }

    // Evaluate something on another thread (async programming)
    val aFuture = Future({ 
        println("Loading...")
        Thread.sleep(1000)
        println("I have computed a value.")
        67
    })

    // future is a "collection" which contains a value when it's evaluated
    // futuer is composable with map, flatmap, and filter

    /* 
        Implicit basics
    */ 
    // #1: implicit arguments
    def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
    implicit val myImplicitInt = 46
    println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt): compiler finds an argument to pass

    // #2: implicit conversions
    implicit class MyRichInteger(n: Int) {
        def isEven() = n % 2 == 0
    }

    println(23.isEven()) // new MyRichInteger(23).isEven()
    // use this carefully
}
