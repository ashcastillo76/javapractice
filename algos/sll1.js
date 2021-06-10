class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    // console log (print) the data of every node in the current list
    // traversal
    read() {

        var runner = this.head;

        while(runner != null) {
            console.log(runner.data);
            runner = runner.next;
        }

    }

    // find: return true / false if current list contains a data equal to value
    contains(value) {

        var runner = this.head;

        while(runner != null){
            if(runner.data == value) {
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
        this.head = newNode; // move the head to the new node
    }
}

// ⚠ don't forget to instantiate the Singly Linked List

const sll = new SLL();
sll.addToFront(new Node(10));
sll.addToFront(new Node(20));
sll.addToFront(new Node(30));
sll.addToFront(new Node(40));

sll.read();

console.log(sll.contains(20));
console.log(sll.contains(10));
console.log(sll.contains(4));
console.log(sll.contains(26));

sll.removeFromFront();

sll.read();