package ch.mse.app.typeclass

trait Showable[T] { def show(x: T): String }

object Showable {
  implicit object a extends Showable[A] {
    def show(x: A) = "TC:A"
  }
  implicit object b1 extends Showable[B1] {
    def show(x: B1) = "TC:B1"
  }
  implicit object b2 extends Showable[B2] {
    def show(x: B2) = "TC:B2"
  }
}

class A
class B1 extends A
class B2 extends A

object ShowableTest {

import Showable._

  def show[T: Showable](x: T) = {
    implicitly[Showable[T]].show(x)
  }

  def main(args: Array[String]): Unit = {
    val list = List(new A, new B1, new B2)
    val list2 = list.map(x => show(x))
    println(list2)
  }
}
