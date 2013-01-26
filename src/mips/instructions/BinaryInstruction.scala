package mips.instructions

import mips.mem._
import mips.Environment

case class BinaryInstruction(
  dst: (Register, Memory) => (Address, Word, Word),
  op: (Word, Word) => Word)
  extends Instruction {
  def exec()(implicit env: Environment) = {
    val p = dst(env.register, env.memory)
    env.register(p._1) = op(p._2, p._3)
  }
}