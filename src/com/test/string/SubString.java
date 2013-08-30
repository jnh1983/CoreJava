package com.test.string;

public class SubString {

    public static final String m_tag_start = "&lt;AAA&gt;";
    public static final String m_tag_end = "&lt;/AAA&gt;";

    public static void main(String[] args) {
	String fullPageName = "(sheet002) en_US\\aa\\Joey-Welocalize_company.xlsx";
	String sourceLocal = "en_US";
	int pos = fullPageName.indexOf(sourceLocal);

	/*
	 * System.out.println(fullPageName);
	 * 
	 * fullPageName = fullPageName.substring(pos);
	 * System.out.println(fullPageName);
	 */
	// getURL();

	getString("HelloWorld", "B");
	getString("HelloWorld", "A");

	String charStr = "_";
	String result = "translation_1000";
	System.out.println(getSubString(result, charStr));

	result = "translation_1000_asdfasf";
	System.out.println(getSubString(result, charStr));

	result = "translation";
	System.out.println(getSubString(result, charStr));
    }

    /**
     * Get the sub string before the special string
     * 
     * @param p_input
     *            input string
     * @param p_speStr
     *            special string
     * @return
     */
    public static String getSubString(String p_input, String p_speStr) {
	int index = p_input.indexOf(p_speStr);
	if (index > 0) {
	    p_input = p_input.substring(0, index);
	}

	return p_input;
    }

    public static String getURL() {
	String url = "http://localhost:8080/globalsight/ControlServlet";
	String result = url.substring(0, url.lastIndexOf("/") + 1);
	System.out.println(result);
	return result;
    }

    public static void getString(String p_str, String p_pos) {
	String text = p_str;
	if ("b".equalsIgnoreCase(p_pos)) {
	    text = m_tag_start + text;
	} else if ("a".equalsIgnoreCase(p_pos)) {
	    text = text + m_tag_end;
	}
	System.out.print(text + "\t");

	if (text.startsWith(m_tag_start)) {
	    text = text.substring(m_tag_start.length());
	} else if (text.endsWith(m_tag_end)) {
	    text = text.substring(0, text.length() - m_tag_end.length());
	}
	System.out.println(text + "\t");
    }

}
