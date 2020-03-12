const isUndef = tar => typeof tar === 'undefined' || tar === null;

const isDef = tar => !isUndef(tar);

module.exports = {
  isUndef,
  isDef
};
