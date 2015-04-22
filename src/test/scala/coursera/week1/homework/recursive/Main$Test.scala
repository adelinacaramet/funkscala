package coursera.week1.homework.recursive

import org.scalatest.FunSuite

class Main$Test extends FunSuite {

  test("if column and row are 0, the number in the triangle should be 1") {
    val value = Main.pascal(0,0)
    assert(value == 1)
  }

  test("if column is 0, the number in the triangle should be 1") {
    val value = Main.pascal(0,5)
    assert(value == 1)
  }

  test("if column and row are equal, the number in the triangle should be 1") {
    val value = Main.pascal(4,4)
    assert(value == 1)
  }

  test("if column is 1 and row is 5, the number in the triangle should be 6") {
    val value = Main.pascal(1,5)
    assert(value == 5)
  }

  test("if column is 2 and row is 4, the number in the triangle should be 6") {
    val value = Main.pascal(2,4)
    assert(value == 6)
  }

  test("parentheses are balanced for an empty string") {
    val string = ""
    assert(areParenthesesBalanced(string) == true)
  }

  def areParenthesesBalanced(string: String): Boolean = {
    Main.balance(string.toList)
  }

  test("parentheses are not balanced for a smiley face") {
    val string = ":-)"

    assert(areParenthesesBalanced(string) == false)
  }

  test("parentheses are not balanced for a string that contains the same number of opening and closing parentheses") {
    val string = "())("

    assert(areParenthesesBalanced(string) == false)
  }

  test("parentheses are balanced") {
    val string = "(if (zero? x) max (/ 1 x))\nI told him (that it’s not (yet) done). (But he wasn’t listening)"

    assert(areParenthesesBalanced(string) == true)
  }

  test("countChange: example given in instructions") {
    assert(Main.countChange(4,List(1,2)) == 3)
  }

  test("countChange: sorted CHF") {
    assert(Main.countChange(300,List(5,10,20,50,100,200,500)) == 1022)
  }

  test("countChange: no pennies") {
    assert(Main.countChange(301,List(5,10,20,50,100,200,500)) == 0)
  }

  test("countChange: unsorted CHF") {
    assert(Main.countChange(300,List(500,5,50,100,20,200,10)) == 1022)
  }
}
