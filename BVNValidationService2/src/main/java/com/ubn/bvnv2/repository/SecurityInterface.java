package com.ubn.bvnv2.repository;

import java.io.FileNotFoundException;

import com.nibss.bvn.validationv2.BVNValidation;
import com.nibss.bvn.validationv2.BVNValidationService;
import com.nibss.bvn.validationv2.Exception_Exception;
import com.nibss.bvn.validationv2.SearchResult;
import com.ubn.bvnv2.parameters.PBEncrytor;
import com.ubn.bvnv2.parameters.Settings;

import nfp.ssm.core.SSMLib;

public class SecurityInterface {

	PBEncrytor Pb = new PBEncrytor();
	String UpdatekeyLocationPublic = Settings.getPropertiesValue("UpdatekeyLocationPublic");
	String ValidationkeyLocationPublic = Settings.getPropertiesValue("ValidationkeyLocationPublic");
	String keyLocationPrivate = Settings.getPropertiesValue("keyLocationPrivate");
	String password = Pb.PBDecrypt(Settings.getPropertiesValue("password"));
	@SuppressWarnings("unused")
	private static final String OUTPUT_FILE = "C:\\BVN_link_update\\keys\\phototestFile.png";

	@SuppressWarnings("unused")
	public String validateBvn2(String bvn) throws FileNotFoundException {
		String encryptValueSingle = "";
		String encryptValueMultiple = "";
		String responseEn = "", decrypt = "";
		String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>" + bvn.trim()
				+ "</BVN></SearchRequest>";

		try {
			encryptValueSingle = validationencryptRequest(single);
			SearchResult retSingle = validateSingleBVN(encryptValueSingle);
			String encSingle = retSingle.getBvnSearchResult();
			decrypt = decryptRequest(encSingle);
		} catch (java.lang.Exception ex) {
		}
		return decrypt;
	}

	public String validationencryptRequest(final String dataToEncrypt) {
		SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);// unionbank_public.key

		return enc.encryptMessage(dataToEncrypt);
	}

	private static SearchResult validateSingleBVN(java.lang.String searchInput) throws Exception_Exception {
		BVNValidation service = new BVNValidation();
		BVNValidationService port = service.getBVNValidationPort();
		return port.validateSingleBVN(searchInput);
	}

	public String decryptRequest(final String dataToDecrypt) {
		SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);// unionbank_public.key
		return enc.decryptFile(dataToDecrypt, password);
	}
}
