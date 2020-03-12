const isUndef = tar => typeof tar === 'undefined' || tar === null;

const isDef = tar => !isUndef(tar);

const resolution = (str) => {
  if (isUndef(str) || str.length === 0) {
    return '';
  }

  let spaceCount = 0;
  let newStrArray = [];

  for (let i = 0; i < str.length; i++) {
    if (str[i] === ' ') {
      newStrArray.push('%20');
    } else {
      newStrArray.push(str[i]);
    }
  }

  return newStrArray.join('');
}

console.log(resolution('I am Weybn'));
