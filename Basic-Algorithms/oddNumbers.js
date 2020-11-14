function getOdd() {
  let newArr = [];
  for (let i=0; i<=50; i++) {
    if (i % 2 != 0) {
      newArr.push(i);
    }
  }
  return newArr;
}

console.log(getOdd());