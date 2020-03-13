// let len = readInt();
// let firstLine = read_line();
// let secondLine = read_line();

let len = 10;
let firstLine = '..X.X.....';
let secondLine = 'X...XXXX..';

let matrix = new Array(2);
matrix[0] = new Array(len);
matrix[1] = new Array(len);

for (let i = 0; i < len; i++) {
  matrix[0][i] = firstLine[i] === '.' ? 1 : -1;
}

for (let i = 0; i < len; i++) {
  matrix[1][i] = secondLine[i] === '.' ? 1 : -1;
}

let count = 0;

let boolMatrix = [];
boolMatrix[0] = new Array(len).fill(0);
boolMatrix[1] = new Array(len).fill(0);

function Resolution(matrix, i, j) {
  if (i < 0 || i >= 2 || j < 0 || j >= len) {
    return 0;
  }

  if (boolMatrix[i][j] === -1) {
    return -1;
  }

  if (matrix[i][j] === -1) {
    return -1;
  }

  if (i === 1 && j === len - 1) {
    count++;
  }

  Resolution(matrix, i, j + 1);

  Resolution(matrix, i + 1, j + 1);

  Resolution(matrix, i - 1, j + 1);

  return 1;
}
Resolution(matrix, 0, 0)
if (count == 0) {
  console.log(-1);
} else {
  console.log(count);
}

