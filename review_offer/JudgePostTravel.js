const Resolution = (arr) => {
  if (arr === null || arr.length === 0) {
    return false;
  }

  function partition(arr, left, right) {
    if (left >= right) {
      return true;
    }

    let key = arr[right];
    let flag = false;
    let mid = left, j = right;

    while (j >= left) {
      if (arr[j] < key) {
        if (!flag) {
          mid = j;
          flag = true;
        } else {
          return false;
        }
      }
      j--;
    }

    if (!partition(arr, left, mid)) {
      return false;
    }

    if (!partition(arr, mid + 1, right - 1)) {
      return false;
    }

    return true;
  }

  return partition(arr, 0, arr.length - 1);
};
