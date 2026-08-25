package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.PersonExceptions;
import cesde.edu.ga.model.Person;
import cesde.edu.ga.repository.PersonRepository;
import cesde.edu.ga.service.PersonService;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public Person create(Person person) {
        if (person == null) {
            throw new PersonExceptions("Person cannot be null");
        }
        if (isInvalidPerson(person)) {
            throw new PersonExceptions("Invalid person data");
        }
        return personRepository.create(person);
    }
    @Override
    public boolean update(Person person) {
        if (person == null) {
            throw new PersonExceptions("Person cannot be null");
        }
        if (person.getUserId() == null || person.getUserId() <= 0L) {
            throw new PersonExceptions("User id is invalid");
        }
        if (isInvalidPerson(person)) {
            throw new PersonExceptions("Invalid person data");
        }
        return personRepository.update(person);
    }
    @Override
    public boolean delete(Long userId) {
        if (userId == null || userId <= 0L) {
            throw new PersonExceptions("User id is invalid");
        }
        return personRepository.delete(userId);
    }
    @Override
    public Person findById(Long userId) {
        if (userId == null || userId <= 0L) {
            throw new PersonExceptions("User id is invalid");
        }
        Person person = personRepository.findById(userId);
        return person;
    }
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    @Override
    public Person findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isBlank()) {
            throw new PersonExceptions("Document number cannot be null or empty");
        }
        return personRepository.findByDocumentNumber(documentNumber);
    }
    @Override
    public List<Person> findByStatus(String status) {
        if (status == null || status.trim().isBlank()) {
            throw new PersonExceptions("Status cannot be null or empty");
        }
        return personRepository.findByStatus(status);
    }
    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isBlank()) {
            throw new PersonExceptions("Document number cannot be null or empty");
        }
        return personRepository.existsByDocumentNumber(documentNumber);
    }
    private boolean isInvalidPerson(Person person) {
        return isBlank(person.getDocumentType())
                || isBlank(person.getDocumentNumber())
                || isBlank(person.getFirstName())
                || isBlank(person.getLastName())
                || isBlank(person.getStatus());
    }
    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}