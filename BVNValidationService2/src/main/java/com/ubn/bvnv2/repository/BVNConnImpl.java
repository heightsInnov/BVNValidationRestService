package com.ubn.bvnv2.repository;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ubn.bvnv2.model.CustomerDetails;

@Repository(value = "BVNConn")
public class BVNConnImpl implements BVNConn {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	SecurityInterface sd = new SecurityInterface();

	public String getNodeValue(String nodeElementPath, String message) {
		String nodeValue = "";
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = null;
			builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(new ByteArrayInputStream(message.getBytes()));
			builder = builderFactory.newDocumentBuilder();
			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList nodeList = (NodeList) xPath.compile(nodeElementPath).evaluate(xmlDocument, XPathConstants.NODESET);
			Node nod = nodeList.item(0);
			if (nod != null && nod.getNodeType() == 1) {
				nodeValue = nod.getFirstChild() != null ? nod.getFirstChild().getNodeValue() : "";
			}
		} catch (Exception ex) {
			logger.error("Error encountrered in "+ ex.getStackTrace().getClass().getEnclosingMethod().getName(), ex);
			System.out.println("Error encountrered in "+ ex.getStackTrace().getClass().getEnclosingMethod().getName());
		}
		return nodeValue;
	}

	@Override
	public CustomerDetails getBVNdetails(String BvnNumber) throws Exception {
		CustomerDetails mert = new CustomerDetails();

		String vbnResponse = "";

		try {

			vbnResponse = sd.validateBvn2(BvnNumber);
			
			logger.info("XML Response >>> "+vbnResponse);
			
			mert.setTitle(getNodeValue("/BVNSearchResult/Title", vbnResponse));
			mert.setWatchListed(getNodeValue("/BVNSearchResult/WatchListed", vbnResponse));
			mert.setFirstName(getNodeValue("/BVNSearchResult/FirstName", vbnResponse));
			mert.setMiddleName(getNodeValue("/BVNSearchResult/MiddleName", vbnResponse));
			mert.setLastName(getNodeValue("/BVNSearchResult/LastName", vbnResponse));
			mert.setDateOfBirth(getNodeValue("/BVNSearchResult/DateOfBirth", vbnResponse));
			mert.setPhoneNumber(getNodeValue("/BVNSearchResult/PhoneNumber1", vbnResponse));
			mert.setBankEnroll(getNodeValue("/BVNSearchResult/EnrollmentBank", vbnResponse));
			mert.setBranchEnroll(getNodeValue("/BVNSearchResult/EnrollmentBranch", vbnResponse));
			mert.setEmail(getNodeValue("/BVNSearchResult/Email", vbnResponse));
			mert.setMaritalStatus(getNodeValue("/BVNSearchResult/MaritalStatus", vbnResponse));
			mert.setGender(getNodeValue("/BVNSearchResult/Gender", vbnResponse));
			mert.setStateOfOrigin(getNodeValue("/BVNSearchResult/StateOfOrigin", vbnResponse));
			mert.setResidentialAdd(getNodeValue("/BVNSearchResult/ResidentialAddress", vbnResponse));
			mert.setLga(getNodeValue("/BVNSearchResult/LgaOfOrigin", vbnResponse));
			//String imageNow = getNodeValue("/BVNSearchResult/ImageHashValue", vbnResponse);
			mert.setResponseCode(getNodeValue("/BVNSearchResult/ResponseCode", vbnResponse));

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error encountrered in "+ e.getStackTrace().getClass().getEnclosingMethod().getName(), e);
		}
		return mert;
	}

}
