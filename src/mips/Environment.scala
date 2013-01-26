package mips

import mips.mem.Memory
import mips.mem.Register
import scala.collection.immutable.Map
import mips.instructions.Label

trait Environment {
  def memory: Memory
  def register: Register
  def labels: Map[String, Label]
}