// dojo = 'san jose';
// console.log(dojo);
// learn();
// function learn() {
//   dojo = 'seattle';
//   console.log(dojo);
//   var dojo = 'burbank';
//   console.log(dojo);
// }
// console.log(dojo);

// Output: san jose
//         seattle
//         burbank
//         san jose

var dojo;
function learn() {
  var dojo;
  dojo = 'seattle';
  console.log(dojo);
  dojo = 'burbank';
  console.log(dojo);
}

dojo = 'san jose';
console.log(dojo);
learn();
console.log(dojo);
