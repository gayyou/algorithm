const fiber1 = (n) => {
  if (n === 1 || n === 2) {
    return 1;
  }

  return fiber1(n - 1) + fiber1(n - 2);
};

const fiber1Better = (n) => {
  let cache = new Array(n);
  cache.fill(0);

  function innerFiber(n) {
    if (n === 1 || n === 2) {
      return 1;
    }

    if (cache[n - 1] !== 0) {
      return cache[n - 1];
    }

    let fiberVal1 = innerFiber(n - 1);
    let fiberVal2 = innerFiber(n - 2);

    cache[n - 1] = fiberVal2 + fiberVal1;

    return cache[n - 1];
  }

  return innerFiber(n);
}

const dpFiber = (n) => {
  if (n === 1 || n === 2) {
    return 1;
  }

  let temp1 = 1, temp2 = 1;

  for (let i = 0; i < n - 2; i++) {
    [temp2, temp1] = [temp1 + temp2, temp2];
  }

  return temp2;
};

const dpFiberBetter = (n) => {
  if (n === 1 || n === 2) {
    return 1;
  }

  let baseMatrix = [[1, 1], [0, 0]];
  let mutilMatrix = [[1, 1], [1, 0]];

  function matrixResolution(baseMatrix, mutilMatrix) {
    for (let i = 0; i < baseMatrix.length; i++) {
      // baseMatrix中从行开始
      for (let j = 0; j < baseMatrix[0].length; j++) {
        // 拿出第i行第k列数据进行运算
        let result = 0;
        for (let k = 0; k < mutilMatrix.length; k++) {
          result += baseMatrix[i][j] * mutilMatrix[k][i];
        }
        baseMatrix[i][j] = result;
      }
    }
  }

  for (; n !== 0; n >> 1) {
    if ((n & 1) !== 0) {
      matrixResolution(baseMatrix, mutilMatrix);
    }
    matrixResolution(mutilMatrix, mutilMatrix);
  }

  return baseMatrix[0] + baseMatrix[1];
};

let start = Date.now();
console.log(dpFiberBetter(30));
console.log(Date.now() - start);
