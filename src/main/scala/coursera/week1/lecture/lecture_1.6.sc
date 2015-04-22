object lecture6 {

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      Math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(4)
  sqrt(9)
  sqrt(2)
  sqrt(1e-6)
  sqrt(1e60)

  List(1, 2, 3, 4).tail
  List(1, 2, 3, 4).head
  List(1, 2, 3, 4).indices.toList
  List(1, 2, 3, 4).splitAt(1)
}
