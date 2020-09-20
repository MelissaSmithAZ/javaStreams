package lectures;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;

import beans.Car;
import beans.CarDTO;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {

    ImmutableList<Car> cars = MockData.getCars();
    //create a new list to  pring our filtered data
    List<Car> carsFiltered = cars.stream()
            .filter(carPredicate)
            .collect(Collectors.toList());
    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());

  }
  final Predicate<Car> carPredicate = car -> car.getPrice() < 10000;


  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data object type and transform to another  example Person has many more properties than the PersonDTO below
    //we simply created a new object than we looped with the forEach to pring out
    List<Person> people = MockData.getPeople();
    List<PersonDTO> dtos = people.stream()
            .map(person -> {
              PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
              return dto;
            })
            .collect(Collectors.toList());

    dtos.forEach(System.out::println);

    assertThat(dtos).hasSize(1000);
    System.out.println(dtos.size());
  }
  @Test
  public void ourFirstMappings() throws Exception {
    // This is another way to shorten what we did
    //as we  already have PersonDTO a shortened object of Person defined
    //we can use the :: used to refer a method of another class
    //PersonDTO is a class that has a static method PersonDTO creating a new person with first last name and age
    //by using the :: we have it and map it already
    List<Person> people = MockData.getPeople();
    List<PersonDTO> dtos = people.stream()
            .map(PersonDTO :: map)
            .collect(Collectors.toList());

    dtos.forEach(System.out::println);

    assertThat(dtos).hasSize(1000);
    System.out.println(dtos.size());
  }
  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    //MockData.getCars() will get  all  the cars in the class MockData
    //we stream it and  map and as we are returning a double
    //we do mapToDouble and each car from the MockData we want the car.Price
    // we than just .average to  get the average of all the cars we looped through
    MockData.getCars()
            .stream()
            .mapToDouble(car -> car.getPrice())
            .average()
            .orElse(0);
  }
  @Test
  public void averageCarPrice1() throws Exception {
    // calculate average of car prices
    // in this excampe we use the :: to refer to a method getprice in Car

    //note highligt the area you want to set  to a variable do alt  or control  comand v and it will get you set for your variable
    //this  way your can return and store the value of  the method
    double average = MockData.getCars()
            .stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);

  }
}



