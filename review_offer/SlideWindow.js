const Resolution = (arr, k) => {
  if (arr === null || arr.length === 0) {
    return [];
  }

  let deque = [];

  function peekTop(deque) {
    return deque[deque.length - 1];
  }

  let result = [];

  for (let i = 0; i < k; i++) {
    while (deque.length !== 0 && arr[peekTop(deque)] < arr[i]) {
      deque.pop();
    }

    deque.push(i);
  }

  for (let i = 0; i < arr.length - k; i++) {
    if (deque[0] <= i - k) {
      deque.shift();
    }

    while (deque.length !== 0 && arr[peekTop(deque)] < arr[i]) {
      deque.pop();
    }

    deque.push(i);
    result.push(deque[0]);
  }

  return result;
}
