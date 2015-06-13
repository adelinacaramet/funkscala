// Solution 3: Object-oriented decomposition
// Problem: does not always work; need to touch all classes to add a new method

trait Expr {
  def eval: Int
}

class Num(n: Int) extends Expr {
  def eval: Int = n

  override def toString = n.toString
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def eval: Int = e1.eval + e2.eval

}