package mips.instructions

import mips.MIPS
import mips.mem._
import mips.mem.Registers._
import mips.Environment

trait Jumps extends MIPS {
  implicit def symbol2Word(s: Symbol) = labels(s.name).position
  case class JumpInstruction(i: Word, e: Environment => Boolean) extends Instruction {
    def exec()(implicit env: Environment) {
      if (e(env))
        env.register($pc) = i
    }
  }

  def j(w: Word) {
    addInstruction(
      JumpInstruction(w, e => true))
  }

  def beq(stC: (Address, Address, Word)) {
    addInstruction(
      JumpInstruction(
        stC._3, e => e.register(stC._1) == e.register(stC._2)))
  }
  
  def bne(stC: (Address, Address, Word)) {
    addInstruction(
      JumpInstruction(
        stC._3, e => e.register(stC._1) != e.register(stC._2)))
  }
}