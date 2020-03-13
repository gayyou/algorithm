const Resolution = (matrix) => {
  if (matrix === null || matrix.length === 0) {
    return -1;
  }

  let rowLen = matrix[0].length;
  let dp = new Array(rowLen).fill(0);

  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < rowLen; j++) {
      if (j === 0) {
        dp[j] += matrix[i][j];
      } else {
        dp[j] = Math.max(dp[j], dp[j - 1]) + matrix[i][j];
      }
    }
  }

  return dp[dp.length - 1];
};
