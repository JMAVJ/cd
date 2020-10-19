var player = {
    left: 450,
    top: 620
}

var enemies = [
    {left: 100, top: 250},
    {left: 200, top: 250},
    {left: 300, top: 250},
    {left: 400, top: 250},
    {left: 500, top: 250},
    {left: 600, top: 250}
]

function renderPlayer(){
    const content = `<div class='player' id='player' style='top: ${player.top}px; left: ${player.left}px' ></div>`
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
    const backgroundHeight = document.getElementById('background').offsetHeight;
    const playerHeight = document.getElementById('player').offsetHeight;

    switch (key){
        case 'ArrowLeft':
            player.left -= 10;
            break;
        case 'ArrowUp':
            if (player.top <= backgroundHeight - (backgroundHeight/3)) {
                break;
            }
            player.top -= 10;
            break
        case 'ArrowRight':
            player.left += 10;
            break;
        case 'ArrowDown':
            if (player.top >= backgroundHeight - playerHeight) {
                break;
            }
            player.top += 10;
            break;
    }
    
    renderPlayer();
} 