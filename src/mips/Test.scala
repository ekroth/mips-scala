package mips

import mips._
import mips.mem._
import mips.instructions._
import mips.mem.Registers._


object Test extends App with MIPS with IntegerArtihmetic with SPIM with Labels with Jumps {
	  addi 	($t0, $0, 5)
  'incr::
	  addi	($t1, $t1, 1)
	  addi	($trapCode, $0, 1)
	  addi	($intInput, $t1, 0)
	  syscall
	  bne	($t0, $t1, 'incr)
  
  exec
}