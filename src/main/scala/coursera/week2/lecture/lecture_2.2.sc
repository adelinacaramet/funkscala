def sum(f: Int => Int)(a: Int, b: Int): Int =
  if(a > b) 0
  else f(a) + sum(f)(a + 1, b)

def product(f: Int => Int)(a: Int, b: Int): Int =
  if(a > b) 1
  else f(a) * product(f)(a + 1, b)

def mapReduce(f:Int => Int, combine:(Int, Int) => Int, defaultValue: Int) (a: Int, b: Int): Int =
  if(a > b) defaultValue
  else combine(f(a), mapReduce(f, combine, defaultValue)(a + 1, b))


def productV2(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x, y) => x * y, 1) (a, b)
def sumV2(f: Int =>Int)(a: Int, b: Int) = mapReduce(f, (x, y) => x + y, 0) (a, b)

def factorial(n : Int) = productV2(x => x)(1, n)
factorial(5)

sumV2(x=>x)(1, 5)
