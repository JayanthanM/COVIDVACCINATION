package com.cvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cvm.dao.CertificationDao;
import com.cvm.entity.Certification;
import com.cvm.exception.CertificatesIdNotFoundException;



@Repository("cs")
public class CertificationService {

	@Autowired
	CertificationDao cd;

	public String insertCertificate(Certification certificates) {
		Certification dbcertificate = cd.save(certificates);
		return "Added Successfully with certificateId :" + dbcertificate.getCertificateId();
	}

	public Certification findBycertificateId(long certificateId) throws CertificatesIdNotFoundException {
		Optional<Certification> op = cd.findById(certificateId);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new CertificatesIdNotFoundException("Certificate Not Found For :" + certificateId);
		}
	}


}
