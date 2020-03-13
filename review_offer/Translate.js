const Resolution = (n) => {
  if (n < 0) {
    return -1;
  }

  if (n < 10) {
    return 1;
  }

  let str = n.toString();

  let dp = new Array(str.length).fill(0);
  dp[0] = 1;

  if (parseInt(str.slice(0, 2)) <= 25) {
    dp[1] = 2;
  } else {
    dp[1] = 1;
  }

  for (let i = 2; i < dp.length; i++) {
    dp[i] = dp[i - 1];

    if (str[i] !== '0' && parseInt(str.slice(i - 1, i + 1)) <= 25) {
      dp[i] += dp[i - 2];
    }
  }

  return dp[dp.length - 1];
};

console.log(Resolution(12258))
