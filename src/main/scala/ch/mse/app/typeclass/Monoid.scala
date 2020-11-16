package ch.mse.app.typeclass

trait Monoid[A] {
  def op(x: A, y: A): A
  def unit: A
}

object Monoid {

  implicit object stringMonoid extends Monoid[String] {
    def op(x: String, y: String) = x + y
    def unit = ""
  }

  implicit object multMonoid extends Monoid[Int] {
    def op(x: Int, y: Int) = x * y
    def unit = 1
  }

  implicit object addMonoid extends Monoid[Int] {
    def op(x: Int, y: Int) = x + y
    def unit = 0
  }

  implicit def listMonoid[A](implicit m: Monoid[A]) =
    new Monoid[List[A]] {
      def op(xs: List[A], ys: List[A]): List[A] =
        if (xs.isEmpty) ys
        else if (ys.isEmpty) xs
        else m.op(xs.head, ys.head) :: op(xs.tail, ys.tail)
      def unit = List()
    }

  def acc[A](list: List[A])(implicit m: Monoid[A]): A =
    list.foldLeft(m.unit)(m.op)

  def acc2[A: Monoid](list: List[A]): A = {
    val m = implicitly[Monoid[A]]
    list.foldLeft(m.unit)(m.op)
  }

}