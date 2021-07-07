import org.scalatest.FunSuite
import java.io.{BufferedReader, File, FileNotFoundException, FileReader}
import java.util.stream
import scala.collection.mutable.ListBuffer
import scala.io.Source

class AnagramsTest extends FunSuite{
 test(testName = "Anagrams_GetPath_ArgsInput_IsNull_ThrowsNullArgumentException") {
   assertThrows[IllegalArgumentException] {
     Anagrams.GetPath(null)
   }
 }

 test (testName = "Anagrams_GetPath_ArgsInput_FileNoExists_ThroesNotFoundException"){
   var file = new File( "hola")
   assertThrows[FileNotFoundException]{
     Anagrams.GetPath(file)
   }
 }

  test(testName = "Anagrams_MapFill_MapsShouldBeEquals"){
    val AnagramsSet = Map("moor" -> ListBuffer("romo", "moro"), "ahlo" -> ListBuffer("hola","olah"))
    val expected : scala.collection.mutable.Map[String,ListBuffer[String]] = scala.collection.mutable.Map[String,ListBuffer[String]]()

    Anagrams.MapFill("romo",expected)
    Anagrams.MapFill("moro",expected)
    Anagrams.MapFill("hola",expected)
    Anagrams.MapFill("olah",expected)

    assert(expected == AnagramsSet)
  }
}