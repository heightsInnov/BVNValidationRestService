package com.ubn.bvnv2.repository;

import com.ubn.bvnv2.model.CustomerDetails;

public interface BVNConn {
	public CustomerDetails getBVNdetails(String BvnNumber)throws Exception;
}
