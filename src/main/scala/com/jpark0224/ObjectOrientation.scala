package com.jpark0224

object ObjectOrientation extends App {
  
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
    val aDog = new Dog("Lassie")

    // constructor arguments are NOT fields: need to put a val before the constructor argument
    aDog.name

    // subtype polymorphism
    val aDeclaredAnimal: Animal = new Dog("Hachi") 
    aDeclaredAnimal.eat() // the most derived method will be called at runtime

    // abstract class
    abstract class WalkingAnimal {
        val hasLegs = true // by default public
        protected val hasWings = false // only this class and its descendents have access to this
        private val hasEyes = true // only this class has access to this
        def walk(): Unit
    }

    // interface = ultimate abstract type
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    trait Philosopher {
        def ?!(thought: String): Unit // valid method name
    }

    // single-class inheritance, multi-trait "mixing"
    class Crocodile extends Animal with Carnivore {
        override def eat(animal: Animal): Unit = println("I am eating you, animal!")

        override def ?!(thought: String): Unit = println(s"I was thinking $thought")
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
}
