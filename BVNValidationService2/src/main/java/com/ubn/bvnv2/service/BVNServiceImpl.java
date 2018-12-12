package com.ubn.bvnv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubn.bvnv2.model.BVNNumber;
import com.ubn.bvnv2.model.CustomerDetails;
import com.ubn.bvnv2.repository.BVNConn;

@Service(value="BVNService")
public class BVNServiceImpl implements BVNService {

	@Autowired
	BVNConn conn;

	@Override
	public CustomerDetails getBVNdetails(BVNNumber BvNumber){
		CustomerDetails response = new CustomerDetails();
		try {
			response = conn.getBVNdetails(BvNumber.getBvn());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
}
