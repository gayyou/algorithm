const Resolution = (n) => {
  if (n <= 0) {
    return [];
  }

  let resultArray = new Array(n * 6 + 1).fill(0);
  let newArray = new Array(n * 6 + 1).fill(0);

  for (let i = 0; i < 6; i++) {
    resultArray[i] = 1;
  }

  for (let i = 2; i <= n; i++) {
    for (let j = 0; j < i; j++) {
      newArray[j] = 0;
    }

    for (let j = i; j <= i * 6; j++) {
      newArray[j] = 0;
      for (let k = 1; k <= j && k <= 6; k++) {
        newArray[j] += resultArray[j - k];
      }
    }
    let temp = newArray;
    newArray = resultArray;
    resultArray = temp;
  }

  let result = resultArray.slice(n - 1);
  let total = Math.pow(6, n);

  for (let i = 0; i < result.length; i++) {
    result[i] = result[i] / total;
  }

  return result;
};

console.log(Resolution(2))
