def iterate_dict_list(ls):
    for d in ls:
        output = []
        for key in d:
            output.append(f'{key} - {d[key]}')
        print(', '.join(output))

students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

iterate_dict_list(students)
