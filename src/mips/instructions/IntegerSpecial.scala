package mips.instructions

import mips.mem._
import mips.mem.Registers._
import mips.Environment

case class IntegerSpecial(
  dst: (Register, Memory) => (Address, Address),
  hiOp: (Word, Word) => Word,
  loOp: (Word, Word) => Word)
  extends Instruction {
  def exec()(implicit env: Environment) = {
    val p = dst(env.register, env.memory)
    
    val hi = hiOp(p._1()(env.register), p._2()(env.register))
    val lo = loOp(p._1()(env.register), p._2()(env.register))
    
    env.register($hi) = hi
    env.register($lo) = lo
  }
}