package mips.mem

trait RAM {
  val length: Int
  val internal = (for (i <- 0 to length) yield ZeroWord).toBuffer[Word]
  
  def apply(i: Int) = internal(i)
  def update(i: Int, w: Word) = internal(i) = w
  
  override final def toString() = s"RAM($length, " + internal + ")"
}

object ZeroRAM extends RAM {
  val length = 0
  override def apply(i: Int) = ZeroWord
  override def update(i: Int, w: Word) = Unit
}