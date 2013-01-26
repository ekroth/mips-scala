package mips

import mips.mem.Address
import mips.instructions.Instruction

case class Program private (instructions: List[Instruction]) {
  def ++(instr: Instruction) = Program(instr :: instructions)
}

object Program {
  def apply(): Program = Program(Nil)
}