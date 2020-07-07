
// Intの最大値
val i:Int = Math.pow(2, 31).toInt
// Longの最大値
val l: Long = Math.pow(2, 63).toLong

// 先頭0xは16進数
val hex = 0x5
val hex2 = 0x00FF

// 後ろにL or lをつけるとLong
val of = 31L

// unicode
val f = '\u0044'
// escape
val backslash = '\\'

val escapes = "\\\"\'"

println(
  """|Hello
     |GoodBye
     |""".stripMargin)

// シンボル
def updateRecordByName(r: Symbol, value: Any) = {
  println(s"r:${r}, value:${value}")
}
updateRecordByName(Symbol("favoriteAlbum"), 10)


// 文字列補間
s"The answer is ${6 * 7}"
raw"No\nescape!"

f"${math.Pi}%.5f"
f"${math.Pi}%.2f"

