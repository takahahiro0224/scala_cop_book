// 5.4~

val sumMore = 1.+(2)
(2.0).unary_-

// ビット演算

1 & 2  // 0001 & 0010
1 | 2  // 0001 | 0010
1 ^ 3  // XOR 0001 0011
~1     // 各ビット反転

10 >> 1 // 右シフト 1100 to 0100
5 << 1 // 左シフト

// リッチラッパー
import scala.language.postfixOps

0 max 5

0 min 5

-2.7 abs

(-2.7) round

1.5 isInfinity

(1.0 / 0) isInfinity

4 to 6

"bob" capitalize

"robert" drop 2