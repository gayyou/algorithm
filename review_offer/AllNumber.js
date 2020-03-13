const Resolution = (str) => {
  if (str === null || str.length === 0) {
    return [];
  }

  let set = new Set();
  let visited = new Array(str.length).fill(false);

  function process(str, letter) {
    if (str.length === letter.length) {
      set.add(letter);
      return ;
    }

    for (let i = 0; i < str.length; i++) {
      let temp = str.charAt(i);
      if (visited[i]) continue;
      // 设定i为访问过的，这样的话进行深度遍历的时候，就不会再次访问到这个数据了
      visited[i] = true;
      process(str, letter + temp);
      visited[i] = false;
    }
  }

  process(str, '');

  return Array.from(set);
};



console.log(Resolution('abc'));
