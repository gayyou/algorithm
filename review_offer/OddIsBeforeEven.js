const Resolution = (arr) => {
  if (arr == null || arr.length === 0) {
    return ;
  }

  let left = 0;
  let right = arr.length - 1;

  while (left < right) {
    while (arr[left] % 2 === 0) {
      left++;
    }

    while (arr[right] % 2 === 1) {
      right--;
    }
    

    [arr[left], arr[right]] = [arr[right], arr[left]];
  }
};
