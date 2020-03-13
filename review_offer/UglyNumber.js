const Resolution = (n) => {
  if (n <= 5) {
    return n;
  }

  let dp = new Array(n).fill(0);
  let p1 = 0, p2 = 0, p3 = 0;
  dp[0] = 1;

  for (let i = 1; i < n; i++) {
    dp[i] = Math.min(dp[p1] * 2, Math.min(dp[p2] * 3, dp[p3] * 5));

    if (dp[i] === dp[p1] * 2) p1++;
    if (dp[i] === dp[p2] * 3) p2++;
    if (dp[i] === dp[p3] * 5) p3++;
  }

  return dp[dp.length - 1];
};
