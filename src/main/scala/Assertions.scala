def calculation(a: Float): Float = {
  Math.sqrt(a).toFloat + 127
}

def equalsApprox(a: Float, b: Float, epsilon: Float = 0.000001): Boolean = {
  Math.abs(a - b) > epsilon
}


def assertThrows[E <: Throwable](f: () => Any): Unit = {
  val wasThrown = try {
    f()
    false
  } catch {
    case e: E => true
    case _ => false
  }
  assert(wasThrown, "function did not throw expected exception")
}

@main
def test() = {
  assert(calculation(25) == 5 + 127)

  //sqrt(2) has to be rounded by the computer, so equality checks with == would fail
  //instead we test if its almost equal => if the difference is very very small
  assert(equalsApprox(calculation(2), 1.4142f + 127))


  //this function will crash with IllegalArugmentException if the string a is null
  def crashingFunction(a: String): Array[String] = {
    a match {
      case null => {
        //replace the throws statement with this, and see what happens: Array("Hello","World")
        throw IllegalArgumentException()
      }
      case s: String => s.split(",")
    }
  }

  assert(crashingFunction("Hello,World") sameElements Array("Hello", "World"))

  //we pass in an illegal argument and expect that the function will throw the correct exception for that
  assertThrows[IllegalArgumentException](() => crashingFunction(null))

  println("all tests successful")
}