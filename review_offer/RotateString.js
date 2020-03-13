const Resolution = (str, k) => {
  return str.substring(k) + str.substring(0, k);
};

const Resolution2 = (str) => {
  let wordArray = str.split(' ');
  return wordArray.reduceRight((pre, cur) => {
    return pre + ' ' + cur;
  }, '');
};

console.log(Resolution2('I am Weybn'))
