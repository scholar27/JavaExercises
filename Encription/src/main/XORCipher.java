package main;

//Eileen Andert
//Bei diesem Programm habe ich mich ebenfalls nachdem ich es selbstständig erarbeitet hatte, mit Line Abele gemeinsam über die jeweiligen Fehler ausgetauscht, die bei uns aufgetreten sind,
//da man beim eigenen Code irgendwann "blind" wird und auch kleine Fehler schwer zu finden werden :)

public class XORCipher {
    
    //
    // This table contains 64 possible chars that are
    // used as alphabet for this encryption exercise.
    // We can use 6 bits (e.g. the most right 6 bits of an
    // int value) to uniquely encode a character.
    //
    public static char[] CHAR_TABLE = {
        ' ', '\n', ',', '.', '\'', '-', ':', ';', '?', '(', ')', '!',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'
    };
    
    // ----------------------------------------------------------------
    // Exercise 2 (a)
    // ----------------------------------------------------------------

    public static char valueToChar(int code) {
    	
    	if(code < 0 || code > 63) {
    		return ' ';
    	}
    	
    	char result = CHAR_TABLE[code];
    	return result;
    }
    
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (b) 
    // ----------------------------------------------------------------
    
    public static int charToValue(char chr) {
    	
    	for(int i = 0; i < CHAR_TABLE.length; i++) {
    		
    		if(chr == CHAR_TABLE[i]) {
    			return i;
    		}		
    	}
    	return 0;
    }
    
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (c)
    // ----------------------------------------------------------------
    
   public static int[] stringToValues(String str) {
	     
	   
	   int[] result = new int[str.length()];
	   
	   int[] empty = {};
	   
	   if(str == "") {
		   return empty;
	   }
	   
	   for(int i = 0; i < str.length(); i++) {

		  char c = str.charAt(i);
		   
		  int index = charToValue(c);
		  
		  result[i] = index;
	   }
	   
	   return result;
	   
   }
   

    // ----------------------------------------------------------------
    // Exercise 2 (d)
    // ----------------------------------------------------------------
    
    public static String valuesToString(int[] code) {
    	
    	String str = "";
    	
    	if(code == null) {
    		return str;
    	}
    	
    	for(int i = 0; i < code.length; i++) {
    		
    		char c = valueToChar(code[i]);
    		
    		str += c;
    		
    	}
    	
    	return str;
    	
    }
    
    
    
    // ----------------------------------------------------------------
    // Exercise 2 (e)
    // ----------------------------------------------------------------
    	public static int[] encryptDecrypt(int[] msg, int[] key) {
    		
    		if(msg == null || key == null) {
    			return msg;
    		}
    		
    		int[] result = new int[msg.length];
    		
    		for(int i = 0, j = 0; i < msg.length; i++, j++) {
    			
    			int k = key.length;
    			if(i >= k) {
    				j = i % k;
    			}
    			
    			result [i] = msg[i] ^ key[j];
	
    		}
    		
    		return result;
    	}
    


    
    // ----------------------------------------------------------------
    // Exercise 2 (f)
    // ----------------------------------------------------------------
    
    	public static String encryptDecrypt (String msg, String key) {
    		
    		int [] msgArray = stringToValues(msg);
    		int[] keyArray = stringToValues(key);
    		
    		int[] crypt = encryptDecrypt(msgArray, keyArray);
    		
    		String result = valuesToString(crypt);
    		
    		return result;
    		
    		
    		
    	}
        
    
  
    
    // ----------------------------------------------------------------
    
    public static void main(String[] args) {
        final String msg = "Dieser Text ist sehr geheim...";
        final String key = "keyword";
        
        final String cipher = encryptDecrypt(msg, key);
        final String decrypted = encryptDecrypt(cipher, key);
        
        //
        // Wenn alles richtig implementiert wurde, sollte
        // der String decrypted wieder genau dem String 
        // msg entsprechen, waehrend der String cipher fuer
        // uns nicht lesbar ist.
        //
        
        System.out.println(msg);
        System.out.println(cipher);
        System.out.println(decrypted);

        
    }
}