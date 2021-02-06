import java.util.*;
public class Main {
    public static void main(String args[]) {
      Set<String> nations = new HashSet<String>();
      System.out.printf("isEmpty() : %b%n",nations.isEmpty());
      System.out.println("Adding elements into the hashset:");
      Collections.addAll(nations,"FR","GB","US","RUS");
      System.out.println("Nations: "+nations);
      System.out.printf("isEmpty() : %b%n",nations.isEmpty());
      System.out.printf("Size() : %d%n",nations.size());
      System.out.printf("contains(\"GB\") : %b%n",nations.contains("GB"));
      System.out.println("Using iterator:");
      for(Iterator iterator=nations.iterator();iterator.hasNext();){
          System.out.printf(iterator.next()+(iterator.hasNext()?", ":"%n"));
      }
      System.out.println("Changing hashset to array: ");
      String[] nationsContent = nations.toArray(new String[0]);
      for(String s : nations)
        System.out.printf("%s, ",s);
      System.out.println();
      Set<String> g7 = new HashSet<String>();
      Collections.addAll(g7,"FR","IT","JP","GB","CA","US","GER");
      System.out.println("G7 nations: "+g7);
      System.out.println("Nations: "+nations);
      System.out.printf("g7.removeAll(nations) (AKA complement) : %s, response : %b%n",g7,g7.removeAll(nations));
      System.out.printf("g7.retainAll(nations) (AKA intersetion) : %s, response : %b%n",g7,g7.retainAll(nations));

    }
}

// print
/*
isEmpty() : true
Adding elements into the hashset:
Nations: [RUS, GB, FR, US]
isEmpty() : false
Size() : 4
contains("GB") : true
Using iterator:
RUS, GB, FR, US
Changing hashset to array: 
RUS, GB, FR, US, 
G7 nations: [GER, JP, IT, GB, FR, CA, US]
Nations: [RUS, GB, FR, US]
g7.removeAll(nations) (AKA complement) : [GER, JP, IT, CA], response : true
g7.retainAll(nations) (AKA intersetion) : [], response : true
*/