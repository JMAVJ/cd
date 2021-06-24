const { Ninja } = require('./ninja.js');


class Sensei extends Ninja {
  constructor(name, health=200, speed=10, strength=10, wisdom=10) {
    super(name, health, speed, strength)
    this.wisdom = wisdom
  }

  speakWisdom() {
    super.drinkSake()
    console.log("wise stuff")
  }
}


s = new Sensei('sensei')
s.showStats()
s.speakWisdom()
s.showStats()