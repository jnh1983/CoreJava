package com.test;

public class TestStringLen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestStringLen test = new TestStringLen();

		String xmlExportOptions = "<exportOptions><fileOptions>" +
				"<fileName>tm_export_10.xml</fileName><fileType>xml</fileType>" +
				"<fileEncoding>UTF-8</fileEncoding><entryCount>361</entryCount>" +
				"<status>analyzed</status><errorMessage></errorMessage>" +
				"</fileOptions><selectOptions><selectMode>all</selectMode>" +
				"<selectFilter></selectFilter><selectLanguage>en_US</selectLanguage>" +
				"<selectPropType></selectPropType></selectOptions>" +
				"<filterOptions><createdby></createdby><modifiedby></modifiedby>" +
				"<createdafter></createdafter><createdbefore></createdbefore>" +
				"<modifiedafter></modifiedafter><modifiedbefore></modifiedbefore>" +
				"<status></status><domain></domain><project></project><conditions></conditions></filterOptions><outputOptions><systemFields>true</systemFields></outputOptions></exportOptions>";

		System.out.println(xmlExportOptions.length());
		int i=5;
		StringBuffer strB = new StringBuffer("abcdef");
		//strB.insert(2, "H");System.out.println(strB);
		//System.out.println("\"+\r\n\"".length());
		System.out.println(test.stringInsert(strB.toString(),4));
		System.out.println(test.stringInsert(xmlExportOptions,500));
	}

	public String stringInsert(String str, int splitLen){
		if(str.length()<splitLen)
			return str;
		else{
			StringBuffer result = new StringBuffer(str);
			String splitStr = "\"+\r\n\"";
			for(int i=splitLen,len=result.length();(i<len&&i>0);){
				result.insert(i, splitStr);
				i=i+splitLen+splitStr.length();
				len=result.length();
			}
			return result.toString();
		}
	}
}
