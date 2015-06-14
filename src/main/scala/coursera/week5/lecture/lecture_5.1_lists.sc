val list = List(1, 2, 3, 4)
list.head
list.tail

list.last
list.init

list.length

list(2)
// equivalent to
list apply 2

list take 2
list drop 2

list.reverse

list indexOf 3
list contains 5
list contains 2

val anotherList = List(6, 7, 8)

list ++ anotherList

list updated(2, 4)

def last[T](xs: List[T]): T = xs match {
  case List() => throw new Error("last of empty list")
  case List(x) => x
  case y :: ys => last(ys)
}

last(List(1))
last(List(1,2,3,4))

def init[T](xs : List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys =>  y :: init(ys)
}

init(List(1))
init(List(1, 2, 3, 4))

def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case z :: zs => z :: concat(zs, ys)
}

concat(List(), List(1, 2, 3))
concat(List(4, 5, 6), List())
concat(List(1, 2, 3), List(4, 5, 6))

def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ++ List(y)
}

reverse(List())
reverse(List(1, 2, 3))

def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)

removeAt(1, List())
removeAt(0, List(1, 2, 3))
removeAt(1, List('a', 'b', 'c', 'd'))

