package src;
// Filename: last01.java
// Name: Eduardo Olivares
public class ReverseTextOriginal {
    public static String reverseText(String s){
        String[] stringArr = s.split(" ");
        String reversedText = "";
        
        for (int i=0; i < stringArr.length; i++){ 
            reversedText = reversedText + reverseWord(stringArr[i]) + " ";
         }
         return reversedText; 
    }

    public static String reverseWord(String stringToReverse){
        String reversedString = "";
        for(int i=stringToReverse.length() -1; i >= 0; --i){
            reversedString += stringToReverse.charAt(i);
        }
        return reversedString;
    }
    public static void main(String[] args) { 
        String S = ""; 
        for (int i=0; i < args.length; i++){ 
           S = S + args[i] + " ";     
        } 
        System.out.print(reverseText(S)); 
  } 
}
