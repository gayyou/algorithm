const Resolution = (m, n, k) => {
  if (m <= 0 || n <= 0) {
    return 0;
  }

  function getCount(a) {
    let sum = 0;
    while (a != 0) {
      sum += a % 10;
      a = parseInt(a / 10);
    }

    return sum;
  }

  function go(m, n, i, j, k, visited) {
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return false;
    }

    if (visited[i][j] || getCount(i) + getCount(j) > k) {
      return false;
    }

    visited[i][j] = true;
    count++;
    go(m, n, i - 1, j, k, visited);
    go(m, n, i + 1, j, k, visited);
    go(m, n, i, j - 1, k, visited);
    go(m, n, i, j + 1, k, visited);
  }

  let count = 0;
  let visited = new Array(m);
  for (let i = 0; i < visited.length; i++) {
    visited[i] = new Array(n).fill(false);
  }

  go(m, n, 0, 0, k, visited);

  return count;
};
