const Resolution = (node) => {
  if (node == null) {
    return null;
  }
  let newNode = null;
  while (node.next !== null) {
    newNode = new Node(node.val);
    newNode.nextSibling = node.nextSibling;
    newNode.next = node.next;
    node.next = newNode;

    node = node.next.next;
  }
};
