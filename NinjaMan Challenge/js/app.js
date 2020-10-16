

function generateMap(rows, cols){
    /*
    Generating map completely randomly, could implement recursive backtracking
    for maze generation in the future (now i ran out of time).
    So the generated map will have some errors like trapped ghosts and sushis that are 
    impossible to get to.
    */
    let output = [];

    //Row Control
    for (let row=0; row<rows; row++) {
        let arr = [];

        //Create walls for the edges
        if (row == 0 || row == rows-1) {
            for (let i=0; i<=cols-1; i++) {
                arr.push(1);
            }
            output.push(arr);
            continue;
        }

        //Column Control
        for (let col=0; col<cols-1; col++) {
            if (col == 0) {
                arr.push(1);
                continue;
            }
            arr.push(Math.floor(Math.random() * (3 - 1 + 1)) + 1);
        }
        arr[cols] = 1;
        output.push(arr);
    }
    return output;
}

var grid = generateMap(15, 15);

const gridElements = {
    0: 'blank',
    1: 'wall',
    2: 'sushi',
    3: 'onigiri'
};

const scoreElement = document.getElementById('score');
const livesElement = document.getElementById('lives');

//Character class to define entities like the ninja and ghosts
class Character {
    constructor(x=7, y=7, id='ninja') {
        this.x = x;
        this.y = y;
        this.score = 0;
        this.lives = 3;
        this.element = document.getElementById(id);
        this.lastPath;
    }
}

ninja = new Character;
bluey = new Character(1,1,'bluey');
red = new Character(13, 13, 'red');

const entities = [ninja, bluey, red];
const ghosts = [red, bluey];


function renderMap(){
    const world = document.getElementById('world');
    let map = "";
    for(let row=0; row < grid.length; row++){
        map += "<div class='row'>";
        for(let i=0; i < grid[row].length; i++){
            map += `<div class='${gridElements[grid[row][i]]}'></div>`;
        }
        map += "</div>";
    }
    world.innerHTML = map; 
}

//Set or Update Entities Position
function setEntityPosition(){
    for(let i=0; i < entities.length; i++) {
        let entity = entities[i];
        entity.element.style.left = `${entity.x * 40}px`
        entity.element.style.top = `${entity.y * 40}px`
    }
}

function initialize(){
    ninja.element.style.transform = 'rotate(-90deg)';
    setEntityPosition();
    renderMap();
}

//Check if the position of the ninja is equal to the position of a ghost
function entityCollision() {
    let position = `${[ninja.x, ninja.y]}`;
    switch (position) {
        case `${[bluey.x, bluey.y]}`:
            return true;
        case `${[red.x, red.y]}`:
            return true;
        default:
            return false;
    }
}

function gameOver() {
    const scoreboard = document.getElementById('scoreboard');
    scoreboard.innerHTML = 'Game Over!';
}

