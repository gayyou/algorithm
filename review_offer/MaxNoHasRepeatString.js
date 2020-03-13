const Resolution = (str) => {
  if (str === null || str.length === 0) {
    return '';
  }

  let idxContainer = new Array(26).fill(-1);
  let maxCount = 0;

  for (let i = 0; i < str.length; i++) {
    let idx = str.charCodeAt(i) - 'a'.charCodeAt(0);

    if (idxContainer[idx] === -1) {
      idxContainer[idx] = i;
    } else {
      maxCount = (i - idx) > maxCount ? i - idx : maxCount;
      idxContainer[idx] = -1;
    }
  }

  return maxCount;
};
