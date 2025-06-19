public class Tut32{
    psvm(){
        skipA("", "baccad")
    }

    static void skipA(String ans, String str){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.chatAt(0);

        if(ch=='a'){
            skipA(ans, str.substring(1));
        }else{
            skipA(ans + ch,str.substring(1));
        }
    }

    static String skipA(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.chatAt(0);

        if(ch=='a'){
            return skipA(str.substring(1));
        }else{
            return ch + skipA(str.substring(1));
        }
    }


    //Remove string "apple" from whole string
    static String skipApple(String str){
        if(str.isEmpty()){
            return "";
        }


        if(str.startsWith("apple")){
            return skipApple(str.substring(5)); //Remember "apple" length here. => 5
        }else{
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }


    //Skip the "app", not "apple"
    static String skipApp_NotApple(String str){
        if(str.isEmpty()){
            return "";
        }


        if( str.startsWith("app") && !str.startsWith("apple") ){
            return skipApp_NotApple(str.substring(3)); //Remember "app" length here. => 3
        }else{
            return str.charAt(0) + skipApp_NotApple(str.substring(1));
        }
    }
}