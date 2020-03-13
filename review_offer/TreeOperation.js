const { BN1 } = require('./TestExample');

const BinaryNode = require('./datastruction/BinaryNode')

const process = (node) => {
  if (node === null) {
    return '';
  }

  function inner(node) {
    let result = [node.val];

    if (node.left) {
      let leftTree = inner(node.left);
      result = [result, ...leftTree];
    } else {
      result.push('null');
    }

    if (node.right) {
      let rightTree = inner(node.right);
      result = [...result, ...rightTree];
    } else {
      result.push('null');
    }

    return result;
  }

  return '[' + inner(node).toString() + ']';
}

const build = (str) => {
  if (str.length === 0) {
    return null;
  }

  let data = JSON.parse(str);
  let root;
  let nodeQueue = [];
  let itemNode;

  if (data[0] === 'null') {
    return null;
  }

  itemNode = root = new BinaryNode(data[0]);
  let idx = 0;
  nodeQueue.push(itemNode);

  while (nodeQueue.length !== 0 && idx < data.length) {
    itemNode = nodeQueue.shift();
    let newNodeVal = data[idx++];

    if (newNodeVal != null) {
      console.log(newNodeVal)
      itemNode.left = new BinaryNode(newNodeVal);
      nodeQueue.push(itemNode.left)
    }

    newNodeVal = data[idx++];

    if (newNodeVal != null) {
      console.log(newNodeVal)
      itemNode.right = new BinaryNode(newNodeVal);
      nodeQueue.push(itemNode.right)
    }
  }

  return root;
}

console.log(build(process(BN1)));
console.log(BN1);
