// List[Either[Error, Int]]
val eitherList: List[Either[Error, Int]] = List(Right(1), Right(2), Right(3))

eitherList.foldLeft(Right(0): Either[Error, Int]) {
  case (Right(v1), Right(v2)) => Right(v1 + v2)
  case (Right(_), l @ Left(_)) => l
  case (l @ Left(_), _) => l
}

import cats._
import cats.implicits._

// semigroup
1 |+| 2

Option(1) |+| Option(2)
(Right(1): Either[Error, Int]) |+| (Right(2): Either[Error, Int])

1.some |+| 2.some
1.some |+| none
1.asRight[Error] |+| 2.asRight[Error]

case class MyError() extends Error

// Foldable
Foldable[List].fold(List(1,2,3))
Foldable[List].fold(List(1.asRight[Error], 2.asRight[Error]))
Foldable[List].fold(List(1.asRight[Error], MyError().asLeft[Int]))