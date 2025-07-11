//17. Letter Combinations of a Phone Number


public class Phone_Dice{
    psvm(){
       pad("","12");
    }

    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        // a + 1 = b, due to ascii value
        int digit = up.charAt(0) - '0'; //this will convert '2' to 2
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char)('a' + i);
            pad(p + ch, up.substring(1));
        }
    }


    static ArrayList<String> pad_return(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        // a + 1 = b, due to ascii value
        int digit = up.charAt(0) - '0'; //this will convert '2' to 2

        ArrayList<String> list = new ArrayList<>();

        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char)('a' + i);
            list.addAll(pad_return(p + ch, up.substring(1)));
        }
        return list;
    }

    static int padCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0'; 
        for(int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char)('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }
        return count;
    }


    // Q. Number of Dice Rolls with Target Sum
    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        
        for(int i = 1; i <= 6 && i<=target ; i++){
            dice(p + i, target - i);
        }
    }


    static ArrayList<String> dice_return(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 1; i <= 6 && i<=target ; i++){
            list.addAll(dice_return(p + i, target - i));
        }
        return list;
    }


    static void dice_Faces(String p, int target, int face){
        if(target == 0){
            System.out.println(p);
            return;
        }
        
        for(int i = 1; i <= face && i <= target ; i++){
            dice_Faces(p + i, target - i, face);
        }
    }
}