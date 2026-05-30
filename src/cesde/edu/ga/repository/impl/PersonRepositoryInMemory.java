package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Person;
import cesde.edu.ga.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryInMemory implements PersonRepository {

    private List<Person> persons;
    private Long nextPersonId;

    public PersonRepositoryInMemory() {
        this.persons = new ArrayList<>();
        this.nextPersonId = 1L;
    }

    @Override
    public Person create(Person person) {
        if (person == null) {
            return null;
        }

        if (existsByDocumentNumber(person.getDocumentNumber())) {
            return null;
        }

        person.setUserId(nextPersonId++);
        persons.add(person);
        return person;
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return false;
        }
        return findByDocumentNumber(documentNumber) != null;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public Person findById(Long userId) {
        if (userId == null || userId <= 0) {
            return null;
        }
        for (Person person : persons) {
            if (userId.equals(person.getUserId())) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return null;
        }
        for (Person person : persons) {
            if (documentNumber.equals(person.getDocumentNumber())) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findByStatus(String status) {
        if (status == null || status.isBlank()) {
            return new ArrayList<>();
        }
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (status.equals(person.getStatus())) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public boolean update(Person updatedPerson) {
        if (updatedPerson == null) {
            return false;
        }

        Person existing = findByDocumentNumber(updatedPerson.getDocumentNumber());
        if (existing != null && !existing.getUserId().equals(updatedPerson.getUserId())) {
            return false;
        }

        for (int i = 0; i < persons.size(); i++) {
            if (updatedPerson.getUserId().equals(persons.get(i).getUserId())) {
                persons.set(i, updatedPerson);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long userId) {
        Person person = findById(userId);
        if (person == null) {
            return false;
        }
        persons.remove(person);
        return true;
    }

    @Override
    public int count() {
        return persons.size();
    }
}
