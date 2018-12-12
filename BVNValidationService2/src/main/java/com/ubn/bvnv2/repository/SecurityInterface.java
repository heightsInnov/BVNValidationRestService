package com.ubn.bvnv2.repository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;

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
		String OUTPUT_FILE = "C:\\Users\\aojinadu\\Documents\\workspace-sts\\BVNValidationService2\\src\\main\\resources\\static\\img\\Picture_" + bvn + ".png";

		OutputStream out = new FileOutputStream(OUTPUT_FILE);
		System.out.println("--Moved out of the Output File----");
		String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>" + bvn.trim()
				+ "</BVN></SearchRequest>";

		try {
			System.out.println("BVN<<>>>>>>>::::" + bvn.trim() + "<<>>");

			encryptValueSingle = validationencryptRequest(single);
			System.out.println("Clear Text Request Single::::: " + single);
			System.out.println("encryptedValueSingleBVN<<>>>>>>>::::" + encryptValueSingle);

			SearchResult retSingle = validateSingleBVN(encryptValueSingle);
			System.out.println("validateSingleBVN Result>>>>> " + validateSingleBVN(encryptValueSingle));

			DataHandler handlerSingle = retSingle.getBinaryImage();

			// Some bvns have no image currently
			if (handlerSingle != null) {
				System.out.println("Content Type of Single Validation Image >> " + handlerSingle.getContentType());
				System.out.println("Input Stream for Single Validation >> " + handlerSingle.getInputStream());

				InputStream in = handlerSingle.getInputStream();

				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.close();
				in.close();
			}

			String encSingle = retSingle.getBvnSearchResult();
			System.out.println(
					"Encrypted response for Single Validation(retSingle.getBvnSearchResult()) >> " + encSingle);
			decrypt = decryptRequest(encSingle);
			System.out.println("Decrypted Xml for Single Validation >> " + decrypt);

		} catch (java.lang.Exception ex) {
		}

		return decrypt;
	}

	public String validationencryptRequest(final String dataToEncrypt) {
		System.out.println("dataToEncrypt<<>>>" + dataToEncrypt);
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
