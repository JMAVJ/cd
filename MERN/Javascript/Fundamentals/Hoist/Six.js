// console.log(genre);
// var genre = 'disco';
// rewind();
// function rewind() {
//   genre = 'rock';
//   console.log(genre);
//   var genre = 'r&b';
//   console.log(genre);
// }
// console.log(genre);

// Output: undefined
//         rock
//         r&b
//         disco

var genre;
function rewind() {
  var genre;
  genre = 'rock';
  console.log(genre);
  genre = 'r&b';
  console.log(genre);
}

console.log(genre);
genre = 'disco';
rewind();
console.log(genre);
