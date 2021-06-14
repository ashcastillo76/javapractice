
class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

// slStack must be implemented using Nodes and pointers
class slStack {
    constructor() {
        this.top = null; // this.head, this.end
    }

    // add to top
    push(newNode) {
        var newNode = new Node(data); // create a new node with the data
        newNode.next = this.top; // set the new node's next to the head
        this.top = newNode;
    }

    // remove from top
    pop() {
        if(this.isEmpty()) return null;

        top = peek();
        top = this.pop();
    }

    // aka check top
    peek() {
        return this.top;
    }

    // check if empty
    isEmpty() {
        return this.top === null;
    }
}

// bonus challenge: countStack

// write the standalone function countStack
// given a slStack, count the nodes
// return the count
// you may use one stack or array as additional storage
// the given stack must be returned back to it's original order
// you may only use public stack methods push pop peek isempty
function countStack(stack) {};



// groups solution:


class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

// slStack must be implemented using Nodes and pointers
class slStack {
    constructor() {
        this.top = null; // this.head, this.end
    }

    // add to top
    push(newNode) {
         node.next = this.top; // set the new node's next to the head
         this.top = newNode; // move the head to the new node
         this.length++;
    }
i
    // remove from top
    pop() {
        if(this.isEmpty()) return null;

        var nodeToRemove = this.top;
        this.top = this.top.next;
        nodeToRemoveNext = null;
        this.length--;
        return nodeToRemove;
    }

    // aka check top
    peek() {
        return this.top;
    }

    // check if empty
    isEmpty() {
        return this.top === null;
    }
}

var s = new slStack();
s.push(new Node(10));
s.push(new Node(20));
s.push(new Node(30));
console.log(s);
s.pop();
console.log(s.countStack(s));




// bonus challenge: countStack

// write the standalone function countStack
// given a slStack, count the nodes
// return the count
// you may use one stack or array as additional storage
// the given stack must be returned back to it's original order
// you may only use public stack methods push pop peek isempty
function countStack(stack) {
    return this.length;
}

    // // Remove from front: remove and return the first node in the SLL
    // removeFromFront() {
    //     if (this.isEmpty()) return null; // nothing to remove

    //     var nodeToRemove = this.head; // save the head in a temp var
    //     this.head = this.head.next; // move the head
    //     nodeToRemove.next = null // make the removed node to no longer reference the list
    //     this.length--;
    //     return nodeToRemove;
    // }

    // // add given node to the head, if it exists. return void
    // addToFront(node) {
    //     node.next = this.head; // set the new node's next to the head
    //     this.head = node; // move the head to the new node
    //     this.length++;
    // }