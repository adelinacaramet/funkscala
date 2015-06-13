
// a fundamental data structure in many funtional languages is the immutable linked list
// Cons-lists
// Nil - empty list
// Cons = a cell containing an element and the remainder of the list

//class Cons(_head: Int, _tail: IntList) extends IntList {
//  val head = _head
//  val tail = _tail
//}
//
//==
//
//class Cons(val head: Int, val tail: IntList) extend IntList {
//
//}

//TypeParameter = [T]

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false

  override def toString = "[" + head + "|" + tail + "]"
}

// def is evaluated each time it is referenced
// val is evaluated when an object is first initialised

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new scala.NoSuchElementException("Nil.tail")

  override def toString = "."
}

// generic functions

def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

singleton(1)

// type parameters do not affect evaluation in Scala
// languages that use type erasure include: Java, Scala, Haskell

def nth[T](n: Int, list: List[T]):T =
  if(list.isEmpty) throw new IndexOutOfBoundsException
  else if(n == 0) list.head
  else nth(n - 1, list.tail)

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
val element = nth(0, list)
val element2 = nth(2, list)
val element3 = nth(4, list)
