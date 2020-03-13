const Resolution = (arr) => {
  if (arr === null || arr.length === 0) {
    return null;
  }

  let left = 0;
  let right = arr.length - 1;

  while (left < right) {
    let mid = Math.floor((left + right) / 2);

    if (arr[mid] === mid) {
      return mid;
    } else if (arr[mid] < mid) {
      // 此时右边很可能存在目标值
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return null;
};

console.log(Resolution([-1, -3, 1, 3, 5]));
