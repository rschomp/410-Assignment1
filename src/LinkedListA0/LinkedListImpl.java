/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedListA0;

public class LinkedListImpl implements LIST_Interface {
  Node root;//this will be the entry point to your linked list (the head)
  int size;
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    root=new Node(0); //Note that the root's data is not a true part of your data set!
    size = 0;
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return root;
  }

@Override
public boolean insert(Node n, int index) {
	if ((index < 0) || (size < index)){
		return false;
	}
	
	Node currentNode = root; 
	Node nextNode;
	int count = -1; 
	
	while ((currentNode.next != null) && (count<(index-1))) {
		currentNode = currentNode.next;
		count++;
	}
	
	n.prev = currentNode; //makes link to node before the one you are inserting
	nextNode = currentNode.next; //makes link between the two nodes that surround the node you want to insert
	n.next = nextNode; //makes link to node after the one you are inserting
	currentNode.next = n;
	
	if (n.next != null) {
		n.next.prev = n;
	}
	size++;
	return true;
}

@Override
public boolean remove(int index) {
	Node currentNode = root; 
	int count = -1;
	
	while ((count<index) && (currentNode.next != null)) {
		currentNode = currentNode.next;
		count++;
	}
	
	if ((index < 0) || (count+1 < index)){
		return false;
	}
	//we want to remove the current node
	if (currentNode.next != null) {
		(currentNode.next).prev = currentNode.prev;
	}
	
	(currentNode.prev).next = currentNode.next;
	size--;
	return true;
}

@Override
public Node get(int index) {
	Node currentNode = root;
	int count = -1;
	
	while (count<index) {
		currentNode = currentNode.next;
		count++;
	}
	return currentNode;
}

@Override
public int size() { //returning the size that i calculated throughout insert and remove 
	return size; 
}

@Override
public boolean isEmpty() {
	if (root.next == null) {
	return true;
	}
	return false;
}

@Override
public void clear() {
	root.next = null; 
	size = 0;
}
}