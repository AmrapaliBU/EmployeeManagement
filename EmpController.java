package Employee.Management.System.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Employee.Management.System.EmployeeManagementSystem.model.Employee;
import Employee.Management.System.EmployeeManagementSystem.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	 private final EmpService employeeService;

	    @Autowired
	    public EmpController(EmpService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }

	    @PostMapping
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return employeeService.saveEmployee(employee);
	    }

	    @PutMapping("/{id}")
	    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	        if (employeeService.getEmployeeById(id) == null) {
	            return null;
	        }
	        employee.setId(id);
	        return employeeService.saveEmployee(employee);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	    }
	}
