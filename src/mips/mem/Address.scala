package mips.mem

case class Address(i: Int) {
  def +(o: Int) = Address(o + i)
  def apply()(implicit m: RAM) = m(i)
}