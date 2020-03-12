class Queue {
  constructor() {
    this.stack1 = [];
    this.stack2 = [];
  }

  addQueue(elm) {
    this.stack1.push(elm);
  }

  popQueue() {
    if (this.stack2.length === 0) {
      while (this.stack1.length !== 0) {
        this.stack2.push(this.stack1.pop());
      }
    }

    if (this.stack2.length === 0) {
      return null;
    }

    return this.stack2.pop();
  }
}

let queue = new Queue();

queue.addQueue(1);
queue.addQueue(2);
queue.addQueue(3);
queue.addQueue(4);
queue.addQueue(5);

console.log(queue.popQueue());
console.log(queue.popQueue());
console.log(queue.popQueue());
console.log(queue.popQueue());

queue.addQueue(1);
console.log(queue.popQueue());
console.log(queue.popQueue());
console.log(queue.popQueue());
