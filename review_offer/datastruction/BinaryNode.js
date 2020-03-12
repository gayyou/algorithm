const { isUndef, isDef } = require('../Utils')

module.exports = class BinaryNode {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  preOrder(root) {
    if (isUndef(root)) {
      return ;
    }

    let stack = [];
    let result = [];
    let temp = root;

    while (isDef(temp) || stack.length !== 0) {
      while (isDef(temp)) {
        // 如果temp存在的话，进行加进栈中
        stack.push(temp);
        result.push(temp.val);
        temp = temp.left;
      }

      temp = stack.pop().right;
    }

    return result;
  }

  midOrder(root) {
    if (isUndef(root)) {
      return ;
    }

    let stack = [];
    let result = [];
    let temp = root;

    while (isDef(temp) || stack.length !== 0) {
      while (isDef(temp)) {
        // 如果temp存在的话，进行加进栈中
        stack.push(temp);
        temp = temp.left;
      }

      temp = stack.pop();
      result.push(temp.val);
      temp = temp.right;
    }

    return result;
  }

  postOrder(root) {
    // 后续遍历的时候，需要有一个指针来进行判断出来防止重复操作，
    if (isUndef(root)) {
      return ;
    }

    let stack = [];
    let result = [];
    let temp = root;
    let preNode = null;

    while (temp != null || stack.length !== 0) {
      while (temp != null) {
        stack.push(temp);
        temp = temp.left;
      }

      temp = stack.pop();

      if (isDef(temp.right) && temp.right !== preNode) {
        // 说明右边没有遍历过,先将右边压栈
        stack.push(temp.right);
        temp = temp.right;
      } else {
        // 不存在右边，或者右边遍历过，那么进行搜集当前节点，
        // 右边有遍历过那么轮到当前节点的，需要将当前节点入栈，并且置空，然后preNode设为当前节点
        preNode = temp;
        result.push(temp.val);
        temp = null;
      }
    }

    return result;
  }

  peek(arr) {
    return arr[arr.length - 1];
  }
}
