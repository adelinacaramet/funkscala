package coursera.week1.homework.recursive

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(column: Int, row: Int): Int = {
    if(column == 0 || column == row) 1
    else pascal(column - 1, row - 1) + pascal(column, row - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceParentheses(chars: List[Char], openParentheses: Int): Boolean = {
      if (openParentheses < 0) return false
      chars match {
        case Nil => openParentheses == 0
        case '(' :: tail => balanceParentheses(tail, openParentheses + 1)
        case ')' :: tail => balanceParentheses(tail, openParentheses - 1)
        case x :: tail => balanceParentheses(tail, openParentheses)
      }
    }
    balanceParentheses(chars, 0)
  }


  /**
   * Exercise 3
   * http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_idx_722
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) return 1
    if(money < 0) return 0
    if(coins.isEmpty) return 0
    countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}