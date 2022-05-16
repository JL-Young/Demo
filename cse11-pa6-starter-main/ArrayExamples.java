import tester.*;

class Pair {
  int a, b;
  Pair(int a, int b){
    this.a = a;
    this.b = b;
  }
}

class ArrayExamples{
  static String joinWith(String[] strings, String seperator){
    String result = "";
    for(int i = 0; i < strings.length; i += 1){
      result += strings[i];
      if(i < strings.length - 1){
        result += seperator;
      }
    }
    return result;
  }

  static boolean somethingFalse(boolean[] booleans){
    for(boolean boo: booleans){
      if(boo == false){
        return true;
      }
    }
    return false;
  }

  static int countWithinRange(double[] doubles, double low, double high){
    int result = 0;
    for(double dou: doubles){
      if(dou >= low && dou <= high){
        result += 1;
      }
    }
    return result;
  }

  static double[] numsWithinRange(double[] doubles, double low, double high){
    double[] result = new double[countWithinRange(doubles, low, high)];
    int index = 0;
    for(int i = 0; i < doubles.length; i += 1){
      if(doubles[i] >= low && doubles[i] <= high){
        result[index] = doubles[i];
        index += 1;
      }
    }
    return result;
  }

  static Pair maxmin(int[] ints){
    int a = ints[0];
    int b = ints[0];
    for(int i = 0; i < ints.length; i += 1){
      if(a > ints[i]){
        a = ints[i];
      }
      if(b < ints[i]){
        b = ints[i];
      }
    }
    return new Pair(a, b);
  }

  static String earliest(String[] strings){
    String result = strings[0];
    for(int i = 0; i < strings.length; i +=1){
      if(result.compareTo(strings[i]) > 0){
        result = strings[i];
      }
    }
    return result;
  }


  void testJoinWith(Tester t){
    String[] ex1 = {};
    String[] ex2 = {"1", "2","3"};
    String[] ex3 = {"Desktop","CSE-11","cse11-pa6","","cse11-pa6-starter-main",};
    t.checkExpect(ArrayExamples.joinWith(ex1, "."), "");
    t.checkExpect(ArrayExamples.joinWith(ex2, ","), "1,2,3");
    t.checkExpect(ArrayExamples.joinWith(ex3, "/"), "Desktop/CSE-11/cse11-pa6//cse11-pa6-starter-main");
  }

  void testSomethingFalse(Tester t){
    boolean[] ex1 = {};
    boolean[] ex2 = {true, false};
    boolean[] ex3 = {true, true, true, true};
    t.checkExpect(ArrayExamples.somethingFalse(ex1), false);
    t.checkExpect(ArrayExamples.somethingFalse(ex2), true);
    t.checkExpect(ArrayExamples.somethingFalse(ex3), false);
  }
  
  void testCountWithinRange(Tester t){
    double[] ex1 = {};
    double[] ex2 = {0.0, 8.8, 9.9};
    double[] ex3 = {4.4, 1.1, 6.6, 5.5, 5.5, 2.2, 5.5, 3.3};
    t.checkExpect(ArrayExamples.countWithinRange(ex1, 1.0, 2.0), 0);
    t.checkExpect(ArrayExamples.countWithinRange(ex2, 1.5, 9.5), 1);
    t.checkExpect(ArrayExamples.countWithinRange(ex3, 3.0, 6.0), 5);
  }

  void testNumsWithinRange(Tester t){
    double[] ex1 = {};
    double[] ex2 = {0.0, 8.8, 9.9};
    double[] ex3 = {4.4, 1.1, 6.6, 5.5, 5.5, 2.2, 5.5, 3.3};
    double[] exp1 = {};
    double[] exp2 = {8.8};
    double[] exp3 = {4.4, 5.5, 5.5, 5.5, 3.3};
    t.checkExpect(ArrayExamples.numsWithinRange(ex1, 1.0, 2.0), exp1);
    t.checkExpect(ArrayExamples.numsWithinRange(ex2, 1.5, 9.5), exp2);
    t.checkExpect(ArrayExamples.numsWithinRange(ex3, 3.0, 6.0), exp3);
  }

  void testMaxmin(Tester t){
    int[] ex1 = {10, 8, 11, 4};
    int[] ex2 = {4};
    int[] ex3 = {55, 55, 55};
    t.checkExpect(ArrayExamples.maxmin(ex1), new Pair(4, 11));
    t.checkExpect(ArrayExamples.maxmin(ex2), new Pair(4, 4));
    t.checkExpect(ArrayExamples.maxmin(ex3), new Pair(55, 55));
  }
  
  void testEarliest(Tester t){
    String[] ex1 = {"c", "Cd", "ca", "hijk"};
    String[] ex2 = {"hello"};
    String[] ex3 = {"a", "b", "c", ""};
    t.checkExpect(ArrayExamples.earliest(ex1), "Cd");
    t.checkExpect(ArrayExamples.earliest(ex2), "hello");
    t.checkExpect(ArrayExamples.earliest(ex3), "");
  }
}

class ProvidedArrayExamples {
  void testJoinWith(Tester t){
    String[] example1 = {"a", "b","c"};
    t.checkExpect(ArrayExamples.joinWith(example1, ":"), "a:b:c");
  }

  void testSomethingFalse(Tester t){
    boolean[] example1 = {true, false};
    t.checkExpect(ArrayExamples.somethingFalse(example1), true);
  }

  void testCountWithinRange(Tester t){
    double[] example = {0.1, 1.3, 2.6};
    t.checkExpect(ArrayExamples.countWithinRange(example, 1.1, 2.2), 1);
  }

  void testNumsWithinRange(Tester t){
    double[] example = {0.0, 3.0, 1.4, 1.5, 2.7, 9.1, 2.1};
    double[] expected = {1.4, 1.5, 2.1};
    t.checkExpect(ArrayExamples.numsWithinRange(example, 1.1, 2.2), expected);
  }

  void testMaxmin(Tester t){
    int[] example = {4, 5, 2, 3, 1};
    t.checkExpect(ArrayExamples.maxmin(example), new Pair(1, 5));
  }

  void testEarliest(Tester t){
    String[] example = {"aa", "aab", "abcd", "a"};
    t.checkExpect(ArrayExamples.earliest(example), "a");
  }
}