import sun.invoke.empty.Empty

// C is covariant class C[+A] }
// C is contravariant class C[-A] }
// C is nonvariant C[A]

// convariant type parameters can only appear in method results;
// contravariant type paramenters can only appear in method parameters
// invariant type parameters - everywhere

// objects can't have type parameters because there is only
// one instance of them

// convariant type parameters can appear in lower bounds of method type parameters
// contravariant type parameters can appear in upper bounds of methods


trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T] (elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false

  override def toString = "[" + head + "|" + tail + "]"
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new scala.NoSuchElementException("Nil.tail")

  override def toString = "."
}

object test {
  val x: List[String] = Nil
}

