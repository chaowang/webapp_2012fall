package webapp.help.utility;

public class escape {
   public static String escapleHtml(String str){
		
		String escapeStr=new String();
		if(str.length()==0||str==null)
			return str;
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='&'){
				escapeStr+="&amp;";
				continue;
			}
			
			if(str.charAt(i)=='\"'){
				escapeStr+="&quot;";
				continue;
			}
			
			if(str.charAt(i)=='<'){
				escapeStr+="&lt;";
				continue;
			}
			
			if(str.charAt(i)=='>'){
				escapeStr+="&gt;";
				continue;
			}
			escapeStr+=str.charAt(i);
			
		}
		return escapeStr;
	}
}
