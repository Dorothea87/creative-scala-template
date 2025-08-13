import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

1 + 2
40 + 8 - 6
1 + 2 * 3
1 + 2 //yes
1 ? 2 //no not a mathematical operator, can't be used on an int
4 / 2 //yes
1 / 2 //yes (rounds down)
1 / 0 //no, you can't divide by 0

"dorothea" substring 4
"Dorothea".substring(4)

1 < 2: Boolean
(3 + 2) > 7
(3 / 0) < 6

"Be with me always—take any form—drive me mad! Only do not leave me in this abyss, where I cannot find you!".substring(58, 80)

1 / 3: Double

"Dorothea" ++ " Toeller"
"Dorothea".++(" Toeller")

"hello world" substring 3 //tried 8, did not compile
"Hello world".substring(3, 8).substring(4, 5)

1 + 2 + 3
1.+(2).+(3)