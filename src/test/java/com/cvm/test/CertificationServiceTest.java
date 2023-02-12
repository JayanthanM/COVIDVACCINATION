package com.cvm.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.CertificationDao;
import com.cvm.entity.Certification;
import com.cvm.exception.CertificatesIdNotFoundException;
import com.cvm.service.CertificationService;

@SpringBootTest
public class CertificationServiceTest 
{
	@Mock
	CertificationDao cd;
	@InjectMocks
	CertificationService cs;
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testInsertCertificate() 
	{
		Certification certificates = new Certification();
		certificates.setCertificateId(1);
		when(cd.save(certificates)).thenReturn(certificates);
		String result = cs.insertCertificate(certificates);
		assertEquals("Added Successfully with certificateId:1", result);
		}
	@Test
	public void testFindByCertificateIdSuccess() throws CertificatesIdNotFoundException 
	{
		Certification certificates = new Certification();
		certificates.setCertificateId(1);
		when(cd.findById(1L)).thenReturn(Optional.of(certificates));
		Certification result = cs.findBycertificateId(1);assertEquals(certificates, result);
		}
	@Test
	public void testFindByCertificateIdNotFound() 
	{
		when(cd.findById(1L)).thenReturn(Optional.empty());
		assertThrows(CertificatesIdNotFoundException.class, () -> {cs.findBycertificateId(1);});
	}
}