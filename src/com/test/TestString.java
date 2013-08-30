package com.test;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestString test = new TestString();
		String str;
		//test.regTest();
		//test.regTest2();
		
		/*str = "\"rapport d\"\"infraction\"";
		test.csvDeleteQuota(str);
		str = "\"\"\"abc\"\"\"";
		test.csvDeleteQuota(str);*/
		
		str = "rap'port d'infraction";
		test.replaceSingleComma(str);
		
		String[] arr = {"a","b"};
		System.out.println(arr.toString());
		
	}

	public String replaceSingleComma(String str){
		String result = str.replace("'", "\\'");
		System.out.println(result);
		return result;
	}
	
	public String csvDeleteQuota(String str){
		System.out.println(str);
		if(str.startsWith("\"")&&str.endsWith("\"")){
			str = (String) str.subSequence(1, str.length()-1);
			//System.out.println(str);
			str = str.replace("\"\"", "\"");
			//System.out.println(str);
		}
		System.out.println(str);
		return str.trim();
	}
	
	public void regTest() {
		
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<jobInfoParamXml>\r\n    "
				+ "<category id=\"jobinfo.jobid\" label=\"Job Id\">\r\n    "
				+ "</category>";

		System.out.println("xmlStr:\n" + xmlStr);
		String regStr = ">\r\n *<";//"*>\r\n *<$";// "^>\n\s<$";
		String str = xmlStr.replaceAll(regStr, "><");
		System.out.println("xmlStr(Delete\\r\\n):\n" + str);
	}

	public void regTest2() {
		
		String xmlStr = "123abcccc   d456";

		System.out.println("Before:\t" + xmlStr);
		String regStr = "abc* *";// "^>\n\s<$";
		String str = xmlStr.replaceAll(regStr, "");
		System.out.println("After:\t" + str);
	}
}
