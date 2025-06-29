// LeetCode - 83

public void removeDuplicates(){
    
    Node node = head;
    while(node.next != null){
        if(node.value == node.next.value){
            node.next = node.next.next;
            size--;
        }
        else{
            node = node.next;
        }
    }
    tail = node;
    tail.next = null;
}

// LeetCode - 21

public static LL merge(LL first, LL second){
    Node f = first.head;
    Node s = second.head;

    LL ans = new LL();
    while (f!=null && s!=null){
        if(f.value <= s.value){
            ans.insertLast(f.value);
            f = f.next;
        }else{
            ans.insertLast(s.value);
            s = s.next;
        }
    }

    while(f!=null){
        ans.insertLast(f.value);
        f = f.next;
    }
    while(s!=null){
        ans.insertLast(s.value);
        s = s.next;
    }

    return ans;
}
