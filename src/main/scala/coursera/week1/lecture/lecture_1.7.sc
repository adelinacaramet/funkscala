import scala.annotation.tailrec

val x = 0;
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
} + x


def factorial(number: Int): Int =
  if(number == 0) 1
  else number * factorial(number - 1)

factorial(2)
factorial(3)
factorial(4)

@tailrec
def recFactorial(number: Int, partialResult: Int = 1): Int = {
  if (number == 0) partialResult
  else {
    recFactorial(number - 1, partialResult * number)
  }
}

recFactorial(4)

def recFactorial2(number: Int): Int =  {
  def calculatePartialResult(number: Int, partialResult: Int): Int =
    if(number == 0) partialResult
    else {
      calculatePartialResult(number - 1, partialResult * number)
    }
  calculatePartialResult(number, 1)
}

recFactorial2(4)





