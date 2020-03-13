const Resolution = (arr) => {
  if (arr === null || arr.length === 0) {
    return [];
  }

  let count = 0;

  function split(arr, left, right) {

    if (left >= right) {
      return [arr[left]];
    }

    let mid = Math.floor((left + right) / 2);
    let tempArray = new Array(right - left + 1);

    let leftArr = split(arr, left, mid);
    let rightArr = split(arr, mid + 1, right);

    // 接下来是进行处理的过程
    let i = 0, j = 0, newIdx = 0;

    while (i < leftArr.length && j < rightArr.length) {
      if (leftArr[i] <= rightArr[j]) {
        tempArray[newIdx++] = leftArr[i++];
      } else {
        tempArray[newIdx++] = rightArr[j++];
        count += leftArr.length - i;
      }
    }

    while (i < leftArr.length) {
      tempArray[newIdx++] = leftArr[i++];
    }

    while (j < rightArr.length) {
      tempArray[newIdx++] = rightArr[j++];
    }

    return tempArray;
  }

  split(arr, 0, arr.length - 1);

  return count;
};

console.log(Resolution([4, 5, 6, 7]))
