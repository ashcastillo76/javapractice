// minStack

// recreate the Stack class as a minStack.
// minStacks support the following methods:
// push(node), pop(), peek(), isEmpty()
// and a new method called
// getMin()

// getMin() should retrieve the minimum element of the stack.
// We should be able to do this in constant time with no looping!
// How would we modify push and pop to keep track of a minimum element?
// Always checking if we need to update the new minimum value!!

// minStacks are also basically just stacks, so FILO (first in last out) rules apply
class Node {
    constructor( data ) {
        this.data = data;
        this.next = null;
    }
}

class minStack {
    constructor() {
        this.top = null;
        this.mins = []; // <-- huge hint, we don't just track a single min
    }

    push(newNode) {

        if ( this.top === null ) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
    }

    // add a node
    // update the min if this new node is smaller than the min
    // Time: O(1)
    push(node){
        if (this.top === null) {
        this.top = node;
        this.mins.push(node.data);
        } else {
        let min = Math.min(node.data, this.mins[this.mins.length - 1]);
        this.mins.push(min);
        node.next = this.top;
        this.top = node;
        }
    };

    // remove a node
    // also pop from this.mins if the popped node is the smallest
    // Time: O(1)
    pop(){
        if (this.top === null) return null;

        const removed = this.top; // store previous top
        this.top = this.top.next; // move top pointer
        removed.next = null; // remove pointer from stored node

        this.mins.pop();

        return removed; // return the node
    }
    // return true false if stack is empty
    isEmpty(){
        return this.top === null;
    }

    // peek at the top node
    // Time: O(1)
    peek(){
        return this.top;
    }

    // get the minimum value from the list
    // how can we do this without looping??
    // Time: O(1)
    getMin(){
        return this.mins[this.mins.length - 1];
    }

    // add a node
    // update the min if this new node is smaller than the min
    peek() {
        // return this.front ? this.front.data : this.front;
        return this.front;
    }

    // remove a node
    // also pop from this.mins if the popped node is the smallest
    pop() {
        if ( this.top === null ) return null;

        const removed = this.top; // store previous top
        this.top = this.top.next; // move top pointer
        removed.next = null; // remove pointer from stored node

        return removed; // return the node
    }

    // return true false if stack is empty
    isEmpty() {
        return this.top === null;
    }

    // peek at the top node
    peek() {
        return this.top;
    }

    // get the minimum value from the list
    // how can we do this without looping??

    getMin() {
        var myNode = this.top;
        var thisMin = this.mins;
        thisMin[ 0 ] = myNode.data;
        console.log( thisMin );
    }


    getThisMin() {
        var thisNode = this.top;
        var thisMin = this.mins;
        while ( thisNode.next ) {
            if ( thisMin[ 0 ] == null ) {
                thisMin[ 0 ] = thisNode.data;
            }
            if ( thisMin[ 0 ] > thisNode.next.data ) {
                thisMin[ 0 ] = thisNode.next.data;
            }
            thisNode = thisNode.next;
        }
        console.log( thisMin );
        return thisMin;
    }
};

var myStack = new minStack();
var anotherSatck = new minStack();

myStack.push( new Node( 1 ) );
myStack.push( new Node( 2 ) );
myStack.push( new Node( 3 ) );
myStack.push( new Node( 4 ) );
myStack.push( new Node( 5 ) );

anotherSatck.push( new Node( 5 ) );
anotherSatck.push( new Node( 3 ) );
anotherSatck.push( new Node( 5 ) );
anotherSatck.push( new Node( 7 ) );
anotherSatck.push( new Node( 2 ) );

myStack.getMin();
anotherSatck.getMin();