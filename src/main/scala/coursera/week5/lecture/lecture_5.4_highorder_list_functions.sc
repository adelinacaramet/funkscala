//Map

def scaleList(xs : List[Double], factor: Double): List[Double] = xs match {
  case Nil => xs
  case x :: xs1 => x * factor :: scaleList(xs1, factor)
}

scaleList(List(1.1, 2.2, 3.3), 2)

abstract class List[T] {
  def map[U](f: T => U): List[U] = this match {
    case Nil => this
    case x :: xs => f(x) :: xs.map(f)
  }
}

def scaleListWithMap(xs: List[Double], factor: Double): List[Double] =
  xs map ((x:Double) => x * factor)

def squareList(xs: List[Int]): List[Int] = xs match {
  case Nil     => xs
  case y :: ys => y * y :: squareList(ys)
}

squareList(Nil)
squareList(List(1, 2, 3, 4))

def squareListWithMap(xs: List[Int]): List[Int] =
  xs map ((x: Int) => x * x)

squareListWithMap(List(5, 6, 7))

// Filtering

def posElemens(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case x :: xs1 =>
    if(x > 0) x :: posElemens(xs1)
    else posElemens(xs1)
}

posElemens(List(-1, 4, 5, 3, -9))

def posElementsWithFilter(xs: List[Int]): List[Int] =
  xs filter ((x: Int) => x > 0)

posElementsWithFilter(List(-1, 4, 5, 3, -9))

val nums = List(2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")

val isPositive: (Int) => Boolean = (x: Int) => x > 0
nums filter isPositive
nums filterNot isPositive
nums partition isPositive

nums takeWhile isPositive
nums dropWhile isPositive
nums span isPositive

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val(first, rest) = xs span ((y: T) => y == x)
    first :: pack(rest)
}

val chars = List("a", "a", "a", "b", "c", "c", "a")
pack(chars)

def encode[T](xs: List[T]): List[(T,Int)] =
  pack(xs) map ((ys:List[T]) => (ys.head, ys.length))

encode(List("a", "a", "a", "b", "c", "c", "a"))