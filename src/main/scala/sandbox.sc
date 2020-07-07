/*
純粋関数の例
 */

val intToChar: Int => Char =
  (i: Int) => i.toChar

val charToString: Char => String =
  (c: Char) => c.toString

val intToString = intToChar andThen charToString

intToString(97)

// implicit parameter
def hello(msg: String)(implicit suffix: String): String =
  msg + suffix

implicit val s: String = "!!!"
hello("John")

// 型クラス

sealed abstract class Num(val i: Int)
case object Zero extends Num(0)
case object One extends Num(1)
case object Two extends Num(2)

implicit val numOrdering: Ordering[Num] = new Ordering[Num] {
  def compare(x: Num, y: Num): Int =
    if (x.i == y.i) 0
    else if (x.i < y.i) -1
    else 1
}
List[Num](One, Two, Zero).max
List[Num](One, Two, Zero).sorted



// 文字列に変換する型クラス
trait Show[A] {
  def show(a: A): String
}

object Show {

  implicit val stringShow: Show[String] = new Show[String] {
    def show(a: String): String = a
  }

  implicit val intShow: Show[Int] = new Show[Int] {
    def show(a: Int): String = a.toString
  }
}
def show[A](a: A)(implicit sa: Show[A]): String =
  sa.show(a)

show(100)
show("foo")

case class Cat(name: String)
implicit val catShow: Show[Cat] = new Show[Cat] {
  def show(a: Cat): String = s"${a.name} say, meow!"
}
show(Cat("moko"))

// なんか結合できる型クラス
trait Additive[A] {
  def combine(x: A, y: A): A
}
object Additive {
  implicit val stringAdditive: Additive[String] = new Additive[String] {
    def combine(x: String, y: String): String =
      x + y
  }
}
def combine[A](a: A, b: A)(implicit aa: Additive[A]): A =
  aa.combine(a, b)

combine("foo", "bar")

case class Natural(i: Int)
implicit val naturalAdditive: Additive[Natural] = new Additive[Natural] {
  def combine(x: Natural, y: Natural): Natural =
    Natural(x.i + y.i)
}

combine(Natural(1), Natural(2))

// Enrich my library
// implicit conversionを組み合わせることで、あたかも既存のデータ型に対してメソッドが定義されているか
// 見せかけることができる

implicit class ShowOp[A](a: A) {
  def show(implicit sa: Show[A]): String =
    sa.show(a)
}
100.show
Cat("moko").show

implicit class AdditiveOp[A](a: A) {
  def combine(b: A)(implicit aa: Additive[A]): A =
    aa.combine(a,b)
}
Natural(1) combine Natural(2)