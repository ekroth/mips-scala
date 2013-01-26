package mips.mem

case class Register(length: Int) extends RAM {
  assert(length >= 32, s"Length: $length. Minimum IntRegister length is 32.")
  override def update(i: Int, w: Word) = {
    if (Address(i) != Registers.zero)
      super.update(i, w)
  }
}

object Registers {
  val $0, zero = Address(0)

  val $1, $at = zero + 1

  val $2, $v0 = $at + 1
  val $3, $v1 = $v0 + 1

  val $4, $a0 = $v1 + 1
  val $5, $a1 = $a0 + 1
  val $6, $a2 = $a1 + 1
  val $7, $a3 = $a2 + 1

  val $8, $t0 = $a3 + 1
  val $9, $t1 = $t0 + 1
  val $10, $t2 = $t1 + 1
  val $11, $t3 = $t2 + 1
  val $12, $t4 = $t3 + 1
  val $13, $t5 = $t4 + 1
  val $14, $t6 = $t5 + 1
  val $15, $t7 = $t6 + 1

  val $16, $s0 = $t7 + 1
  val $17, $s1 = $s0 + 1
  val $18, $s2 = $s1 + 1
  val $19, $s3 = $s2 + 1
  val $20, $s4 = $s3 + 1
  val $21, $s5 = $s4 + 1
  val $22, $s6 = $s5 + 1
  val $23, $s7 = $s6 + 1

  val $24, $t8 = $s7 + 1
  val $25, $t9 = $t8 + 1

  val $26, $k0 = $t9 + 1
  val $27, $k1 = $k0 + 1

  val $28, $gp = $k1 + 1
  val $29, $sp = $gp + 1
  val $30, $s8, $fp = $gp + 1
  val $31, $ra = $s8 + 1

  val $pc = $ra + 1
  val $hi = $pc + 1
  val $lo = $hi + 1

  // TODO: $f0 -> $f31
}