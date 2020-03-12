const isUndef = tar => typeof tar === 'undefined' || tar === null;

const isDef = tar => !isUndef(tar);

const resolution = (arr) => {
  if (isUndef(arr) || arr.length === 0) {
    return [];
  }

  let set = new Set();

  for (let i = 0; i < arr.length; i++) {
    // 将正确的数字放在正确的位置上面
    if (i !== arr[i]) {
      let value = arr[i];
      if (value !== -1 && arr[value] === value) {
        return value;
      }

      [arr[value], arr[i]] = [arr[i], arr[value]];
      i--;
    }
  }

  return Array.from(set);
};

console.log(resolution([2, 3, 1, 0, 2, 5, 3]));

const resolution2 = (arr) => {
  if (isUndef(arr) || arr.length === 0) {
    return [];
  }

  // 思路是将数组走过的位置连起来，那么可以理解为一个链表，
  // 并且数组永远在数组内部进行走动（因为取值范围的原因），那么
  // 终究走过的路会成一个环，如果是一条成环的链表，那么找到成环的入口只能用快慢法
  // 为什么要说成环的入口，因为只有重复的数字才会走多次到那个点

  let value1 = arr[0];
  let value2 = arr[0];

  do {
    // 一个走得快，一个走得慢。然后先让走得快
    value1 = arr[value1];
    value2 = arr[arr[value2]];
  } while(value2 !== value1);

  let start = arr[0];

  while (start !== value1) {
    start = arr[start];
    value1 = arr[value1];
  }

  return start;
};

console.log(resolution2([2, 3, 1, 0, 2, 5, 3]));
