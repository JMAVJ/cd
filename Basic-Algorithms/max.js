function max(arr) {
  let max = arr[1];
  for (let i=1; i<arr.length; i++) {
    if (arr[i] > max) { max = arr[i] };
  }
  return max;
}

console.log(max([-3,3,5,7]));