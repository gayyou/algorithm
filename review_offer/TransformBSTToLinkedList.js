const BinaryNode = require('./datastruction/BinaryNode')

const Resolution = (root) => {
  if (root == null) {
    return null;
  }

  function TravelLeft(node) {
    if (node == null) {
      return null;
    }

    let left = TravelLeft(node.left);
    let right = TravelRight(node.right);

    node.left = left;
    node.right = right;

    return right === null ? node : right;
  }

  function TravelRight(node) {
    if (node == null) {
      return null;
    }

    let left = TravelLeft(node.left);
    let right = TravelRight(node.right);

    node.left = left;
    node.right = right;

    return left === null ? node : left;
  }

  root.left = TravelLeft(root.left);
  root.right = TravelRight(root.right);



  return root.left === null ? root : root.left;
};
let node = new BinaryNode(3);
let node1 = new BinaryNode(2);
let node2 = new BinaryNode(4);
// node.left = node1;
node.right = node2;
console.log(Resolution(node).val);

