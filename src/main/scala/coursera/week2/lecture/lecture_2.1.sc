def sum(f: Int => Int, a: Int, b: Int): Int =
  if(a > b) 0
  else f(a) + sum(f, a + 1, b)

def sumInts(a: Int, b: Int) = sum(x => x, a, b)

def sumCubs(a: Int, b: Int) = sum(x => x * x * x, a, b)

def sumFactorial(a: Int, b: Int) = sum(factorial, a, b)
def factorial(x: Int):Int =
  if(x == 0) 1
  else factorial(x-1)


def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}

