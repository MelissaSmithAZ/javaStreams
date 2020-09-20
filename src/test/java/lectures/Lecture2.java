package lectures;

import beans.Person;

import java.net.BindException;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
    System.out.println("old way loop ");
    for (int i = 0; i <= 10; i++) {
      System.out.println(i);
    }
    System.out.println("exclusive");
    IntStream.range(0,10)
            // the :: is just the method ref that you are in so we already know we are in the range and need index
            //we can just
            .forEach(System.out::println);

    System.out.println("inclusive");
  //by  choosing rangeClosed it will include 0 and 10
    IntStream.rangeClosed(0, 10).forEach(System.out::println);

    //below is the old way of doing it
//            .forEach(index -> System?.out.println(index));

  }

  @Test
  public void rangeIteratingLists() throws Exception {
//    MockData.getPeople().stream().filter(person -> person.getAge() > 19 );
    List<Person> people  = MockData.getPeople();
    IntStream.range(0,people.size()).forEach(index ->  {
      //we have to set the consumption and type Person person
      Person person = people.get(index);
      System.out.println(person);
    }) ;

    people.forEach(System.out::println);


  }

  @Test
  public void intStreamIterate() throws Exception {
//      IntStream.iterate(0, operand -> operand + 1)
//          .filter(number -> number % 2 == 0)
//          .limit(20)
//          .forEach(System.out::println);

    IntStream.iterate(0, operand -> operand + 1).filter(number -> number % 2 == 0).limit(20).forEach(System.out::println);
  }
}
