function squareValues(arr) {
  let squared = [];
  for (let i=0; i<arr.length; i++) {
    squared.push(arr[i] * arr[i]);
  }
  return squared;
}

console.log(squareValues([1,5,10,-2]));