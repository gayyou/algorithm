const isUndef = tar => typeof tar === 'undefined' || tar === null;

const isDef = tar => !isUndef(tar);

const resolution = (matrix, tar) => {
  if (isUndef(matrix) || matrix.length === 0) {
    return -1;
  }

  let j;
  let rowLength = matrix[0].length;
  let preI = 0, preJ = 0;

  for (let i = 0; i < matrix.length; i++) {
    j = i < rowLength ? i : rowLength - 1;

    if (matrix[i][j] <= tar) {
      preI = i;
      preJ = j;
    } else {
      break;
    }
  }

  for (let i = preI; i < matrix.length; i++) {
    if (matrix[i][preJ] === tar) {
      return true;
    }
  }

  for (let j = preJ + 1; j < rowLength; j++) {
    if (matrix[preI][j] === tar) {
      return true;
    }
  }

  return false;
}

console.log(resolution([
  [1, 2, 8, 9],
  [2, 4, 9, 12],
  [4, 7, 10, 13],
  [6, 8, 11, 15]
], 7));

