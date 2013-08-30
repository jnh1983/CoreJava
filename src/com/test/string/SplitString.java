package com.test.string;

public class SplitString {

	public static final String DESKTOP_FOLDER = "webservice";
	
	public static void main(String[] args) {
		//splitEntryNameWrapper();
		//splitArray();
//		 splitNextLineBreak();
		printSplitString();
	}
	
	public static void printSplitString(){
		String str = " ,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, # END GlobalSight Download File, null, null, null, # Encoding: , # Document Format: , # Placeholder Format: , # Source Locale: , # Target Locale: , # Page Name: , # Page ID: , # Workflow ID: , # Task ID: , # Exact Match word count: , # Fuzzy Match word count: , # No Match word count: , # Edit all:";
		String[] result = str.split(",");
		for(int i=0; i<result.length; i++){
			if(result[i]!=null && !"null".equals(result[i].trim()))
			System.out.println(i+":\t"+result[i]);
		}
	}
	public static void splitNextLineBreak(){
		String lineBreakStr = "\\n";
		String str = "Hello World.\\n Happy New Year.";
		System.out.println(str);
		String arr[] = str.split("\\\\n");
		printArr(arr);
	}
	
	public static void splitArray(){
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(",").append("a");
		strBuffer.append(",").append("b");
		strBuffer.append(",").append("c");
		System.out.println(strBuffer);
		
		String[] messageArguments = strBuffer.toString().substring(1).split(",");
		for(int i=0;i<messageArguments.length;i++){
			System.out.print("["+i+":"+messageArguments[i]+"]");
		}
		
	}	
	
	public static void splitEntryNameWrapper(){
		String[] entryNames = {	
				"fr_FR/jobName/webservice/b/c.txt",
				"fr_FR/jobName/webservice/c/c.txt"
		};
		String[] entryNames2 = {	
				"fr_FR/jobName/web/b/c.txt",
				"fr_FR/jobName/web/c/c.txt"
		};
		String jobName = "jobName";
		
		for(int i=0;i<entryNames.length;i++){
			String[] result = splitEntryName(entryNames[i], jobName);
			System.out.println(result[0]+"\t"+result[1]);
			//System.out.println(entryNames[i]);
		}
		
		for(int i=0;i<entryNames2.length;i++){
			String[] result = splitEntryName(entryNames2[i], jobName);
			System.out.println(result[0]+"\t"+result[1]);
		}
	}
	
	private static String[] splitEntryName(String entryName, String jobName)
    {
        String[] result = new String[2];

        String splitString = "/" + jobName + "/";
        int i = entryName.indexOf(splitString);
        String startPart = entryName.substring(0, i);
        String endPart = entryName.substring(i + splitString.length());

        String[] tokens = startPart.split("/");
        String locale = tokens[tokens.length - 1];
        if (DESKTOP_FOLDER.equals(locale))
        {
            locale = tokens[tokens.length - 2];
        }

        result[0] = locale;
        result[1] = endPart;

        return result;
    }
	
	public static void printArr(Object[] objs){
		for(int i=0;i<objs.length;i++){
			Object o = objs[i];
			System.out.println(i+":\t"+o.toString());
		}
	}

}
