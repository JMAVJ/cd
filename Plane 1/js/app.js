var player = {
    left: 450,
    top: 620
}

var enemies = [
    {left: 100, top: 200},
    {left: 450, top: 250}
]

function renderPlayer(){
    const content = `<div class='player' style='top: ${player.top}px; left: ${player.left}px' ></div>`
    document.getElementById('players').innerHTML = content;
}

function renderEnemies(){
    enemies.forEach(enemy => {
        const content = `<div class='enemy' style='top: ${enemy.top}px; left: ${enemy.left}px'></div>`
        document.getElementById('enemies').innerHTML += content;
    })
}

//Initialization
renderPlayer();
renderEnemies();

document.onkeydown = (e) => {
    const key = e.key;
    switch (key){
        case 'ArrowLeft':
            player.left -= 10;
            break;
        case 'ArrowUp':
            player.top -= 10;
            break
        case 'ArrowRight':
            player.left += 10;
            break;
        case 'ArrowDown':
            player.top += 10;
            break;
    }
    renderPlayer();
} 