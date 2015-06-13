// Decomposition

// Solution1:  Classification and access methods
// Problem: quadratic increase of methods
trait Expr {
  // classification
  def isNumber: Boolean
  def isSum: Boolean
  // accessor
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")

  override def toString = numValue.toString
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

def eval(e: Expr): Int =  {
  if(e.isNumber) e.numValue
  else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
  else throw new Error("Unknown expression"  + e)
}

val sum = eval(new Sum(new Number(1), new Number(2)))

// Solution 2: Type tests and type casts
// Problem: discouraged because of low level and potentially unsafe

def eval2(e: Expr): Int = {
  if(e.isInstanceOf[Number])
    e.asInstanceOf[Number].numValue
  else if(e.isInstanceOf[Sum])
    eval2(e.asInstanceOf[Sum].leftOp) +
      eval2(e.asInstanceOf[Sum].rightOp)
  else throw new Error("Unknown expression" + e)
}

val sum2 = eval2(new Sum(new Number(3), new Number(5)))

