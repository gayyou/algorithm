const isUndef = tar => typeof tar === 'undefined' || tar === null;

const isDef = tar => !isUndef(tar);

/**
 * @description 如果位置在1的时候，只能往右走，如果在len的时候只能往左走
 * @param len
 * @param cur
 * @param rest
 * @param p
 */
const walk = (len, cur, rest, p) => {
  if (rest === 0) {
    return cur === p ? 1 : 0;
  }

  if (cur === 1) {
    return walk(len, cur + 1, rest - 1, p);
  }

  if (cur === len) {
    return walk(len, cur - 1, rest - 1, p);
  }

  return walk(len, cur + 1, rest - 1, p) + walk(len, cur - 1, rest - 1, p);
};

const walk2 = (len, cur, rest, p) => {
  if (len < 2 || rest <= 0) {
    return 0;
  }

  let dp = new Array(len);

  for (let i = 0; i < dp.length; i++) {
    dp[i] = 0;
  }

  dp[p - 1] = 1;

  for (let i = 0; i < rest; i++) {
    // 每次左上角都会被覆盖住，我们需要去记住
    let leftUp = dp[0];
    for (let j = 0; j < dp.length; j++) {
      let tmp = dp[j];
      if (j === 0) {
        dp[0] = dp[j + 1];
      } else if (j === dp.length - 1) {
        dp[j] = leftUp;
      } else {
        dp[j] = leftUp + dp[j + 1];
      }
      leftUp = tmp;
    }
  }

  return dp[cur - 1];
};

console.log(walk2(7, 4, 9, 5));
console.log(walk(7, 4, 9, 5));
