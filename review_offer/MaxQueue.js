class MaxQueue {
  static peek(maxQueue) {
    return maxQueue[0];
  }

  constructor() {
    this.mainQueue = [];
    this.maxQueue = [];
  }

  add(elem) {
    this.mainQueue.push(elem);

    while (this.maxQueue.length !== 0 && this.maxQueue[this.maxQueue.length - 1] < elem) {
      this.maxQueue.pop();
    }

    this.maxQueue.push(elem);
  }

  poll() {
    let result = this.mainQueue.shift();
    if (MaxQueue.peek(this.maxQueue) === result) {
      this.maxQueue.shift();
    }

    return result;
  }

  max() {
    return MaxQueue.peek(this.maxQueue);
  }
}

let maxQueue = new MaxQueue();
maxQueue.add(1);
maxQueue.add(5);
maxQueue.add(4);
maxQueue.add(5);
maxQueue.add(2);

console.log(maxQueue.maxQueue)
