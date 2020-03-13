const Resolution = (n) => {
  if (n <= 0) {
    return 0;
  }

  function getEven(mid, count) {
    let result = [];
    mid = Math.floor(mid);

    for (let i = mid - count / 2 + 1; i <= mid + count / 2; i++) {
      result.push(i);
    }

    return result;
  }

  function getOdd(mid, count) {
    let result = [];

    for (let i = mid - Math.floor(count / 2); i <= Math.floor(mid + count / 2); i++) {
      result.push(i);
    }

    return result;
  }

  let result = [];

  for (let i = 2; i <= n / 2 + 1; i++) {
    let midNumber = n / i;

    if (i % 2 === 0 && midNumber % 1 === 0.5) {
      let temp = getEven(midNumber, i);
      if (temp[0] > 0) {
        result.push(temp);
      }
    }

    if (i % 2 === 1 && midNumber % 1 === 0) {
      let temp = getOdd(midNumber, i);
      if (temp[0] > 0) {
        result.push(temp);
      }
    }
  }

  return result;
};

console.log(Resolution(15))

const Resolution2 = (n) => {
  if (n < 3) {
    return [];
  }

  let result = [];
  let left = 1;
  let right = 2;
  let top = n / 2 + 1;

  while (left < right && right < top) {
    let mid = (left + right) / 2;
    let tempSum = mid * (right - left + 1);

    if (tempSum === n) {
      result.push(getArray(left, right));
      left++;
      right++;
    } else if (tempSum < n) {
      right++;
    } else {
      left++;
    }
  }

  function getArray(start, end) {
    let arr = new Array(end - start + 1);
    let idx = 0;

    for (let i = start; i <= end; i++) {
      arr[idx++] = i;
    }

    return arr;
  }

  return result.reverse();
};

console.log(Resolution2(15))
