const groupAnagrams = (strs) => {
  if (strs === null || strs.length === 0) {
    return [];
  }

  let map = new Map();
  let result = [];

  // 先搜集，然后逐个分析
  for (let i = 0; i < strs.length; i++) {
    let hashCode = getHashCode(strs[i]);
    let arr = map.get(hashCode);
    if (!arr) {
      map.set(hashCode, arr = []);
    }
    arr.push(strs[i]);
  }

  for (let itemArray of map) {
    //
    result.push(itemArray);
  }

  function getHashCode(str) {
    let num = 0;

    for (let i = 0; i < str.length; i++) {
      num += (str[i] - 'a' + 1) * (str[i] - 'a');
    }

    return num;
  }


  return result;
};

"acb".sort()
