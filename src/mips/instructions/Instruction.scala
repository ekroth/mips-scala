package mips.instructions

import mips.Environment
import mips.mem.Word

trait Instruction {
  def exec()(implicit env: Environment): Unit
}