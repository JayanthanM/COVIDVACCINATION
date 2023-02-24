package com.cvm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cvm.dao.AdminDao;
import com.cvm.entity.Admin;
import com.cvm.exception.AdminsIdNotFoundException;
import com.cvm.exception.NoAdminsFoundException;
import com.cvm.service.AdminServices;
@SpringBootTest
public class AdminServicesTest {

	@InjectMocks
	AdminServices as;

	@MockBean
	AdminDao ad;
	

	List<Admin> list = new ArrayList<>();
	Admin admin = new Admin();
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testInsertAdmin() {
		admin.setAdminId(1);
		admin.setEmailId("logesh@gmail.com");
		admin.setLocation("Chennai");
		admin.setPassword("loge");

		when(ad.save(admin)).thenReturn(admin);
		String result = as.insertAdmin(admin);
		assertEquals("Added Successfully with AdminId :" + admin.getAdminId(), result);
	}

	@Test
	public void testFindAll() throws NoAdminsFoundException {
		admin.setAdminId(1);
		admin.setEmailId("logesh@gmail.com");
		admin.setLocation("Chennai");
		admin.setPassword("loge");
		list.add(admin);
		when(ad.findAll()).thenReturn(list);
		List<Admin> result = new ArrayList<>();
		result = as.findAll();
		assertEquals(list, result);

	}

	 @Test
	 public void testFindByAdminId() throws AdminsIdNotFoundException  { 
	  long id=2;
	  admin.setAdminId(2);
	  admin.setEmailId("megathesh@gmail.com");
	  admin.setLocation("Trichy");
	  admin.setPassword("mega"); 
	  Optional<Admin> op = Optional.of(admin); 
	  when(ad.existsById(admin.getAdminId())).thenReturn(true); 
	  when(ad.findById(admin.getAdminId())).thenReturn(op); 
	  Optional<Admin> result = Optional.of(as.findByAdminId(admin.getAdminId())); 
	  assertEquals(op, result); 
	  }
	 

	@Test
	public void testUpdateAdmin() throws AdminsIdNotFoundException {
		long id = 2;
		admin.setAdminId(2);
		admin.setEmailId("megathesh@gmail.com");
		admin.setLocation("Trichy");
		admin.setPassword("mega");
		when(ad.existsById(admin.getAdminId())).thenReturn(true);
		when(ad.save(admin)).thenReturn(admin);
		String result = as.updateAdmin(id, admin);
		assertEquals("Updated Successfully for AdminId :" + admin.getAdminId(), result);
	}

	@Test
	public void testDeleteAdminById() throws AdminsIdNotFoundException {
		long id = 2;
		admin.setAdminId(2);
		admin.setEmailId("megathesh@gmail.com");
		admin.setLocation("Trichy");
		admin.setPassword("mega");
		when(ad.existsById(admin.getAdminId())).thenReturn(true);
		String result = as.deleteById(admin.getAdminId());
		assertEquals("Deleted Successfully for AdminId :" + admin.getAdminId(), result);

	}
}