// let counts = read_line().split(' ');
// let data = read_line().split(' ').map(item => parseInt(item));
// let len = parseInt(counts[0]);
// let x = parseInt(counts[1]);
let len = 5;
let x = 2;
let data = [3, 1, 3, 2, 5];

let map = new Map();
let maxCount = 0;

// for (let i = 0; i < data.length; i++) {
//   let item = data[i];
//   if (!map.has(item)) {
//     map.set(item, 1);
//   } else {
//     map.set(item, map.get(item) + 1);
//   }
// }

let container = data.concat();

for (let i = 0; i < container.length; i++) {
  container[i] |= x;
}

console.log(container)

for (let i = 0; i < container.length; i++) {
  if (map.has(container[i])) {
    map.set(container[i], map.get(container[i]) + 1);
  } else {
    map.set(container[i], 1);
  }
  // maxCount = map.get(container[i]);
}

for (let item of map) {
  maxCount = maxCount > item[1] ? maxCount : item[1];
}

console.log(maxCount);
