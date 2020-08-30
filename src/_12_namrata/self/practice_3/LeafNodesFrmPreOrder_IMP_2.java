package _12_namrata.self.practice_3;

//Stack based Java program to print leaf nodes from preorder traversal. 

import java.util.Stack;

public class LeafNodesFrmPreOrder_IMP_2 { 

//Print the leaf node from the given preorder of BST. 
static void leafNode(int preorder[], int n) 
{ 
	Stack<Integer> s = new Stack<Integer> (); 
	for (int i = 0, j = 1; j < n; i++, j++) 
	{ 
		boolean found = false; 

		// If j-th element is less than i-th element then push it on stack
		if (preorder[i] > preorder[j]) 
			s.push(preorder[i]); 

		else
		{ 
			while (!s.isEmpty()) 
			{ 
				if (preorder[j] > s.peek()) 
				{ 
					s.pop(); 
					found = true; 
				} 
				else
					break; 
			} 
		} 

		if (found) 
			System.out.print(preorder[i] + " "); 
	} 

	// Since rightmost element is always leaf node. 
	System.out.println(preorder[n - 1]); 
} 

public static void main(String[] args) 
{ 
	//int preorder[] = { 890, 325, 290, 530, 965 }; 
	int preorder[] = { 40, 25, 20, 35, 80, 100 };
	int n = preorder.length; 

	leafNode(preorder, n); 
} 
} 

