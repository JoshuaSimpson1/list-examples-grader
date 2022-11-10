import static org.junit.Assert.*;
import org.junit.*;
import java.util.*; 

class StringCheckerTests implements StringChecker{
    public boolean checkString(String s){
        if(!s.equals("hello")){
            return true;
        }else{
            return false;
        }
    }
}

public class TestListExamples {
  // Write your grading tests here!
  @Test
  public void testFilter(){
    StringChecker sc = new StringCheckerTests();

    List<String> testAr = new ArrayList<>();
    testAr.add("hello");
    testAr.add("world");
    testAr.add("I Love CSE 15L <3");

    List<String> resultAr = ListExamples.filter(testAr,sc);
    
    List<String> expectedAr = new ArrayList<>();
    expectedAr.add("world");
    expectedAr.add("I Love CSE 15L <3");


    assertEquals(resultAr, expectedAr);
  }

  @Test
  public void testMerge(){
    List<String> testAr = new ArrayList<>();
    testAr.add("Apooky");
    testAr.add("Bcary");

    List<String> testAr2 = new ArrayList<>();
    testAr2.add("Ckeletons");
    testAr2.add("Dend Shivers Down");
    testAr2.add("Eour spine");

    List<String> resultAr = ListExamples.merge(testAr,testAr2);

    List<String> expectedAr = new ArrayList<>();
    expectedAr.add("Apooky");
    expectedAr.add("Bcary");
    expectedAr.add("Ckeletons");
    expectedAr.add("Dend Shivers Down");
    expectedAr.add("Eour spine");

    assertEquals(expectedAr, resultAr);
  }
}
