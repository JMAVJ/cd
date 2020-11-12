function squareValue(x){
   // your code here
   let newArray = [];
   for(let i=0; i<x.length; i++){
     newArray.push(x[i]*x[i]);
   }
   return newArray;
}
y = squareValue([1,2,3]);
console.log(y); // should log [1,4,9]
  
y = squareValue([2,5,8]);
console.log(y); // should log [4,25,64]