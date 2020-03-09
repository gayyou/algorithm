const minPath = (grid) => {
    if (grid === null || grid.length === 0) {
      return 0;
    }

    let dp = new Array(grid[0].length);

    dp.fill(0);
    dp[0] = grid[0][0];

    for (let i = 1; i < grid.length; i++) {
      dp[i] += grid[0][i];
    }

    for (let i = 1; i < grid.length; i++) {
      for (let j = 0; j < grid[0].length; j++) {
        if (j === 0) {
          dp[0] += grid[i][0];
        } else {
          dp[i] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }
      }
    }

    return dp[dp.length - 1];
};
