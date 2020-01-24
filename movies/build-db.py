import json

src='./search/movies.json'
trgt='./search/movies-new.json'
details_folder='./details/'
count=0

with open(src) as sfile:
    data=json.load(sfile)
    for rec in data['Search']:
        count+=1
        id=rec['imdbID']
        details_path= '{}{}.json'.format(details_folder,id)
        with open(details_path) as dfile:
            details=json.load(dfile)
            rating=details['imdbRating']
        rec['imdbRating']=rating
        rec['Poster']='/images/{}.jpg'.format(id);

with open(trgt,'w') as tfile:
    json.dump(data,tfile)

print('{} records updated'.format(count))
