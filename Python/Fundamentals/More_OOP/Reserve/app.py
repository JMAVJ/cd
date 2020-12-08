from Reserve import Reserve

reserve = Reserve('Buin Zoo')
reserve.add_lion('Kimba', 2).add_tiger('Pedro', 1)
reserve.get_animals()

reserve.animals['Kimba'].feed()