const Resolution = (node, k) => {
  if (node === null) {
    return [];
  }

  let result = [];
  let pathArray = [];

  function process(node, pathArray, tempSum) {
    if (node === null) {
      return ;
    }

    pathArray.push(node.val);
    tempSum += node.val;

    if (node.left === null && node.right === null) {
      // 等到达根节点的时候，进行分析并且添加结果
      if (tempSum === k) {
        result.push(pathArray.slice());
      }
    }

    process(node.left, pathArray, tempSum);
    process(node.right, pathArray, tempSum);

    pathArray.pop();
  }

  process(node, pathArray, 0);

  return result;
};
