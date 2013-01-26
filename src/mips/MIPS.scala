package mips

import mips.mem._
import mips.mem.Registers._
import mips.instructions._

import scala.collection._

trait MIPS extends Environment {
  val memory = Memory(128)
  val register = Register(64)
  var program = Program()
  protected val labelMap = mutable.HashMap[String, Label]()
  def labels = labelMap.toMap
  implicit def env: Environment = this

  def addInstruction(instr: Instruction) = program = program ++ instr
  def addLabel(label: Label) = labelMap += ((label.name, label))

  protected def exec() = {
    while (register($pc).int < program.instructions.length) {
      val i = program.instructions.reverse
      val instr = i(register($pc).int)
//      println(instr)
      instr.exec
      register($pc) = register($pc) + 1
    }
  }
}