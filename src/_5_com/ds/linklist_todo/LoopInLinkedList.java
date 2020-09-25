package _5_com.ds.linklist_todo;

public class LoopInLinkedList {

	   
	    private static class Node {
	        int data;
	        Node next;
	        public Node(int data){
	            this.data= data;
	        }
	    }
	    
	    class Result { 
	        int startOfLoop =0;
	        boolean hasloop =false;
	        int lengthOfLoop =0;   
	    }
	    
	   private Result findLoopDetails(Node head){
	       if (head==null || head.next==null) return new Result();
	       
	       Result result  = new Result();
	       Node slowptr= head;
	       Node fastptr = head.next;
	       //Finds loop
	       while (fastptr!=null&& fastptr.next!=null){
	           if(slowptr==fastptr){
	             result.hasloop=true;
	             break;  
	           }
	           slowptr=slowptr.next;
	           fastptr=fastptr.next.next;     
	       }    
	       if (!result.hasloop) {
	           return result;
	       }  
	       Node meetingPoint=slowptr;  
	        //Finds length of the loop
	       fastptr=fastptr.next;
	       int length=1;
	       while(slowptr!=fastptr){
	           length++;
	           fastptr=fastptr.next;
	       }
	       
	       result.lengthOfLoop=length;

	       slowptr=meetingPoint;
	      //TODO fastptr moves to the start
	       fastptr=head;
	       int start=1;
	       //TODO logic for start of loop slowptr.next!=fastptr
	       while (slowptr.next!=fastptr) {
	           start++;
	           fastptr= fastptr.next;
	           slowptr=slowptr.next;
	       }
	       
	       result.startOfLoop =start;
	       
	       return result;
	       
	   }
	   
	       
	     
	    public static void main(String[] args) {

	        LoopInLinkedList solution = new LoopInLinkedList();
	        Node node = new Node(1);
	        node.next=new Node(2);
	        node.next.next=new Node(3);
	        Node node4= node.next.next.next=new Node(4);
	        node.next.next.next.next=new Node(5);
	        node.next.next.next.next.next=new Node(6);
	        node.next.next.next.next.next.next=new Node(7);
	        node.next.next.next.next.next.next.next=new Node(8);
	        node.next.next.next.next.next.next.next=node4;
	        
	        Result result= solution.findLoopDetails(node);
	        System.out.println("Has loop " +result.hasloop +" size of loop"+ result.lengthOfLoop + " start "+result.startOfLoop);
	        
	        
	        

	    }
	}


