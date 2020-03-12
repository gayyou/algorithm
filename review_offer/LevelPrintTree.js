const { isUndef } = require('./Utils');

const Resolution = (root) => {
  if (isUndef(root)) {
    return false;
  }

  let prePoint = root, postPoint = root;
  let queue = [root];
  let printMessage = '';

  while (queue.length !== 0) {
    let item = queue.shift();
    if (item.left) {
      queue.push(item.left);
      postPoint = item.left;
    }

    if (item.right) {
      queue.push(item.right);
      postPoint = item.right;
    }

    printMessage += ' ' + item.val;

    if (prePoint === item) {
      // 两个节点相同的时候输出存储的message，并且更换prePoint
      prePoint = postPoint;
      console.log(printMessage);
      printMessage = '';
    }
  }
};

const bn = require('./TestExample').BN1;

Resolution(bn);
