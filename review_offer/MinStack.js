class MinStack {
  static peek(stack) {
    return stack[stack.length - 1];
  }

  constructor() {
    this.mainStack = [];
    this.minStack = [];
  }

  push(elem) {
    this.mainStack.push(elem);

    if (this.minStack.length === 0 || MinStack.peek(this.minStack) >= elem) {
      this.minStack.push(elem);
    }
  }

  pop() {
    let result = this.mainStack.pop();
    if (MinStack.peek(this.minStack) === result) {
      this.minStack.pop();
    }

    return result;
  }

  min() {
    return MinStack.peek(this.minStack);
  }
}

let stack = new MinStack();
stack.push(1);
stack.push(4);
stack.push(2);
stack.push(1);
stack.push(5);

console.log(stack.min());
stack.pop();
console.log(stack.min());
stack.pop();
stack.pop();
stack.pop();
console.log(stack.min());

