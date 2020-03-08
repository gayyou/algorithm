const findMinCoins = (arr, aim) => {
  if (aim === 0) {
    return 0;
  }

  let count = process(arr, aim);

  return count === Infinity ? -1 : count;
};

// 采用暴力解法，返回金币个数
const process = (arr, res) => {
  if (res === 0) {
    return 0;
  }

  let base;
  let minCoin = Infinity;

  for (let i = 0; i < arr.length; i++) {
    base = res - arr[i];

    if (base < 0) {
      continue;
    }

    if (base === 0) {
      // 如果存在刚好减少后等于0的情况，那么只需要一个就够了
      return 1;
    } else {
      minCoin = Math.min(minCoin, process(arr, base));
    }
  }

  return minCoin === Infinity ? Infinity : minCoin + 1;
};

const isUndef = tar => typeof tar === 'undefined' || tar === null;

const isDef = tar => !isUndef(tar);

console.log(findMinCoins([5, 3], 2));
