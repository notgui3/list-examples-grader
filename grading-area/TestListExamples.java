import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(right, left);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeSameArray() {
    List<String> left = Arrays.asList("a", "a", "a");
    List<String> merged = ListExamples.merge(left, left);
    List<String> expected = Arrays.asList("a", "a", "a", "a", "a", "a");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeString() {
    List<String> left = Arrays.asList("ab", "bc", "cd");
    List<String> right = Arrays.asList("ac", "da");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("ab", "ac", "bc", "cd", "da");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeEmpty() {
    List<String> left = Arrays.asList("");
    List<String> right = Arrays.asList("");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("","");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeDouble() {
    List<String> left = Arrays.asList("x","y","z");
    List<String> right = Arrays.asList("d","f","v");
    List<String> left1 = Arrays.asList("a","b","j");
    List<String> right1 = Arrays.asList("m","o","p");
    List<String> merged = ListExamples.merge(left, right);
    List<String> merged1 = ListExamples.merge(left1, right1);
    List<String> merged2 = ListExamples.merge(merged, merged1);
    List<String> expected = Arrays.asList("a","b","d","f","j","m","o","p","v","x","y","z");
    assertEquals(expected, merged2);
  }

  @Test
  public void testFilterMoon(){
    List<String> testMoon = Arrays.asList("d","f","moon");
    List<String> expectedMoon = Arrays.asList("moon");
    assertEquals(expectedMoon, ListExamples.filter(testMoon, new IsMoon()));
  }

  @Test
  public void testFilterDoubleMoon(){
    List<String> testMoon = Arrays.asList("moon","d","f","moon");
    List<String> expectedMoon = Arrays.asList("moon","moon");
    assertEquals(expectedMoon, ListExamples.filter(testMoon, new IsMoon()));
  }

  @Test
  public void testFilterEmpty(){
    List<String> testMoon = Arrays.asList("");
    List<String> result = new ArrayList<>();
    assertEquals(result, ListExamples.filter(testMoon, new IsMoon()));
  }
  


  
}
