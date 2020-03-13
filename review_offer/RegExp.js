const Resolution = (str, model) => {
  if (str === null || str.length === 0) {
    return model.length === 0 || model === '.*';
  }

  function process(str, model) {
    if ((str.length === 0 && model.length === 0) || model === '.*') {
      return true;
    }

    if (str[0] === model[0] || model[0] === '.') {
      if (model.length > 1 && model[1] === '*') {
        for (let i = 1; i < str.length; i++) {
          if (str[i] === str[0] && process(str.slice(i), model)) {
            return true;
          }
        }

        return process(str.slice(1), model.slice(2));
      } else {
        return process(str.slice(1), model.slice(1));
      }
    } else if (model.length > 1 && model[1] === '*') {
      for (let i = 0; i < str.length; i++) {
        if (str[i] !== str[0]) {
          return process(str.slice(i), model.slice(2));
        }
      }
    }

    return false;
  }

  return process(str, model);
}


const isMatch = (str, model) => {
  if (str.length === 0) {
    return model.length === 0 || model === '.*';
  }

  if (model.length === 0) {
    return false;
  }

  let firstMatch = str[0] === model[0] || model[0] === '.';

  if (firstMatch) {
    if (model[1] === '*') {
      return isMatch(str.slice(1), model);
    } else {
      return isMatch(str.slice(1), model.slice(1));
    }
  }

  return model[1] === '*' && isMatch(str.slice(1), model);
};
