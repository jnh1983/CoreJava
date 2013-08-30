package com.test.string;

public class RegexString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RegexString test = new RegexString();
		test.replaceImgForFirefoxWrapper();
		
		String str = "abcdef";
		String str1 = str.replace("c", "PPP");
		System.out.println(str+"\n"+str1);

	}
	
	public void replaceImgForFirefoxWrapper(){
		String oldStr = "<v:path o:extrusionok=\"f\" gradientshapeok=\"t\" o:connecttype=\"rect\"/><o:lock v:ext=\"edit\" aspectratio=\"t\"/></v:shapetype>\n" +
				"<v:shape id=\"Picture_x0020_91\" o:spid=\"_x0000_i1025\" type=\"#_x0000_t75\" alt=\"http://forums.forzamotorsport.net/photos/community/images/3894069/original.aspx\" style='width:487.5pt;height:274.5pt;visibility:visible;mso-wrap-style:square'>\n" +
				"<v:imagedata src=\"1277782076859test_5_1_loc_files/image001.jpg\" o:title=\"original\"/>\n" +
				"</v:shape>\n" +
				"</span><span style='font-size:10.0pt;font-family:\"Calibri\",\"sans-serif\";mso-ascii-theme-font:minor-latin;mso-hansi-theme-font:minor-latin;mso-bidi-font-family:Calibri;mso-bidi-theme-font:minor-latin'><br>\n" +
				"Image by <b>OCTANEs 65</b> ";
		String newStr = replaceImgForFirefox(oldStr, false);
		System.out.println(oldStr+"\n");
		System.out.println(newStr+"\n");
	}
	
	public String replaceImgForFirefox(String p_html, boolean p_isIE){
		if(p_isIE){
			return p_html;
		}else{
			String result = p_html;
			String shapeTag1 = "<v:shape ";
			String shapeTag2 = "</v:shape>";
			String imgTag = "<v:imagedata ";
			
			if(p_html.contains(shapeTag1) && p_html.contains(shapeTag2) && p_html.contains(imgTag)){
				int shapePos1 = p_html.indexOf(shapeTag1);
				int shapePos2 = p_html.indexOf(shapeTag2)+shapeTag2.length();
				int imgPos = p_html.indexOf(imgTag,shapePos1);
				if((shapePos1<imgPos)&&(imgPos<shapePos2)){
					String str = p_html.substring(shapePos1, shapePos2);
					int imgPos2 = str.indexOf(imgTag,shapePos1);
					//int lastImgPos = str.lastIndexOf(imgTag);
					if(imgPos2==str.lastIndexOf(imgTag)){
						
						String attr1 = str.substring(shapeTag1.length(),str.indexOf(">"));
						String attr2 = str.substring(imgPos2+imgTag.length(),str.indexOf("/>",imgPos2));
						String repStr = "<img "+ attr1 + " " + attr2 + " />";
						result = p_html.replace(str, repStr);
					}
					
				}
			}			
			return result;
		}
	}
}
