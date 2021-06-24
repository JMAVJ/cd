class Ninja {
  constructor(name, health, speed=3, strength=3) {
    this.name = name
    this.health = health
    this.speed = speed
    this.strength = strength
  }

  sayName() {
    console.log(this.name)
  }

  showStats() {
    console.log(`Name: ${this.name}`)
    console.log(`Strength: ${this.strength}`)
    console.log(`Speed: ${this.speed}`)
    console.log(`Health: ${this.health}`)
  }

  drinkSake() {
    this.health += 10
  }
}

module.exports = {
  Ninja
}