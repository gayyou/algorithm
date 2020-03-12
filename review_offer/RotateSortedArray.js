const Resolution = (arr) => {
  if (arr === null || arr.length === 0) {
    return false;
  }

  let left = 0;
  let right = arr.length - 1;
  let midIndex = 0;

  while (arr[left] >= arr[right]) {
    if (left === right - 1) {
      midIndex = right;
      break;
    }

    midIndex = Math.floor((left + right) / 2);
    if (arr[midIndex] >= arr[right]) {
      left = midIndex + 1;
    } else if (arr[midIndex] <= arr[left]) {
      right = midIndex - 1;
    }
  }

  return arr[midIndex];
};

console.log(Resolution([1, 5, 3]))
