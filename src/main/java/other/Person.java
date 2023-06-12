package other;

import org.junit.Test;
import org.junit.jupiter.api.TestClassOrder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class Person {

    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

interface PeopleRepository {
    List<Person> getAllPeople();
    List<Person> getByName(String name);
}

class PersonService {

    private PeopleRepository peopleRepository;

    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    List<Person> getAdults() {
        return peopleRepository.getAllPeople().stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
    }

    List<Person> findByName(String name) {
        return peopleRepository.getByName(name);
    }
}

class PeopleRepositoryStub implements PeopleRepository{

    @Override
    public List<Person> getAllPeople() {
        Person person1 = new Person("John", "Doe", 35);
        Person person2 = new Person("Joseph", "Dendy", 43);
        return List.of(person1, person2);
    }

    @Override
    public List<Person> getByName(String name) {
        return null;
    }
}

class TestClass {

    @Test
    void getAllPeople() {
        //given
        PeopleRepository peopleRepositoryStub = new PeopleRepositoryStub();
        PersonService personService = new PersonService(peopleRepositoryStub);

        //when
        List<Person> people = personService.getAdults();

        //then
        assertThat(people.size(), is(2));
    }

    @Test
    void getEmptyPeopleList() {

        //given
        PeopleRepository peopleRepository = mock(PeopleRepository.class);
        PersonService personService = new PersonService(peopleRepository);
        given(peopleRepository.getAllPeople()).willReturn(Collections.emptyList());

        //when
        List<Person> activeAccounts = personService.getAdults();

        //then
        assertThat(activeAccounts.size(), is(0));
    }

    @Test
    void getPersonNameAndAge() {

        //given
        Person realPerson = new Person("John", "Doe", 35);
        Person spyPerson = spy(realPerson);
        given(spyPerson.getAge()).willReturn(20);

        //when
        String actualName = spyPerson.getName();
        int actualAge = spyPerson.getAge();

        //then
        assertThat(actualName, is("John"));
        assertThat(actualAge, is(20));
    }
}