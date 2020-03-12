const Resolution = (matrix, str) => {
  if (matrix === null || matrix.length === 0 || str === null || str.length === 0) {
    return false;
  }

  function findPath(matrix, str, i, j, strIndex, visited) {
    if (strIndex === str.length) {
      return true;
    }

    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
      return false;
    }


    if (matrix[i][j] != str[strIndex] || visited[i][j]) {
      return false;
    }

    visited[i][j] = true;

    let hasPath = findPath(matrix, str, i - 1, j, strIndex + 1, visited)
      || findPath(matrix, str, i + 1, j, strIndex + 1, visited)
      || findPath(matrix, str, i, j - 1, strIndex + 1, visited)
      || findPath(matrix, str, i, j + 1, strIndex + 1, visited);

    if (!hasPath) {
      visited[i][j] = false;
    }

    return hasPath;
  }

  let result = false;
  let visited = new Array(matrix.length);
  for (let i = 0; i < visited.length; i++) {
    visited[i] = new Array(matrix[0].length).fill(false);
  }

  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[0].length; j++) {
      if (matrix[i][j] === str[0]) {
        result = findPath(matrix, str, i, j, 0, visited);

        if (result) {
          return true;
        }
      }
    }
  }

  return false;
};

console.log(Resolution([
  ['a', 'b', 't', 'g'],
  ['c', 'f', 'c', 's'],
  ['j', 'd', 'e', 'h']
], 'bfce'));
