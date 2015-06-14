def sum(xs: List[Int]): Int = xs match {
  case Nil => 0
  case x :: xs1 => x + sum(xs1)
}

sum(List())
sum(List(1, 2, 3, 4))

// reduceLeft
def sumReduceLeft(xs: List[Int]): Int =
  (0 :: xs) reduceLeft ((x: Int,y: Int) => x + y)

sumReduceLeft(List())
sumReduceLeft(List(1, 2, 3, 4))

// shorter version
def sumShortVersion(xs: List[Int]): Int =
  (0 :: xs) reduceLeft (_+_)

sumShortVersion(List())
sumShortVersion(List(1, 2, 3, 4))

//fold left

def sumFoldLeft(xs: List[Int]): Int =
  (xs foldLeft 0)(_+_)

sumFoldLeft(List())
sumFoldLeft(List(1, 2, 3, 4))

// fold right; reduce right

def concat(xs: List[Int], ys: List[Int]): List[Int] =
  (xs foldRight ys)(_::_)

concat(List(1,2,3), List(5, 6, 7))