package com.cvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvm.dao.AdminDao;
import com.cvm.entity.*;
import com.cvm.exception.AdminsIdNotFoundException;
import com.cvm.exception.NoAdminsFoundException;

@Service("as")
public class AdminServices {
	@Autowired
	AdminDao ad;
	
	public String insertAdmin(Admin admin) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(admin.getPassword());
		admin.setPassword(encryptedPwd);
		Admin dbAdmin = ad.save(admin);
		return "Added Successfully with AdminId :" + dbAdmin.getAdminId();
		} 
		public List<Admin> findAll() throws NoAdminsFoundException {
		List<Admin> list = ad.findAll();
		if (list.isEmpty())
		{
		throw new NoAdminsFoundException("No Admin found");
		}
		return list;
		}
		public Admin findByAdminId(long adminId) throws AdminsIdNotFoundException 
		{
		Optional<Admin> op = ad.findById(adminId);
		if (op.isPresent()) 
		{
		return op.get();
		} 
		else {
		throw new AdminsIdNotFoundException("Admin Not Found For adminId : " + adminId);
		}
		}
		public String updateAdmin(long adminId, Admin admins) throws AdminsIdNotFoundException 
		{
		if (adminId == admins.getAdminId()) 
		{
		Admin upAdmin = ad.save(admins);
		return "Updated Successfully for AdminId :" + upAdmin.getAdminId();
		}
		throw new AdminsIdNotFoundException("Admin Not Found For adminId :" + adminId);
		}
	
		
		public String deleteById(long adminId) throws AdminsIdNotFoundException {
			if (ad.existsById(adminId)) 
			{
			ad.deleteById(adminId);
			return "Deleted Successfully for AdminId :" + adminId;
			}
			throw new AdminsIdNotFoundException("Admin Not Found For adminId :" + adminId);
		}

}
