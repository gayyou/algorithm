class Stack {
  constructor() {
    this.queue1 = [];
    this.queue2 = [];
  }

  push(elem) {
    this.queue1.push(elem);
  }

  pop() {
    if (this.queue1.length === 0) {
      return null;
    }

    while (this.queue1.length > 1) {
      this.queue2.push(this.queue1.shift());
    }

    [this.queue1, this.queue2] = [this.queue2, this.queue1];

    return this.queue2.shift();
  }
}

let stack = new Stack();

stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);
stack.push(5);
stack.push(6);

console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
