import org.scalatest.FunSuite
import java.io.{BufferedReader, File, FileNotFoundException, FileReader}
import java.util.stream
import scala.collection.mutable.ListBuffer
import scala.io.Source
class AnagramsTest extends FunSuite{
 test(testName = "Anagrams_GetPath_ArgsInput_IsNull_ThrowsNullArgumentException"){
   assertThrows[IllegalArgumentException]{
      Anagrams.GetPath(null)
   }
 }
}