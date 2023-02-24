package com.cvm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.MedicalStaffDao;
import com.cvm.entity.MedicalStaff;
import com.cvm.exception.MedicalStaffIdNotFoundException;
import com.cvm.service.MedicalStaffService;
@SpringBootTest
public class MedicalStaffServiceTest {
    
	@InjectMocks
	MedicalStaffService mss;
	
	@Mock
	MedicalStaffDao msd;
	@Test
	public void  findByMedicalStaffIdTest() throws MedicalStaffIdNotFoundException  {
		
		MedicalStaff mStaff=new MedicalStaff();
		mStaff.setStaffId(1);
		mStaff.setStaffName("sadees");
		mStaff.setAssociated_with("abc");
		mStaff.setEmailId("abc1@gmail.com");
		mStaff.setPassword("sdfah5");
		mStaff.setLocation("chennai");
		mStaff.setMobileNo("83737740");
		
		Optional<MedicalStaff> opm=Optional.of(mStaff);
		
		when(msd.findById(mStaff.getStaffId())).thenReturn(opm);
		
		MedicalStaff mso=mss.findByMedicalStaffId(1);
		
		assertEquals("sadees", mso.getStaffName());
		assertEquals("abc", mso.getAssociated_with());
		assertEquals("abc1@gmail.com", mso.getEmailId());
		assertEquals("sdfah5", mso.getPassword());
		assertEquals("chennai", mso.getLocation());
	assertEquals("83737740", mso.getMobileNo());
		
	}

	@Test
	public void insertMedicalStaffTest()
	{
		MedicalStaff mStaff=new MedicalStaff();
		mStaff.setStaffId(1);
		mStaff.setStaffName("sadees");
		mStaff.setAssociated_with("abc");
		mStaff.setEmailId("abc1@gmail.com");
		mStaff.setPassword("sdfah5");
		mStaff.setLocation("chennai");
	mStaff.setMobileNo("83737740");
		
		when(msd.save(mStaff)).thenReturn(mStaff);
		String result = mss.insertMedicalStaff(mStaff);
		assertEquals("Added Successfully with staffId :" + mStaff.getStaffId(), result);
		}
	
	@Test
    public void deleteByIdTest() throws MedicalStaffIdNotFoundException {
		MedicalStaff mStaff=new MedicalStaff();
		mStaff.setStaffId(1);
		mStaff.setStaffName("sadees");
		mStaff.setAssociated_with("abc");
		mStaff.setEmailId("abc1@gmail.com");
		mStaff.setPassword("sdfah5");
		mStaff.setLocation("chennai");
		mStaff.setMobileNo("83737740");
    	String msg= "Deleted Successfully for StaffId :" + mStaff.getStaffId();
    	when(msd.existsById(mStaff.getStaffId())).thenReturn(true);
    	Mockito.doNothing().when(msd).deleteById(mStaff.getStaffId());
    	assertEquals(msg,mss.deleteById(mStaff.getStaffId()));
    }
	@Test
	public void updateMedicalStaffTest() throws MedicalStaffIdNotFoundException {
		MedicalStaff mStaff=new MedicalStaff();
		mStaff.setStaffId(1);
		mStaff.setStaffName("sadees");
		mStaff.setAssociated_with("abc");
		mStaff.setEmailId("abc1@gmail.com");
		mStaff.setPassword("sdfah5");
		mStaff.setLocation("chennai");
	mStaff.setMobileNo("83737740");
		
		when(msd.existsById(mStaff.getStaffId())).thenReturn(true);
		when(msd.save(mStaff)).thenReturn(mStaff);
		String result = mss.updateMedicalStaff(mStaff.getStaffId(), mStaff);
		assertEquals("Updated Successfully for staffId :" + mStaff.getStaffId(),result);
		
	}
	
	
}