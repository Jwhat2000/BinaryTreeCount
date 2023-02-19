// Program that creates the functions to count the number of nodes, count the 
// number of leaves, count the number of right children, find the height and 
// delete all the leaves of a binary tree.

import java.util.*;

// The Class of the Node for the tree
class Node{
	private int info; // variable to hold information of the node
	
	private Node left,right; //variable for the left and right child
	
	// Constructor to create node within the binary tree
	public Node (int info) {
		this.info = info;
		this.left = null;
		this.right = null;
	}
	
	// Function to set info
	public void setInfo (int info) {
		this.info = info;
	}
	
	// Function to return info
	public int getInfo() {
		return info;
	}
		
	// Function to get left node
	public void setLeft(Node left) {
		this.left = left;
	}
	
	// Function to get left node	
	public Node getLeft() {
		return left;
	}
		
	// Function to set right node
	public void setRight (Node right) {
		this.right = right;
	}
	
	// Function to get right node
	public Node getRight() {
		return right;
	}		
}
	
// Class of the binary tree
class BinTree {
	private Node root;
		
	// Default constructor 
	public BinTree() {
		root = null;
	}

	// Function to set root node
	public void setRoot(Node root) {
		this.root = root;
	}
	
	// Function to get root node
	public Node getRoot() {
		return root;
	}
		
	// Recursive function to count the number of nodes is the binary tree
	public int countNumOfNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		return countNumOfNodes(node.getLeft()) + countNumOfNodes(node.getRight()) + 1;
	}
		
	// Recursive function to count the number of leaves in the binary tree
	public int countNumOfLeaves(Node node) {
		if(node == null) {
			return 0;
		}
		else if(node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		
		return countNumOfLeaves(node.getLeft()) + countNumOfLeaves(node.getRight());
	}
		
	// Recursive function to count the number of the right children in the binary tree
	public int countNumOfRightChildren(Node node) {
		int left = 0,right = 0;
		if(node == null) {
			return 0;
		}
		
		if(node.getRight() != null) {
			right = countNumOfRightChildren(node.getRight()) + 1;
		}
		
		if(node.getLeft() != null) {
			left = countNumOfRightChildren(node.getLeft());
		}
		
		return left + right;
	}
		
	// Recursive function to calculate the height of the binary tree
	public int height(Node node) {
		if(node == null) {
			return 0;
		}
			
		return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
	}
		
	// Recursive function to delete all the leaves node in the binary tree
	public Node deleteLeaves(Node node) {
		// If the node is null then returns the null
		if(node == null) {
			return node;
		}
			
		// If the left and right node are null then returns the null
		if(node.getLeft() == null && node.getRight() == null) {	
			return null;
		}
			
		// sets the left node
		node.setLeft(deleteLeaves(node.getLeft()));
			
		// sets the right node 
		node.setRight(deleteLeaves(node.getRight()));
			
		return node;
	}
		
		// Recursive function for the inOrder traversal of the binary tree
		public void inOrderBinTree(Node node) {
			if(node != null) {
				inOrderBinTree(node.getLeft());
				System.out.print(node.getInfo() + " ");
				inOrderBinTree(node.getRight());
			}
		}
}

public class Project11 {
	
	public static void main(String[] args) {
		BinTree tree = new BinTree();
		tree.setRoot(new Node(10));
		tree.getRoot().setLeft(new Node(20));
		tree.getRoot().setRight(new Node(30));
		tree.getRoot().getLeft().setLeft(new Node(40));
		tree.getRoot().getRight().setRight(new Node(50));
		
		// Display the results
		System.out.print("The nodes in binary tree: ");
		tree.inOrderBinTree(tree.getRoot());
		System.out.println();
		System.out.println("Count of Nodes: " + tree.countNumOfNodes(tree.getRoot()));
		System.out.println("Count of Leaves: " + tree.countNumOfLeaves(tree.getRoot()));
		System.out.println("Count of Right Children: " + tree.countNumOfRightChildren(tree.getRoot()));
		System.out.println("Height of the Tree: " + tree.height(tree.getRoot()));
		tree.setRoot(tree.deleteLeaves(tree.getRoot()));
		System.out.print("InOrder traversal of the Binary Tree: ");
		tree.inOrderBinTree(tree.getRoot());
		System.out.println();

	}

}
