sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}

for key in sports_directory:
    for i in sports_directory[key]:
        if i == 'Messi':
            sports_directory[key][sports_directory[key].index(i)] = 'Andres'

print(sports_directory)