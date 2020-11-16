package ch.mse.app.typeclass

object Logging {
  import java.io.PrintStream

  implicit val out = System.out
  implicit def timePrefix = "" + new java.util.Date

  def log(msg: String)(implicit out: PrintStream): Unit = out.println(msg)
  def logTimed(msg: String)(implicit out: PrintStream): Unit = log("[" + new java.util.Date + "] " + msg)
  def logPrefixed(msg: String)(implicit out: PrintStream, prefix: String): Unit = log("[" + prefix + "] " + msg)


  def main(args: Array[String]): Unit = {
    log("Implicits")
    log("Error message")(System.err)
    logTimed("Hello")
    logTimed("Hello")(System.err)
    logPrefixed("Hello")
    Thread.sleep(1000)
    logPrefixed("Hello")
    logPrefixed("Hello")(implicitly[PrintStream], ">>")
    logPrefixed("Hello")(implicitly, implicitly)
  }
}
