package com.cvm.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.EmployeesDao;
import com.cvm.entity.Employees;
import com.cvm.exception.EmployeeIdNotFoundException;
import com.cvm.exception.NoEmployeesFoundException;
import com.cvm.service.EmployeesService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeesServiceTest {
	@Mock
	private EmployeesDao ed;
	@InjectMocks
	private EmployeesService es;
	private Employees emp1;
	private Employees emp2;
	private List<Employees> empList;
	@Before
	public void setUp() {emp1 = new Employees();
	emp2 = new Employees();empList = Arrays.asList(emp1, emp2);}
	@Test
	public void testInsertEmployee() {
		EmployeesService employeessService = mock(EmployeesService.class);
		Employees emp = new Employees();
		when(employeessService.insertEmployee(emp)).thenReturn("Added Successfully with Id:1");
		String result = employeessService.insertEmployee(emp);
		assertEquals("Added Successfully with Id:1", result);
		}
	@Test
	public void testFindAll() throws NoEmployeesFoundException 
	{
		EmployeesService employeessService = mock(EmployeesService.class);
		List<Employees> employees = new ArrayList<>();
		employees.add(new Employees());
		when(employeessService.findAll()).thenReturn(employees);
		List<Employees> result = employeessService.findAll();
		assertEquals(employees, result);
	}
	@Test(expected = NoEmployeesFoundException.class)
	public void testFindAllNoEmployeesFoundException() throws NoEmployeesFoundException 
	{
		EmployeesService employeesService = mock(EmployeesService.class);
		when(employeesService.findAll()).thenThrow(new NoEmployeesFoundException("No Employee found"));
		employeesService.findAll();}
	@Test
	public void testFindByEmployeeId() throws EmployeeIdNotFoundException 
	{
		EmployeesService employeessService = mock(EmployeesService.class);
		Employees emp = new Employees();
		when(employeessService.findByEmployeeId(1)).thenReturn(emp);
		Employees result = employeessService.findByEmployeeId(1);
		assertEquals(emp, result);}
	@Test(expected = EmployeeIdNotFoundException.class)
	public void testFindByEmployeeIdEmployeessIdNotFoundException() throws EmployeeIdNotFoundException 
	{
		EmployeesService employeessService = mock(EmployeesService.class);
		when(employeessService.findByEmployeeId(1)).thenThrow(new EmployeeIdNotFoundException("Employee Not Found For Id:1"));
		employeessService.findByEmployeeId(1);}
	@Test
	public void testUpdateEmployee() throws EmployeeIdNotFoundException 
	{
		long employeeId = 1L;
		Employees emps = new Employees();
		emps.setEmp_id(employeeId);
		when(ed.save(emps)).thenReturn(emps);
		String result = es.updateEmployee(employeeId, emps);
		assertEquals("Updated Successfully for id:" + employeeId, result);
		verify(ed).save(emps);}
	@Test(expected = EmployeeIdNotFoundException.class)
	public void testUpdateEmployeeWithWrongId() throws EmployeeIdNotFoundException 
	{
		long employeeId = 1L;
		long wrongId = 2L;
		Employees emps = new Employees();
		emps.setEmp_id(employeeId);
		es.updateEmployee(wrongId, emps);
		}
	@Test
	public void testDeleteById() throws EmployeeIdNotFoundException 
	{long employeeId = 1L;
	when(ed.existsById(employeeId)).thenReturn(true);
	String result = es.deleteById(employeeId);
	assertEquals("Deleted Successfully for id:" + employeeId, result);
	verify(ed).deleteById(employeeId);}
	@Test(expected = EmployeeIdNotFoundException.class)
	public void testDeleteByIdNotExists() throws EmployeeIdNotFoundException 
	{
		long employeeId = 1L;
		when(ed.existsById(employeeId)).thenReturn(false);
		es.deleteById(employeeId);
		}
}