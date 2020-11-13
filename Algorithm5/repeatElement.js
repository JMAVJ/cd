function repeatElement(arr) {
  let newArr = [];
  for (let i=0; i<arr.length; i++) {
    newArr.push(arr[i]);
    newArr.push(arr[i]);
  }
  return newArr;
}

console.log(repeatElement([4,"Ulysses", 42, false]));