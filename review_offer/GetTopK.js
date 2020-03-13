const inTree = (root, k) => {
  if (root === null) {
    throw new Error('');
  }

  let targetNode = null;
  let count = 0;

  function travel(root) {
    if (root == null || targetNode != null) {
      return ;
    }

    travel(root.right);
    // 右中左进行遍历，所以先遍历完右边再添加
    count++;

    if (count === k) {
      targetNode = root;
    }

    travel(root.left)
  }

  travel(root);

  return targetNode.val;
};

const inArray = (arr, k) => {
  if (arr === null || arr.length < k) {
    throw new Error('Array is not define or length is zero')
  }

  function partition(arr, left, right) {
    let key = arr[left];

    while (left < right) {
      while (left < right && arr[right] <= arr[left]) {
        right--;
      }

      arr[left] = arr[right];

      while (left < right && arr[left] >= arr[right]) {
        left++;
      }

      arr[right] = arr[left];
    }

    arr[left] = key;

    return left;
  }

  let resultMid = partition(arr, 0, arr.length - 1);
  let start = 0;
  let end = arr.length - 1;
  while (resultMid !== k - 1) {
    if (resultMid < k - 1) {
      start = resultMid + 1;
      resultMid = partition(arr, start, end);
    } else {
      end = resultMid - 1;
      resultMid = partition(arr, start, end);
    }
  }

  return arr[k - 1];
};

console.log(inArray([1, 2, 3, 4], 2))
