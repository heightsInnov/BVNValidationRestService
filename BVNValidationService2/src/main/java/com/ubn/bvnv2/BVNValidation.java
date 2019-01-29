package com.ubn.bvnv2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubn.bvnv2.model.BVNNumber;
import com.ubn.bvnv2.model.CustomerDetails;
import com.ubn.bvnv2.service.BVNService;

@RestController
public class BVNValidation {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BVNService serv;
	
	CustomerDetails customer;
	
	@PostMapping(value="/verifyBVN")
	public @ResponseBody CustomerDetails Verify(@RequestBody BVNNumber BvnNumber) {
		logger.info("BVN Service Starts Now***********");
		customer = new CustomerDetails();
		try {
			customer = serv.getBVNdetails(BvnNumber);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Error encountrered in "+ e.getStackTrace().getClass().getEnclosingMethod().getName(), e);
		}
		return customer;
	}
	
	@PostMapping(value="/verifyBVN",consumes= {"application/xml"}, produces= {"application/xml"})
	public @ResponseBody CustomerDetails VerifyOF(@RequestBody BVNNumber BvnNumber) {
		logger.info("BVN Service Starts Now***********");
		customer = new CustomerDetails();
		try {
			customer = serv.getBVNdetails(BvnNumber);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Error encountrered in "+ e.getStackTrace().getClass().getEnclosingMethod().getName(), e);
		}
		return customer;
	}
}
