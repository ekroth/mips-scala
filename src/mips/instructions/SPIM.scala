package mips.instructions

import mips.mem._
import mips.MIPS
import mips.Environment

trait SPIM extends MIPS {
  case class SPIMInstruction() extends Instruction {
    def exec()(implicit env: Environment) {
      env.register($trapCode).int match {
        case 1 =>
          println(env.register($intInput).int)
        case _ => Unit
      }
    }
  }
  
  def $trapCode = Registers.$v0
  def $intInput = Registers.$a0

  def syscall = {
    addInstruction(SPIMInstruction())
  }
}
            
