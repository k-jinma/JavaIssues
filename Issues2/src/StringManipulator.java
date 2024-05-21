public class StringManipulator {

    public int countStringLenght(String str){
        return str.length();
    }

    public String reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    
    public boolean isKaibun(String str){
        if( str.equals( reverseString(str)) ) {
            return true;
        } else {
            return false;
        }
    }
}
