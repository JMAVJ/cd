var player = {
    left: 450,
    top: 620
}

var enemies = [
    {left: 100, top: 250, },
    {left: 200, top: 250},
    {left: 300, top: 250},
    {left: 400, top: 250},
    {left: 500, top: 250},
    {left: 600, top: 250}
]

var projectiles = [];

function renderPlayer(){
    const content = `<div class='player' id='player' style='top: ${player.top}px; left: ${player.left}px' ></div>`
    document.getElementById('players').innerHTML = content;
}

function renderEnemies(){
    let content = "";
    for(let i=0; i<enemies.length; i++){
        content += `<div class='enemy' style='top: ${enemies[i].top}px; left: ${enemies[i].left}px'></div>`
    }
    document.getElementById('enemies').innerHTML = content;
}

function renderProjectiles(){
    let content = "";
    for(let i=0; i<projectiles.length; i++){
        content += `<div class='projectile' style='left: ${projectiles[i].left}px; top: ${projectiles[i].top}px'></div>`
    }
    document.getElementById('projectiles').innerHTML = content;
}

function updateEnemyPosition(){
    enemies.forEach(enemy => {
        enemy.style.top = `${enemy.top}px`;
    })
}

renderPlayer();
const backgroundHeight = document.getElementById('background').offsetHeight;
const backgroundWidth = document.getElementById('background').offsetWidth;

const playerHeight = document.getElementById('player').offsetHeight;
const playerWidth = document.getElementById('player').offsetWidth;

/*
function checkEnemyPosition(){
    enemies.forEach(enemy => {
        if(enemy.top >= backgroundHeight){
             
        }
    })
}
*/

function moveEnemies(){
    enemies.forEach(enemy => {
        enemy.top += 5;
    })
}

function moveProjectiles(){
    for(let i=0; i<projectiles.length; i++){
        projectiles[i].top -= 15;
    }
}

document.onkeydown = (e) => {
    const key = e.key;

    switch (key){
        case 'ArrowLeft':
            if (player.left <= 20) {
                break;
            }
            player.left -= 10;
            break;
        case 'ArrowUp':
            if (player.top <= backgroundHeight - (backgroundHeight/3)) {
                break;
            }
            player.top -= 10;
            break
        case 'ArrowRight':
            if (player.left >= backgroundWidth - playerWidth) {
                break;
            }
            player.left += 10;
            break;
        case 'ArrowDown':
            if (player.top >= backgroundHeight - playerHeight) {
                break;
            }
            player.top += 10;
            break;
    }
    
    if (key == 'x') {
        projectiles.push({left: (player.left+34), top: (player.top-8)});
    }

    renderPlayer();
} 

function gameLoop(){
    moveEnemies();
    renderEnemies();

    moveProjectiles();
    renderProjectiles();
    
    setTimeout(gameLoop, 50);
}

gameLoop();
