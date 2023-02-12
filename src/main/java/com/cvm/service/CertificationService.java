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
		return "Added Successfully with certificateId:" + dbcertificate.getCertificateId();
	}

//	public List<Certification> findAll() throws NoCertificatesFoundException {
//		List<Certification> list = cd.findAll();
//		if (list.isEmpty()) {
//			throw new NoCertificatesFoundException("No Certificate found");
//
//		}
//		return list;
//	}

	public Certification findBycertificateId(long certificateId) throws CertificatesIdNotFoundException {
		Optional<Certification> op = cd.findById(certificateId);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new CertificatesIdNotFoundException("Certificate Not Found For certificateId:" + certificateId);
		}
	}

//	public String updateCertificate(long certificateId, Certification certificates)
//			throws CertificatesIdNotFoundException {
//		if (certificateId == certificates.getCertificateId()) {
//			Certification upCertificate = cd.save(certificates);
//			return "Updated Successfully for CertificateId:" + upCertificate.getCertificateId();
//		}
//
//		throw new CertificatesIdNotFoundException("Certificate Not Found For certificateId:" + certificateId);
//
//	}
//
//	public String deleteById(long certificateId) throws CertificatesIdNotFoundException {
//		if (cd.existsById(certificateId)) {
//			cd.deleteById(certificateId);
//			return "Deleted Successfully for CertificateId:" + certificateId;
//		}
//		throw new CertificatesIdNotFoundException("Certificate Not Found For certificateId:" + certificateId);
//
//	}
}
