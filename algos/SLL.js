class Node{
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SLL{
    constructor(){
        this.head = null;
    }

    isEmpty(){
        if (this.head) {
            return true;
        } else {
            return false;
        }
    }
    
    // when a pointer is to the LEFT of an equal sign, we are CHANGING it
    // when a pointer is to the RIGHT of an equal sign, we are READING it

    // add given node to the head, if it exists. return void
    // list is empty?
    // list already has nodes?
    addToFront(node) {
        node.next = this.head;   //sets the new node's next to the head
        this.head = node; //the head is now the new node
        }
    

    // create a new node with given data, add it to the head. return void
    addDataToFront(value) {
        var newNode = new Node(value);
        newNode.next= this.head;
        this.head = newNode;
        // this.addToFront(new Node(value));
    }


    
        // console log (print) the data of every node in the current list
        // traversal
        read() {
    
            var runner = this.head;
    
            while(runner.next != null) {
                console.log(runner.data);
                runner = runner.next;
            }
    
        }
    
        // find: return true / false if current list contains a data equal to value
        contains(value) {
    
            var runner = this.head;
    
            while(runner.next != null){
                if(runner.value == value) {
                    return true;
                }
                runner = runner.next;
            }
            return false;
        }
    
        // Remove from front: remove and return the first node in the SLL
        removeFromFront() {
    
            var temp = this.head;
            this.head = this.head.next;
    
            return temp;
    
        }
    
        // -------------------------------------------
        // return true or false if this.head is null
        isEmpty() {
            return this.head == null;
        }
    
        // add given node to the head, if it exists. return void
        addToFront(node) {
            node.next = this.head; // set the new node's next to the head
            this.head = node; // move the head to the new node
        }
    
        // when a pointer is to the LEFT of an equal sign, we are CHANGING it
        // when a pointer is to the RIGHT of an equal sign, we are READING it
    
        // create a new node with given data, add it to the head. return void
        addDataToFront(data) { // 10
            var newNode = new Node(data); // create a new node with the data
            newNode.next = this.head; // set the new node's next to the head
            this.head = node; // move the head to the new node
        }
    }
    
    // ⚠ don't forget to instantiate the Singly Linked List
    SLL.read();
    
    





