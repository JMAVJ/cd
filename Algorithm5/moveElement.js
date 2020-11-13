function moveElement(arr) {
  let newArr = [];
  for (let i=1; i<arr.length; i++) {
    newArr.push(arr[i]);
  }
  newArr.push(0);
  return newArr;
}

console.log(moveElement([1,2,3]));