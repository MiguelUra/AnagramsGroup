import java.io.{BufferedReader, File, FileNotFoundException, FileReader}
import java.util.stream
import scala.collection.mutable.ListBuffer
import scala.io.Source

object Anagrams{

  def main(args: Array[String]): Unit = {
    var file = new File( "src/main/scala/wordList.txt")

    val start = System.nanoTime
    GetPath((file))
    /*Print()*/
    val end = System.nanoTime()
    println(s"Tie taken: ${(end - start)/1000000000}s")

  }

  val AnagramsSet:scala.collection.mutable.Map[String, ListBuffer[String]] = scala.collection.mutable.Map[String, ListBuffer[String]]()

  def GetPath(filename: File): Unit ={
    if(filename == null) throw new IllegalArgumentException
    if(filename.exists()){
      for(line<- Source.fromFile(filename).getLines()){
        /*MapFill(line, AnagramsSet)*/
      }
    }
    else throw new FileNotFoundException(s"Can't find needed resource: $filename")
  }
}