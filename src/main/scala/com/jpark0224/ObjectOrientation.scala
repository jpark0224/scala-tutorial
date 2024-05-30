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

}