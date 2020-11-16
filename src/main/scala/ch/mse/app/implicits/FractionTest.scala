package ch.mse.app.implicits

object FractionTest {
	import Fraction._
	
	def main(args: Array[String]):Unit = {
	  val f1 = Fraction(2,3)
	  val f2 = Fraction(-3,2)  
	  println(f1 * 3)
	  println(3 * f2)
	}
}
