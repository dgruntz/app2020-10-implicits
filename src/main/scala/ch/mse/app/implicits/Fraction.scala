package ch.mse.app.implicits

class Fraction(n: BigInt, d: BigInt) {
  assert(d != 0)
  private val g = n.gcd(d)
  val numer = n / (g * d.signum)
  val denom = d / (g * d.signum)
  def *(other: Fraction) = new Fraction(numer * other.numer, denom * other.denom)
  override def toString = numer + " / " + denom;
}

object Fraction {
  def apply(n: BigInt, d: BigInt) = new Fraction(n, d)
  implicit def int2Fraction(n: Int) = new Fraction(n, 1)
}


