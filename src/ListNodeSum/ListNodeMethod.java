package ListNodeSum;

public class ListNodeMethod {
    public ListNode createLinkNoeByArray(int[] arr){
        ListNode ln = null;
        ListNode ln1 = null;
        ListNode temp = null;
        for(int i = 0; i < arr.length; i++){
            temp = new ListNode(arr[i]);
            if(ln1 == null){
                ln1 = temp;
                ln = ln1;
            }
            else {
                ln1.next = temp;
                ln1 = ln1.next;
            }

        }
        return ln;
    }
    public void readList(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ys = 0,l1num = 0,l2num = 0;
        ListNode ln=null;
        ListNode ln1=null;
        ListNode temp = null;
        while(l1 != null || l2 != null){
            if(l1 != null){
                l1num = l1.val;
            }
            if(l2 != null){
                l2num = l2.val;
            }
            temp = new ListNode((l1num+l2num+ys)%10);
            ys = (l1num+l2num+ys)/10;
            if(ln1 == null){
                ln = ln1 = temp;
            }
            else{
                ln1.next = temp;
                ln1 = ln1.next;
            }

            l1num = 0;
            l2num = 0;
             if(l1 != null)
            l1 = l1.next;
            if(l2 != null)
            l2 = l2.next;
        }
        if(ys != 0){
            temp = new ListNode(ys);
            ln1.next = temp;
        }
        return ln;
    }
}
