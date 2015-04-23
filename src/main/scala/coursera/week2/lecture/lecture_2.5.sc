class Rationale(a: Int, b: Int) {
  require(b != 0, "denominator should not be zero")

  def this(a: Int) = this(a, 1)

  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a
    else gcd(b, a%b)

  val num = a / gcd(a, b)
  val denom = b / gcd(a, b)

  def unary_- = new Rationale(-num, denom)

  def  + (newRat: Rationale) =
    new Rationale(num * newRat.denom + denom * newRat.num, denom * newRat.denom)

  def - (newRat: Rationale) = this + -newRat

  def < (newRat: Rationale) = num * newRat.denom < denom * newRat.num

  def max(newRat: Rationale) =
    if(this < newRat) newRat
    else this

  override def toString = num + "/" + denom
}

val x = new Rationale(1, 2)
-x

val addRationale = x + new Rationale(2, 3)
val substractRationale = x - new Rationale(1, 3)

val a = new Rationale(1, 3)
val b = new Rationale(5, 7)
val c = new Rationale(3, 2)

a - b - c
b + b
a < b
a max b



