document.addEventListener('DOMContentLoaded', () => {
  const section = document.querySelector('section');
  for(let i=1; i<=32; i++){
    section.innerHTML += 
    `<div class="pokemon">
      <h1>Pokemon Number ${i}</h1>
      <img 
        src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/${i}.png"
        alt="Pokemon number ${i} image"
        >
     </div>`;
  }
})


