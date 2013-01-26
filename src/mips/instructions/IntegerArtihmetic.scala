package mips.instructions

import mips.mem.Word
import mips.mem.Address
import mips.mem.Register
import mips.Environment
import mips.MIPS

trait IntegerArtihmetic extends MIPS {
  private[IntegerArtihmetic] def addImpl(w1: Word, w2: Word) = Word(w1.int + w2.int)
  def add(dst: (Address, Address, Address)) {
    addInstruction(BinaryInstruction((r, m) => (dst._1, dst._2()(r), dst._3()(r)), addImpl))
  }

  def addi(dst: (Address, Address, Word)) {
    addInstruction(BinaryInstruction((r, m) => (dst._1, dst._2()(r), dst._3), addImpl))
  }

  def sub(dst: (Address, Address, Address)) {
    addInstruction(BinaryInstruction((r, m) => (dst._1, dst._2()(r), dst._3()(r)), {
      (w1, w2) => Word(w1.int - w2.int)
    }))
  }
  
  def mult(st: (Address, Address)) {
    addInstruction(IntegerSpecial(
        (r, m) => st,
        (w1, w2) => Word((w1.int * w2.int) >> 32),
        (w1, w2) => Word(((w1.int * w2.int) << 32) >> 32)))
  }
  
  def div(st: (Address, Address)) {
    addInstruction(IntegerSpecial(
        (r, m) => st,
        (w1, w2) => Word(w1.int / w2.int),
        (w1, w2) => Word(w1.int % w2.int)))
  }
}