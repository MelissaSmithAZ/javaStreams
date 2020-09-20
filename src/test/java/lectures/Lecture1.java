package lectures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;

import beans.Person;

import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;


public class Lecture1 {


  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    //create a List of Peersons
    List<Person> youngPeople = Lists.newArrayList();

    //we can also set the limit this is the older way of doing things limit it to 10 people

    final int limit = 10;
    int count = 0;
  //for each kind of like mapping over for each person in the Person list
    for( Person person : people) {
        //if they meet the criteria
      if(person.getAge()  <= 18){
        //than add to the array
        youngPeople.add(person);
        count++;
        if(count == limit){
          break;
        }
      }
//      for(Person young: youngPeople){
//        System.out.println(young.getAge());
//      }
    }


  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    MockData.getPeople()
            .stream()
            .filter(person -> person.getAge() <= 18)
            .collect(Collectors.toList()).forEach(System.out::println);

    //below is a more clear way to look at the streem

    //as MockData is already an array of People we can just do a .stream from there.

    //    List<Person> people  = MockData.getPeople();
//
//    List<Person> youngPeople = people.stream()
//            .filter(person -> person.getAge() <= 18)
//            .limit(10)
//            .collect(Collectors.toList());
//    youngPeople.forEach(System.out::println);


  }
}
