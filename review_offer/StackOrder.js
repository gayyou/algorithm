const Resolution = (arr1, arr2) => {
  if (arr1 === null || arr2 === null || arr1.length === 0 || arr2.length === 0) {
    return true;
  }

  // 接下来使用两个栈来进行模拟
  let mainStack = [];

  let checkIdx = 0;
  let arr1Idx = 0;

  while (arr1Idx < arr1.length) {
    // 如果相同，直接跳过
    if (arr1[arr1Idx] === arr2[checkIdx]) {
      arr1Idx++;
      checkIdx++;
    } else {
      // 不相同进行压栈
      mainStack.push(arr1[arr1Idx]);
    }
  }

  while (mainStack.length !== 0) {
    if (mainStack.pop() !== arr2[checkIdx++]) {
      return false;
    }
  }

  return true;
};
