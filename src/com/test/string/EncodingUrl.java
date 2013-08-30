package com.test.string;

import com.globalsight.ling.common.URLDecoder;
import com.globalsight.ling.common.URLEncoder;

public class EncodingUrl {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String url = "   abc=AaA&bbb='CCC   ";
	System.out.println(url);
	String result = URLEncoder.encode(url);
	System.out.println(result);
	System.out.println(URLDecoder.decode(result));

    }

}
