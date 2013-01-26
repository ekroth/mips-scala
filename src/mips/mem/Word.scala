package mips.mem

case class Word(private val value: Int) {
  def int = value
  def float = java.lang.Float.intBitsToFloat(value)
  override def toString() = s"Word($int|$float)"
  
  def +(o: Word): Word = Word(o.int + int)
}

object Word {
  def apply(i: Float): Word = 
    apply(java.lang.Float.floatToIntBits(i))
}

object ZeroWord extends Word(0)