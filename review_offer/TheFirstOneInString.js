const Resolution = (str) => {
  if (str === null || str.length === 0) {
    return null;
  }

  let map = new Map();

  for (let i = 0; i < str.length; i++) {
    let item = map.get(str[i]);

    if (!item) {
      map.set(str[i], 1);
    } else {
      map.set(str[i], map.get(str[i]) + 1);
    }
  }

  for (let item of map) {
    if (item[1] == 1) {
      return item[0];
    }
  }

  return null;
};
