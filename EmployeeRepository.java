package Employee.Management.System.EmployeeManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Employee.Management.System.EmployeeManagementSystem.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List findAll();

	Optional<Employee> findById(Long id);

	void deleteById(Long id);
}

