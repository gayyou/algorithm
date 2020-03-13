const Resolution = (sup, sub) => {
  if (sup === null && sub !== null) {
    return false;
  } else if (sub === null) {
    return true;
  }

  function travelTree(node) {
    if (node === null) {
      return false;
    }

    if (node.val === sub.val) {
      if (check(sub, node)) {
        return true;
      }
    }

    return travelTree(node.left) || travelTree(node.right);
  }

  function check(model, tar) {
    if (model === null) {
      return true;
    }

    if (model.val !== tar.val) {
      return false;
    }

    return check(model.left, tar.left) && check(model.right, tar.right);
  }

  return travelTree(sup);
};
