package mips

import scala.runtime.RichInt
package object mem {
  implicit class AddressOffset(c: Int) {
    // C($s) = MEM[$s + C]
    def apply(a: Address) = a + c
  }
  
  implicit def address2Int(a: Address) = a.i
  implicit def address2Word(a: Address)(implicit ram: RAM) = a()
  
  implicit def int2Word(i: Int) = Word(i)
  implicit def word2Int(w: Word) = w.int
  implicit def word2Float(w: Word) = w.float
}