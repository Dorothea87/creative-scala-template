import doodle.core.*
import doodle.image.*
import doodle.image.syntax.all.*
import doodle.image.syntax.core.*
import doodle.java2d.*
import doodle.reactor.*
import scala.concurrent.duration.*
import cats.effect.unsafe.implicits.global

// To use this example:
//
// 1. run `sbt`
// 2. run the `run` command within `sbt`
object Example {
  val image =
    Image
      .circle(100)
      .fillColor(Color.deepPink)
      .on(Image.circle(200).fillColor(Color.hotpink))
      .on(Image.circle(300).fillColor(Color.peachPuff))

  val animation =
    Reactor
      .init(0.degrees)
      .withOnTick(a => a + 4.degrees)
      //.withStop(a => a > 360.degrees)
      .withTickRate(25.millis)
      .withRender { a =>
        val location = Point(180, a)
        val planet = Image.circle(40.0).noStroke.fillColor(Color.teal)
        val moon = Image
          .circle(28.0)
          .noStroke
          .fillColor(Color.deepSkyBlue)
          .at(Point(80, a * 5))
        val moon2 = Image
          .circle(20.0)
          .noStroke
          .fillColor(Color.greenYellow)
          .at(Point(30, a * 1))
        val square = Image
          .square(45.0)
          .strokeColor(Color.black)
          .fillColor(Color.yellow)
          .at(20, a *3)

        moon.on(planet).at(location)
        moon2.on(moon).above(planet).at(location)
        square.on(planet).below(moon2).on(moon).at(location)
      }

  val frame = Frame.default.withSize(600, 600).withCenterAtOrigin

  @main def go(): Unit = {
    image.draw()

    // Comment out the above and uncomment the below to display the animation
    animation.run(frame)
  }
}
