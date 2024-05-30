package com.jpark0224

object ObjectOrientation extends App {
  
    // java equivalent: public static void main(String[] args) which exeuctes this object's body

    // class and instance
    class Animal {
        // define fields
        val age: Int = 0
        // define methods
        def eat() = println("I'm eating")
    }
    val anAnimal = new Animal

    // inheritance
    class Dog(val name: String) extends Animal // constructor definition
    // class definition with arguments also specify the constructor you will then use to instantiate an object.
    val aDog = new Dog("Lassie")

    // constructor arguments are NOT fields: need to put a val before the constructor argument to make it visible
    aDog.name

    // subtype polymorphism
    val aDeclaredAnimal: Animal = new Dog("Hachi") 
    aDeclaredAnimal.eat() 
    // eat method will be called from a Dog class
    // the most derived method will be called at runtime

    // abstract class: not all methods or fields needs implementation
    abstract class WalkingAnimal {
        val hasLegs = true // all fields and methods are by default public
        protected val hasWings = false // only this class and its descendents have access to this
        private val hasEyes = true // only this class has access to this
        def walk(): Unit // I don't have to assign any value to this. Whichever class that extends WalkingAnimal
        // will need to override this method and provide implementation.
    }

    // interface = ultimate abstract type, meaning you can leave everything unimplemented
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    trait Philosopher {
        def ?!(thought: String): Unit // valid method name
    }

    // single-class inheritance, multi-trait "mixing"
    class Crocodile extends Animal with Carnivore with Philosopher{
        // when we implement a method that is also present in super type, it is called override
        override def eat(animal: Animal): Unit = println("I am eating you, animal!")
        override def ?!(thought: String): Unit = println(s"I was thinking $thought")
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
    aCroc ?! "What if we could fly?" // also infix notation

    // operators in Scala are actually methods
    val basicMath = 1 + 2
    val anotherBasicMath = 1.+(2) // equivalent

    // anonymous classes
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
    }


        /* this is what is happening under the hood
        /class Carnivore_Anonymous_35728 extends Carnivore {
            override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
        }
        val dinosaur = new Carnivore_Anonymous_35728
        */ 

    // singleton object
    object MySingleton { // the only instance of the MySingleton type
        val mySpecialValue = 53278
        def mySpecialMethod(): Int = 5327
        def apply(x: Int): Int = x + 1
    }

    MySingleton.mySpecialMethod()
    MySingleton.apply(65)
    MySingleton(65) // equivalent to the above
    // the presence of apply method in a class allows the object to be invoked like a function

    object Animal { // companions - companion object
        // A companion object in Scala is an object that’s declared in the same file as a class, and has the same name as the class.
        // companions can access each other's private fields/methods
        // singleton Animal and instances of Animal are different things
        val canLiveIndefinitely = false
    }

    val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

    /* 
    case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
     */
    case class Person(name: String, age: Int)

    val bob = Person("Bob", 54) // I can omit the new keyword because Person class has a companion object within
    // It also has innate apply method

    // exceptions
    try {
        // code that can throw
        val x: String = null
        x. length
    } catch {
        case e: Exception => "some faulty error message"
    } finally {
        // execute some code no matter what
    }

    // generics
    abstract class MyList[T] {
        def head: T
        def tail: MyList[T]
    }

    // the type has become concrete as Int
    val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
    val first = aList.head
    val rest = aList.tail
    val aStringList = List("hello", "Scala")
    val firstString = aStringList.head // string

    // Point #1: in Scala we usually operate with IMMUTABLE values/objects
    // Any modification to an object must return ANOTHER object
    /* 
        Benefits:
            1) works miracles in multithreades/distrbuted env
            2) helps making sense of the code ("reasoning about")
     */
    val reversedList = aList.reverse // returns a NEW list

    // Point #2: Scala is closest to the object-oriented ideal
    // every single code is inside a class or object.

}