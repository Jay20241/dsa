//Recursion - Permutations

public class Permutations{
    psvm(){
        permutations("", "abc");

        ArrayList<String> ans = permutations_return("", "abc");
        System.out.println(ans);
    }

    // p - processed
    // up - un-processed
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i, p.length());
            permutations(first + ch + second, up.substring(1));
        }
    }



    static ArrayList<String> permutations_return(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i, p.length());
            ans.addAll(permutations_return(first + ch + second, up.substring(1)));
        }
        return ans;
    }


    //Count the number of permutations
    static int count_permutations(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i, p.length());
            count = count + count_permutations(first + ch + second, up.substring(1));
        }
        return count;
    }
}