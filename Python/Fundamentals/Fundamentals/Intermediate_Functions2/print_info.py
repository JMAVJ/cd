def get_dict_info(d):
    for key in d:
        print(f'{len(d[key])} {key.upper()}')
        for i in d[key]:
            print(i)


dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

get_dict_info(dojo)