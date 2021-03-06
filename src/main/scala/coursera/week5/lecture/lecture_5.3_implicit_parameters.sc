def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  val n = xs.length / 2
  if(n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val(fst, snd) = xs splitAt n
    merge(msort(fst)(lt), msort(snd)(lt))
  }
}

val numbers = List(-1, 9, 2, 8, 4, 1)
msort(numbers)((x, y) => x < y)

val fruits = List("banana", "kiwi", "apple", "mango")
msort(fruits)((x, y) => x.compareTo(y) < 0)

// parametrization with Ordered: scala.math.Ordering[T]

def msortWithOrdering[T](xs: List[T])(ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if(n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val(fst, snd) = xs splitAt n
    merge(msortWithOrdering(fst)(ord), msortWithOrdering(snd)(ord))
  }
}

msortWithOrdering(numbers)(Ordering.Int)
msortWithOrdering(fruits)(Ordering.String)

// implicit parameter

def msortImplicit[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if(n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val(fst, snd) = xs splitAt n
    merge(msortImplicit(fst), msortImplicit(snd))
  }
}

msortImplicit(numbers)
msortImplicit(fruits)