const Resolution = (arr) => {
  if (arr === null || arr.length === 0) {
    return null;
  }

  let num, numCount = 0;

  for (let i = 0; i < arr.length; i++) {
    if (numCount === 0) {
      num = arr[i];
      numCount++;
    } else if (arr[i] === num) {
      numCount++;
    } else {
      numCount--;
    }
  }

  return num;
};
