# Unit testing with plain Assertions

You have been tasked with refactoring a scala project. Before you start, you want to write tests.
That makes it easier for you to refactor, because you can test your new implementation and the test guarantee (to some extent) that you did not change the semantics (= what the implementation is doing).

See [Assertions.scala](./src/main/scala/Assertions.scala) for an implementation of all 3 important assertions:
- plain assertion 
- comparing floating point numbers in assertions
- assert that an Exception was thrown