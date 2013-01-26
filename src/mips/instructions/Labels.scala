package mips.instructions

import mips.MIPS
import mips.mem.Word

case class Label(name: String, position: Word)

trait Labels extends MIPS {
  implicit class SymbolLabel(s: Symbol) {
    def ::() {
      addLabel(Label(s.name, program.instructions.length - 1))
    }
  }
  
  implicit class UnitLabel(s: Unit) {
    def ::(s: Symbol) {
      addLabel(Label(s.name, program.instructions.length - 2))
    }
  }
}