const { BN1 } = require('./TestExample');

const BinaryNode = require('./datastruction/BinaryNode')

const process = (node, arr) => {
  if (node === null) {
    arr.push('#')
    return ;
  }

  arr.push(node.val);
  process(node.left, arr);
  process(node.right, arr);
};

const func = (node) => {
  let arr = []
  process(node, arr);
  return arr;
}

const build = (arr) => {
  if (arr.length === 0) {
    return null;
  }

  let idx = 0;

  function process(arr) {
    if (arr[idx] == '#') {
      idx++;
      return null;
    }

    let node = new BinaryNode(arr[idx++]);

    node.left = process(arr);
    node.right = process(arr);

    return node;
  }

  return process(arr);
}
console.log(func(BN1));
console.log(build(func(BN1)));
// console.log(BN1)
