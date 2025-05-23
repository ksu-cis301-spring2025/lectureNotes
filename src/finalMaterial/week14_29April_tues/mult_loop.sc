// #Sireum #Logika

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//finding x*y by doing x + x + x + ... + x (y times)
def mult(x: Z, y: Z): Z = {
  //What can we use as the function contract?
  Contract(
    Requires( y >= 0),
    Ensures( Res[Z] == x*y )
  )

  var total: Z = 0
  var i: Z = 0

  //prove invariant holds

  while (i < y) {
    Invariant(
      Modifies(i, total),
      total == i*x,
      i <= y
    )


    total = total + x
    i = i + 1
  }

  return total
}

//////////// test code /////////

val a: Z = 5
val b: Z = 4


var ans: Z = mult(a, b)

assert(ans == 20)