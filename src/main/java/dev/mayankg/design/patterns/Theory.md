# DESIGN PATTERNS #25

- Erich Gamma, John Vlissides, Ralph Johnson, and Richard Helm. In 1994, they published Design Patterns: Elements of
  Reusable Object-Oriented Software.

- [Design Patterns: Elements of Reusable Object-Oriented Software By GangOfFour](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=0201633612&linkCode=as2&tag=triatcraft-20&linkId=XRGUDJCGWC6AJNZM)
- [LucidChart/uml](https://lucid.app/lucidchart/47952aff-1811-40d0-9675-56fcb993ae7d/edit?from_internal=true)
- [Understanding the various symbols of UML diagrams](https://heartin.tech/en/blog-entry/important-uml-diagrams-required-work-object-oriented-design-patterns)

----

## CREATIONAL DESIGN PATTERNS

#### The design patterns that deal with the creation of an object.

- These design patterns are all about class instantiation.
- This pattern can be further divided into class-creation patterns and object-creational patterns.
    - While class-creation patterns use inheritance effectively in the instantiation process,
    - object-creation patterns use delegation effectively to get the job done.

### 01. SINGLETON

- A class of which only a single instance can exist

### 02. FACTORY

- Creates an instance of several derived classes.

### 03. ABSTRACT FACTORY

- Creates an instance of several families of classes

### 04. BUILDER

- Separates object construction from its representation
- Creating an object step by step and a method to finally get the object instance.

### 05. PROTOTYPE

- A fully initialized instance to be copied or cloned

### 06. OBJECT POOL

- Avoid expensive acquisition and release of resources by recycling objects that are no longer in use

#### Rules of thumb

1. Sometimes creational patterns are competitors: there are cases when either **Prototype** or **Abstract Factory**
   could be used profitably. At other times they are complementary: **Abstract Factory** might store a set of **Prototypes** from which to clone and return product objects, **Builder** can use one of the other patterns to
   implement which components get built. **Abstract Factory**, **Builder**, and **Prototype** can use Singleton in their
   implementation.
2. **Abstract Factory**, **Builder**, and **Prototype** define a factory object that's responsible for knowing and
   creating the class of product objects, and make it a parameter of the system. **Abstract Factory** has the factory
   object producing objects of several classes. **Builder** has the factory object building a complex product
   incrementally using a correspondingly complex protocol. **Prototype** has the factory object (aka prototype) building
   a product by copying a prototype object.
3. **Abstract Factory** classes are often implemented with **Factory Methods**, but they can also be implemented using **Prototype**.
4. **Abstract Factory** can be used as an alternative to **Facade** to hide platform-specific classes.
5. **Builder** focuses on constructing a complex object step by step. **Abstract Factory** emphasizes a family of
   product objects (either simple or complex). **Builder** returns the product as a final step, but as far as the **Abstract Factory** is concerned, the product gets returned immediately.
6. **Builder** is to creation as **Strategy** is to algorithm.
7. **Builder** often builds a **Composite**.
8. **Factory Methods** are usually called within **Template methods**.
9. **Factory Method**: creation through inheritance. **Prototype**: creation through delegation. Often, designs start
   out using **Factory Method** (less complicated, more customizable, subclasses proliferate) and evolve toward Abstract
10. Factory, **Prototype**, or **Builder** (more flexible, more complex) as the designer discovers where more
    flexibility is
    needed.
11. **Prototype** doesn't require subclassing, but it does require an Initialize operation. **Factory Method** requires
    subclassing, but doesn't require Initialize.
12. Designs that make heavy use of the **Composite** and **Decorator** patterns often can benefit from **Prototype** as well.

-----

## STRUCTURAL DESIGN PATTERNS

#### The design patterns in this category deal with the class structure such as Inheritance and Composition. Composition is better than Inheritance

- These design patterns are all about Class and Object composition.
- Structural class-creation patterns use inheritance to compose interfaces.
- Structural object-patterns define ways to compose objects to obtain new functionality.

### 01. ADAPTOR

- Match interfaces of different classes.
- Provides an interface between two unrelated entities so that they can work together

### 02. COMPOSITE

- A tree structure of simple and composite objects

### 03. FLY WEIGHT

- A fine-grained instance used for efficient sharing

### 04. PROXY

- An object representing another object in order to provide access in either way
    - remote proxy: provides a local representation of an original remote object
    - virtual proxy: delays construction of the original object until necessary
    - protected proxy: controls access to the original object's operations

### 05. FACADE

- A single class that represents an entire subsystem

### 06. BRIDGE

- Separates an object’s interface from its implementation.

### 07. DECORATOR

- Add responsibilities to objects dynamically

#### Rules of thumb

1. **Adapter** makes things work after they're designed; **Bridge** makes them work before they are.
2. **Bridge** is designed up-front to let the abstraction and the implementation vary independently. **Adapter** is
   retrofitted
   to make unrelated classes work together.
3. **Adapter** provides a different interface to its subject. **Proxy** provides the same interface. **Decorator**
   provides an
   enhanced interface.
4. **Adapter** changes an object's interface, **Decorator** enhances an object's responsibilities. **Decorator** is thus
   more
   transparent to the client. As a consequence, **Decorator** supports recursive composition, which isn't possible with
   pure
   Adapters.
5. **Composite** and **Decorator** have similar structure diagrams, reflecting the fact that both rely on recursive
   composition
   to organize an open-ended number of objects.
6. **Composite** can be traversed with **Iterator**. **Visitor** can apply an operation over a **Composite**. **Composite**
   could use **Chain of responsibility** to let components access global properties through their parent. It could also
   use
   **Decorator** to
   override these properties on parts of the composition. It could use **Observer** to tie one object structure to
   another
   and State to let a component change its behavior as its state changes.
7. **Composite** can let you compose a **Mediator** out of smaller pieces through recursive composition.
8. **Decorator** lets you change the skin of an object. **Strategy** lets you change the guts.
9. **Decorator** is designed to let you add responsibilities to objects without subclassing. **Composite**'s focus is
   not on
   embellishment but on representation. These intents are distinct but complementary. Consequently, **Composite** and
   **Decorator** are often used in concert.
10. **Decorator** and **Proxy** have different purposes but similar structures. Both describe how to provide a level of
    indirection to another object, and the implementations keep a reference to the object to which they forward
    requests.
11. **Facade** defines a new interface, whereas **Adapter** reuses an old interface. Remember that **Adapter** makes two
    existing
    interfaces work together as opposed to defining an entirely new one.
12. **Facade** objects are often Singleton because only one **Facade** object is required.
13. **Mediator** is similar to **Facade** in that it abstracts functionality of existing classes. **Mediator**
    abstracts/centralizes
    arbitrary communication between colleague objects, it routinely "adds value", and it is known/referenced by the
    colleague objects. In contrast, **Facade** defines a simpler interface to a subsystem, it doesn't add new
    functionality,
    and it is not known by the subsystem classes.
14. **Abstract Factory** can be used as an alternative to **Facade** to hide platform-specific classes.
15. Whereas **Flyweight** shows how to make lots of little objects, **Facade** shows how to make a single object
    represent
    an
    entire subsystem.
16. **Flyweight** is often combined with **Composite** to implement shared leaf nodes.
17. **Flyweight** explains when and how State objects can be shared.

-----

## BEHAVIOURAL DESIGN PATTERNS

#### This type of design patterns provides a solution for the better interaction between objects, how to provide lose coupling, and flexibility to extend easily in the future.

- Behavioral design patterns are design patterns that identify common communication patterns between objects and realize
  these patterns. By doing so, these patterns increase flexibility in carrying out this communication.

### 01. TEMPLATE METHOD

- Defer the exact steps of an algorithm to a subclass

### 02. MEDIATOR

- Defines simplified communication between classes

### 03. CHAIN OF RESPONSIBILITY

- A way of passing a request between a chain of objects

### 04. OBSERVER

- A way of notifying change to a number of classes

### 05. STRATEGY

- Encapsulates an algorithm inside a class

### 06. COMMAND

- Encapsulate a command request as an object

### 07. STATE

- Alter an object's behavior when its state changes

### 08. VISITOR

- Defines a new operation to a class without change

### 09. ITERATOR

- Sequentially access the elements of a collection

### 10. INTERPRETER

- A way to include language elements in a program

### 11. MEMENTO

- Capture and restore an object's internal state

### 12. NULL OBJECT

- Designed to act as a default value of an object

#### Rules of thumb

1. Behavioral patterns are concerned with the assignment of responsibilities between objects, or, encapsulating behavior
   in an object and delegating requests to it.
2. **Chain of responsibility**, **Command**, **Mediator**, and **Observer**, address how you can decouple senders and
   receivers, but
   with different trade-offs. **Chain of responsibility** passes a sender request along a chain of potential receivers.
   **Command** normally specifies a sender-receiver connection with a subclass. **Mediator** has senders and receivers
   reference
   each other indirectly. **Observer** defines a very decoupled interface that allows for multiple receivers to be
   configured at run-time.
3. **Chain of responsibility** can use **Command** to represent requests as objects.
4. **Chain of responsibility** is often applied in conjunction with **Composite**. There, a component's parent can act
   as its
   successor.
5. **Command** and **Memento** act as magic tokens to be passed around and invoked at a later time. In **Command**, the
   token
   represents a request; in **Memento**, it represents the internal state of an object at a particular time.
   Polymorphism is
   important to **Command**, but not to **Memento** because its interface is so narrow that a memento can only be passed
   as a
   value.
6. **Command** can use **Memento** to maintain the state required for an undo operation.
7. MacroCommands can be implemented with **Composite**.
8. A **Command** that must be copied before being placed on a history list acts as a **Prototype**.
9. Interpreter can use State to define parsing contexts.
10. The abstract syntax tree of Interpreter is a **Composite** (therefore **Iterator** and **Visitor** are also
    applicable).
11. Terminal symbols within Interpreter's abstract syntax tree can be shared with **Flyweight**.
12. **Iterator** can traverse a **Composite**. **Visitor** can apply an operation over a **Composite**.
13. Polymorphic Iterators rely on **Factory Methods** to instantiate the appropriate **Iterator** subclass.
14. **Mediator** and **Observer** are competing patterns. The difference between them is that **Observer** distributes
    communication
    by introducing "observer" and "subject" objects, whereas a **Mediator** object encapsulates the communication
    between
    other objects. We've found it easier to make reusable Observers and Subjects than to make reusable Mediators.
15. On the other hand, **Mediator** can leverage Observer for dynamically registering colleagues and communicating with
    them.
16. **Mediator** is similar to **Facade** in that it abstracts functionality of existing classes. **Mediator**
    abstracts/centralizes
    arbitrary communication between colleague objects, it routinely "adds value", and it is known/referenced by the
    colleague objects (i.e. it defines a multidirectional protocol). In contrast, **Facade** defines a simpler interface to
    a subsystem, it doesn't add new functionality, and it is not known by the subsystem classes (i.e. it defines a
    unidirectional protocol where it makes requests of the subsystem classes but not vice versa).
17. **Memento** is often used in conjunction with **Iterator**. An **Iterator** can use a **Memento** to capture the
    state of an
    iteration. The **Iterator** stores the **Memento** internally.
18. State is like **Strategy** except in its intent.
19. **Flyweight** explains when and how State objects can be shared.
20. State objects are often Singletons.
21. **Strategy** lets you change the guts of an object. **Decorator** lets you change the skin.
22. **Strategy** is to algorithm. as Builder is to creation.
23. **Strategy** has 2 different implementations, the first is similar to State. The difference is in binding times (
    **Strategy** is a bind-once pattern, whereas State is more dynamic).
24. **Strategy** objects often make good **Flyweights**.
25. **Strategy** is like **Template method** except in its granularity.
26. **Template method** uses inheritance to vary part of an algorithm. **Strategy** uses delegation to vary the entire
    algorithm.
27. The **Visitor** pattern is like a more powerful **Command** pattern because the visitor may initiate whatever is
    appropriate
    for the kind of object it encounters.