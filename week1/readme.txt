mongod --dbpath D:\data\db
mongod --dbpath D:\javadat\mongodb-data\database --repair
http://localhost:8089/
--
db
use test
show collections
db.custumer.find() - Muestra los registros
db.custumer.remove() - Elimina los registros
db.dropDatabase()

D:\javabin\mongodb\bin


db.hw1.findOne()


{'name':'Fred Flintstone';'occupation':'Miner';'wife':'Wilma'} X

{'title':'Star Wars', 'quotes':['Use The Force','These are not the Droids you are looking for'],'director':'George Lucas'} OK

{} OK

{'city':'New York', 'population', 7999034, boros:{'queens', 'manhattan', 'staten island', 'the bronx', 'brooklyn'}} X

{'a':1, 'b':{'b':1, 'c':'foo', 'd':'bar', 'e':[1,2,4]}} OK


db.pruebas.insert()

{'title':'Star Wars', 'quotes':['Use The Force','These are not the Droids you are looking for'],'director':'George Lucas'}

db.pruebas.insert({'title':'Star Wars', 'quotes':['Use The Force','These are not the Droids you are looking for'],'director':'George Lucas'})

db.pruebas.insert({})

db.pruebas.insert({'city':'New York', 'population', 7999034, boros:{'queens', 'manhattan', 'staten island', 'the bronx', 'brooklyn'}})

db.pruebas.insert({'a':1, 'b':{'b':1, 'c':'foo', 'd':'bar', 'e':[1,2,4]}})

----

mvn compile exec:java -Dexec.mainClass=com.tengen.Week1Homework3
mvn compile exec:java -Dexec.mainClass=com.tengen.Week1Homework4