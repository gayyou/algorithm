const Resolution = (arr) => {
  if (arr === null) {
    return -1;
  }

  let sum = 0;
  let max = 0;

  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];

    if (sum < 0) {
      sum = 0;
    }

    max = Math.max(max, sum);
  }

  return max;
};

console.log(Resolution([1, -2, 3, 10, -4, 7, 2, -5]))
