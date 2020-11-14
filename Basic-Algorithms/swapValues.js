function swapValues(arr) {
  let temp = arr[0];
  arr[0] = arr[arr.length-1];
  arr[arr.length-1] = temp;
  return arr;
}

console.log(swapValues([1,5,10,-2]));