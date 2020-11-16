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

/*
cd C:\Documents\Kurse\AdvancedProgrammingParadigms\Teaching\app\10_Implicits\out\production\classes
scala
import scala.language.implicitConversions

import ch.mse.app.implicits.Fraction._
import ch.mse.app.implicits.Fraction
*/