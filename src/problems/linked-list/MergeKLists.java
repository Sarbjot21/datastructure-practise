/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
class Solution {
     public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0)
                return null;
        ListNode head = null,tail = null;
        int noOfLists = lists.size();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
        new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return (a.val - b.val);
            }
        });
        
        for(int i = 0;i<noOfLists;i++){
            ListNode val = lists.get(i);
            if(val != null)
                queue.add(val);
        }
        
        while(!queue.isEmpty()){
            ListNode node = queue.remove();
            if(node.next != null)
                queue.add(node.next);
            if(head == null){
                head = node;
                tail = node;
            }
            else{
                tail.next = node; 
                tail = node;
            }
        }
        
        
        return head;
    }
}
