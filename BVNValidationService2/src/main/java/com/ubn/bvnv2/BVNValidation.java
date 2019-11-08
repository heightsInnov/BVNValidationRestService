package com.ubn.bvnv2;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public @ResponseBody CustomerDetails Verify(HttpServletRequest req, @RequestBody BVNNumber BvnNumber) {
		SaveInfo(req);
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
	public @ResponseBody CustomerDetails VerifyOF(HttpServletRequest req, @RequestBody BVNNumber BvnNumber) {
		SaveInfo(req);
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
	
	@GetMapping("/verifyBVN/{bvn}")
	public @ResponseBody CustomerDetails verify(HttpServletRequest req, @PathVariable("bvn") String bvn) {
		SaveInfo(req);
		logger.info("BVN Service Starts Now***********");
		customer = new CustomerDetails();
		BVNNumber bvnnum = new BVNNumber();
		bvnnum.setBvn(bvn);
		try {
			customer = serv.getBVNdetails(bvnnum);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Error encountrered in "+ e.getStackTrace().getClass().getEnclosingMethod().getName(), e);
		}
		return customer;
	}
	
	@GetMapping(value="/verifyBVN/{bvn}",consumes= {"application/xml"}, produces= {"application/xml"})
	public @ResponseBody CustomerDetails VerifyOF(HttpServletRequest req, @PathVariable("bvn") String bvn) {
		SaveInfo(req);
		logger.info("BVN Service Starts Now***********");
		customer = new CustomerDetails();
		BVNNumber bvnnum = new BVNNumber();
		bvnnum.setBvn(bvn);
		try {
			customer = serv.getBVNdetails(bvnnum);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Error encountrered in "+ e.getStackTrace().getClass().getEnclosingMethod().getName(), e);
		}
		return customer;
	}
	
	private void SaveInfo(HttpServletRequest req) {
		logger.info("********** In SaveInfo method *********");
		String remoteAddress = "0.0.0.0";
		if (req != null) {
			remoteAddress = req.getHeader("X-FOWARDED-FOR") != null ? req.getHeader("X-FOWARDED-FOR")
					: req.getRemoteAddr();
			logger.info("Tracked IP Address " + remoteAddress);
		}
		logger.info("verifyBVN accessed by " + remoteAddress + "on "+ new Date());
	}
}
