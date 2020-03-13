let info = read_line().split(' ').map(item => parseInt(item));
let n = info[0];
let m = info[1];
let k = info[2];
let add = read_line().split(' ').map(item => parseInt(item));

let arr = [];
for (let i = 0; i < m; i++) {
  arr.push(read_line().split(' ').map(item => parseInt(item)));
}

let arrList = new Array(n);

for (let i = 0; i < arrList.length; i++) {
  arrList[i] = [];
}

for (let i = 0; i < arr.length; i++) {
  arrList[arr[i][0]].push(arr[i][1]);
}

let result = [];

for (let i = 0; i < add.length; i++) {
  let count = 0;
  let needTable = new Array(k).fill(1);


}
