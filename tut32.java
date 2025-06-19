public class Tut32{
    psvm(){
        skipA("", "baccad");

        subseq("", "abc");

        //print ascii value of char
        char ch = 'a';
        System.out.println(ch+0); //97
        System.out.println((char)(ch+0)); //a

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

    static String skipA_return(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.chatAt(0);

        if(ch=='a'){
            return skipA_return(str.substring(1));
        }else{
            return ch + skipA_return(str.substring(1));
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

    // Subsequence is for String 
    // Subset is for Arrays

    // p - processed = answer
    // up - unprocessed = original str
    //String is immutable. => Many reference variables pointing to same obj.
    static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }



    //Return all subseq in arraylist
    static ArrayList<String> subseq_return(String p, String up){
        if(up.isEmpty()){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> with = subseq_return(p + ch, up.substring(1));
        ArrayList<String> without = subseq_return(p, up.substring(1));

        with.addAll(without);
        return with;
    }

    //print ascii value
    /**
     * 3 choices - Take char, Take Ascii value, Ignore
    */
   static void subseq_ascii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq_ascii(p + ch, up.substring(1));
        subseq_ascii(p, up.substring(1));
        subseq_ascii(p + (ch+0), up.substring(1)); //ascii
    }

    static ArrayList<String> subseq_ascii_return(String p, String up){
        if(up.isEmpty()){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> with = subseq_ascii_return(p + ch, up.substring(1));
        ArrayList<String> without = subseq_ascii_return(p, up.substring(1));
        ArrayList<String> ascii = subseq_ascii_return(p + (ch+0), up.substring(1)); //ascii

        with.addAll(without);
        with.addAll(ascii);
        return with;
    }


    // Iterative program to print subsequences
    static List<List<Integer>> subset(int[] arr){ // Time - O( N * 2^N ) - Space
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i)); //copy of existing list
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }


    //subsequences of a string with duplicate elements
    //The below algo will only work when duplicates are together => So sort the array first.

    static List<List<Integer>> subset_duplicate(int[] arr){ // Time - O( N * 2^N ) - Space
        Arrays.sort(arr); //it will update the original array.
        
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++){
            start = 0;
            
            if(i > 0 && arr[i] == arr[i-1]){
                start = end + 1;
            }

            end = outer.size() - 1;
            int n = outer.size();
            
            for(int j = start; j < n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j)); //copy of existing list
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}