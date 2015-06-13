// Anonymous function such as

// (x: Int) = > x * x

// is equivalent to

val f = new Function1[Int, Int] {
  def apply(x: Int) = x * x
}

f.apply(7)

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false

  override def toString = "[" + head + "|" + tail + "]"
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new scala.NoSuchElementException("Nil.tail")

  override def toString = "."
}

// List(1, 2) = List.apply(1, 2)
object List {

  def apply() = new Nil

  def apply[T](element: T): List[T] =
    new Cons(element, new Nil)

  def apply[T](element1: T, element2: T): List[T] =
    new Cons(element1, new Cons(element2, new Nil))
}

List()
List(1)
List(1, 2)
