const Resolution = (arr) => {
  let container = new Array(14).fill(0);

  for (let i = 0; i < arr; i++) {
    if (arr[i] !== 0 && container[i] === 1) {
      return false;
    }
    container[i]++;
  }

  let isInOrder = false;
  let orderLen = 0

  for (let i = 1; i < container.length; i++) {
    if (container[i] != 0 && !isInOrder) {
      isInOrder = true;
    }

    if (isInOrder) {
      if (container[i] === 0) {
        if (orderLen < arr.length - container[0]) {
          return false;
        } else {
          container[0]--;
        }
      }

      orderLen++;
    }
  }

  return true;
};
