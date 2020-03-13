const IsABBST = (node) => {
  if (node === null) {
    return {
      height: 0,
      isBBST: true
    }
  }

  let maxHeight = 0;
  let factory = 0;

  let leftItem = IsABBST(node.left);
  let rightItem = IsABBST(node.right);

  if (leftItem.isBBST && rightItem.isBBST) {
    maxHeight = Math.max(leftItem.height, rightItem.height);
    factory = Math.abs(leftItem.height - rightItem.height);
  } else {
    return {
      isBBST: false
    }
  }

  return {
    height: maxHeight + 1,
    isBBST: factory <= 1
  }
};