document.addEventListener('DOMContentLoaded', function() {
    //Initialize the map and entities
    initialize();

    //Game Loop
    var direction = 'ArrowUp';
    function startGame(){
        setInterval(() => {
            //Make the game end if the ninja runs out of lives
            if (ninja.lives <= 0) {
                return gameOver();
            }

            //Ninja Continuous Movement
            if (direction == 'ArrowLeft' && grid[ninja.y][ninja.x-1] != 1) {
                ninja.x--;
            } else if (direction == 'ArrowRight' && grid[ninja.y][ninja.x+1] != 1) {
                ninja.x++;
            } else if (direction == 'ArrowUp' && grid[ninja.y-1][ninja.x] != 1) {
                ninja.y--;
            } else if (direction == 'ArrowDown' && grid[ninja.y+1][ninja.x] != 1) {
                ninja.y++;
            }

            //Check if the ninja is over a sushi
            if (grid[ninja.y][ninja.x] == 2 || grid[ninja.y][ninja.x] == 3) {
                if (grid[ninja.y][ninja.x] == 2){
                    ninja.score += 10; //Sushi gives 10 score?
                } else {
                    ninja.score += 5;
                }
                scoreElement.innerHTML = `Score: ${ninja.score}`;
                grid[ninja.y][ninja.x] = 0;
                renderMap();
            }

            //Ghosts Movement (not the smartest ones for now)
            ghosts.forEach((ghost) =>{
                let possiblePaths = [
                    grid[ghost.y][ghost.x-1], 
                    grid[ghost.y-1][ghost.x], 
                    grid[ghost.y][ghost.x+1],
                    grid[ghost.y+1][ghost.x]
                ];
                let indexes = [];
                for (let i=0; i < possiblePaths.length; i++) {
                    if (possiblePaths[i] != 1) {
                        indexes.push(i);
                    }
                }

                let path = indexes[Math.floor(Math.random() * indexes.length)];
                switch (path){
                    case 0:
                        ghost.x--;
                        break;
                    case 1:
                        ghost.y--;
                        break;
                    case 2:
                        ghost.x++;
                        break;
                    case 3:
                        ghost.y++;
                        break;
                }
                ghost.lastPath = path;
            })
            
            //Check if the Ninja is over a Ghost
            if (entityCollision()) {
                ninja.lives--;
                livesElement.innerHTML = `Lives: ${ninja.lives}`;
            }

            //Update the entities position
            setEntityPosition();
        }, 200)
    }

    //Key Event Listener
    document.onkeydown = (e) => {
        const key = e.key; //Now using .key because .keyCode is deprecated

        if (key == 'ArrowLeft' && grid[ninja.y][ninja.x-1] != 1) {
            ninja.element.style.transform = 'scaleX(-1)';
            direction = key;
        } else if (key == 'ArrowRight' && grid[ninja.y][ninja.x+1] != 1) {
            ninja.element.style.transform = 'scaleX(1)';
            direction = key;
        } else if (key == 'ArrowUp' && grid[ninja.y-1][ninja.x] != 1) {
            ninja.element.style.transform = 'rotate(-90deg)';
            direction = key;
        } else if (key == 'ArrowDown' && grid[ninja.y+1][ninja.x] != 1) {
            ninja.element.style.transform = 'rotate(90deg)';
            direction = key;
        }
    }

    //Button Click Events
    const startButton = document.getElementById('start');
    const newMapButton = document.getElementById('regenerateMap');
    const originalMapButton = document.getElementById('originalMap');

    startButton.onclick = () => {
        startGame();
        startButton.disabled = true;
        newMapButton.disabled = true;
        originalMapButton.disabled = true;
    }

    newMapButton.onclick = () => {
        grid = generateMap(15, 15);
        renderMap();
    }

    originalMapButton.onclick = () => {
        grid = [
        [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
        [1,3,2,2,2,2,2,2,2,2,2,2,2,3,1],
        [1,2,1,1,2,1,1,2,1,1,2,1,1,2,1],
        [1,2,2,2,2,1,1,2,1,1,2,2,2,2,1],
        [1,2,1,1,2,1,1,2,1,1,2,1,1,2,1],
        [1,2,2,2,2,2,2,2,2,2,2,2,2,2,1],
        [1,1,2,1,1,2,1,2,1,2,1,1,2,1,1],
        [1,2,2,2,2,2,2,0,2,2,2,2,2,2,1],
        [1,1,1,2,1,1,1,2,1,1,1,2,1,1,1],
        [1,2,2,2,2,2,2,2,2,2,2,2,2,2,1],
        [1,2,1,1,1,2,1,2,1,2,1,1,1,2,1],
        [1,2,1,1,1,2,2,2,2,2,1,1,1,2,1],
        [1,2,1,1,1,2,1,2,1,2,1,1,1,2,1],
        [1,3,2,2,2,2,2,2,2,2,2,2,2,3,1],
        [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
    ];
    renderMap();
    }


})