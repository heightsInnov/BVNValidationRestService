package com.ubn.bvnv2.service;

import com.ubn.bvnv2.model.BVNNumber;
import com.ubn.bvnv2.model.CustomerDetails;

public interface BVNService {

	public CustomerDetails getBVNdetails(BVNNumber BvNumber);
}
