package ch.mse.app.typeclass

abstract class Acceptable[T]

object Acceptable {
  implicit object IntOk extends Acceptable[Int]
  implicit object LongOk extends Acceptable[Long]
}
