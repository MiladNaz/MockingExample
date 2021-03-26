package uppgift3;

import com.example.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryVersionOfEmployeeRepositoryTest {


    InMemoryVersionOfEmployeeRepository inMemoryVersionOfEmployeeRepository = new InMemoryVersionOfEmployeeRepository();

    @Test
    @DisplayName("Has saved employee")
    void hasSavedEmployee() {

        Employee employee = new Employee("1", 2000);

        inMemoryVersionOfEmployeeRepository.save(employee);

        assertEquals(1, inMemoryVersionOfEmployeeRepository.findAll().size());

    }

    @Test
    @DisplayName("Overwriting employee")
    void overwritingEmployee() {
        //Arrange
        Employee employee1 = new Employee("1", 2000);
        Employee employee2 = new Employee("1", 3000);
        inMemoryVersionOfEmployeeRepository.save(employee1);

        //Act
        inMemoryVersionOfEmployeeRepository.save(employee2);

        //Assert
        assertEquals(1, inMemoryVersionOfEmployeeRepository.findAll().size());
        assertEquals(3000, inMemoryVersionOfEmployeeRepository.findAll().get(0).getSalary());

    }

    @Test
    @DisplayName("Adding employee with no id")
    void addingEmployeeWithNoId() {
        Employee employee = new Employee("0", 2000);

        inMemoryVersionOfEmployeeRepository.save(employee);

        assertEquals("1", inMemoryVersionOfEmployeeRepository.findAll().get(0).getId());

    }
}