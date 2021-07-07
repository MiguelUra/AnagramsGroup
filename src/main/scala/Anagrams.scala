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
        MapFill(line, AnagramsSet)
      }
    }
    else throw new FileNotFoundException(s"Can't find needed resource: $filename")
  }

  def MapFill(line: String, AnagramSet: scala.collection.mutable.Map[String, ListBuffer[String]] = scala.collection.mutable.Map[String, ListBuffer[String]]()): Unit = {
    val new_line = line.sorted
    if (AnagramSet.contains(new_line)) {
      //El if que falta
      AnagramSet(new_line) += line

    } else {
      AnagramSet += (new_line -> ListBuffer[String]())
      AnagramSet(new_line) += line
    }
  }

}