const Resolution = (n) => {
  if (n <= 0) {
    return 0;
  }
  if (n <= 2) {
    return n;
  }

  let temp1 = 1;
  let temp2 = 2;

  for (let i = 2; i < n; i++) {
    [temp2, temp1] = [temp1 + temp2, temp2];
  }

  return temp2;
};

console.log(Resolution(44))
