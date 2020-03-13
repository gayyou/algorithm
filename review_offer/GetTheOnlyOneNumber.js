const Resolution = (arr) => {
  if (arr === null || arr.length === 0) {
    throw new Error('Array is Not Null');
  }

  let res = 0;

  for (let i = 0; i < 32; i++) {
    let sum = 0;
    for (let j = 0; j < arr.length; j++) {
      sum +=  (arr[j] >> i) & 1;
    }

    res ^= (sum % 3) << i;
  }

  return res;
};

const Resolution2 = (arr) => {
  if (arr === null || arr.length === 0) {
    throw new Error('Array is Not Null');
  }

  let num = arr[0];

  for (let i = 1; i < arr.length; i++) {
    num &= arr[i];
  }

  return num;
};
