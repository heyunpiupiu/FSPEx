package laas.fspex.utils

/**
 * Created by Ulrich Matchi Aïvodji on 16/04/2015.
 */
object Logger {
  def log(msg:String) = {
    println(s"[FSPEX]  $msg")
  }

  def warn(msg:String) = {
    println(s"[FSPEX WARNING]  $msg")
  }

  def error(msg:String) = {
    println(s"[FSPEX]  $msg")
  }

  def timed(startMsg:String,endMsg:String)(f:() => Unit):Unit = {
    log(startMsg)
    val s = System.currentTimeMillis
    f()
    val e = System.currentTimeMillis
    val t = "%,d".format(e-s)
    log(s"$endMsg (took $t ms)")
  }

  def timed(startMsg:String)(f:() => Unit):Unit =
    timed(startMsg,"Finished.")(f)

  def timedCreate[T](startMsg:String,endMsg:String)(f:() => T):T = {
    log(startMsg)
    val s = System.currentTimeMillis
    val result = f()
    val e = System.currentTimeMillis
    val t = "%,d".format(e-s)
    log(s"\t$endMsg (in $t ms)")
    result
  }

  def timedCreate[T](startMsg:String)(f:() => T):T =
    timedCreate(startMsg,"Finished.")(f)
}