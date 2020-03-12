const Resolution = (n) => {
  if (n <= 3) {
    return n;
  }

  let threeCount = n / 3;
  let resultLen = n % 3;
  let result = 1;

  if (resultLen === 1) {
    threeCount--;
    resultLen = 4;
  } else if (resultLen === 0) {
    resultLen = 1;  // 等于0的情况下不能相乘，所以换成1
  }

  let base = 3;
  // 使用快速幂
  for (; threeCount !== 0; threeCount >>= 1) {
    if ((threeCount & 1) === 1) {
      // 如果当前位存在的话
      result *= base;
    }
    base *= base;
  }

  result *= resultLen;

  return result;
};
