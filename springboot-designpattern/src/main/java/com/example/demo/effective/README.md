
Item 1: Consider static factory methods instead of constructors
    One advantage of static factory methods is that, unlike constructors, they have names.
    A second advantage of static factory methods is that, unlike constructors, they are not required to create a new object each time they’re invoked.
    A third advantage of static factory methods is that, unlike constructors, they can return an object of any subtype of their return type. 
    A fourth advantage of static factories is that the class of the returned object can vary from call to call as a function of the input parameters.
    A fifth advantage of static factories is that the class of the returned object need not exist when the class containing the method is written. 
    The main limitation of providing only static factory methods is that classes without public or protected constructors cannot be subclassed.
    A second shortcoming of static factory methods is that they are hard for programmers to find.

Item 2: Consider a builder when faced with many constructor parameters
     the Builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters

Item 3: Enforce the singleton property with a private constructor or an enum type
    a single-element enum type is often the best way to implement a singleton.

Item 4: Enforce noninstantiability with a private constructor

Item 5: Prefer dependency injection to hardwiring resources

Item 6: Avoid creating unnecessary objects
    prefer primitives to boxed primitives, and watch out for unintentional autoboxing.
    
Item 7: Eliminate obsolete object references 
    


    
