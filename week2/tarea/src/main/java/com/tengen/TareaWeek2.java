/*


mongoimport -d students -c grades < grades.json

use students
show collections
db.grades.drop()
db.grades.find().pretty()





- Eliminar la calificación de tipo "tarea" con la puntuación más baja, para cada estudiante se debe eliminar un documento por estudiante.

Sugerencia: Si selecciona tareas grado-documentos, ordenar por estudiante y luego por puntuación,
se puede recorrer y descubrir la puntuación más baja para cada estudiante al notar un cambio en la identificación del estudiante.
Como se nota que el cambio de student_id, retire el documento.

mvn compile exec:java -Dexec.mainClass=com.tengen.TareaWeek2

-----
import org.bson.types.ObjectId;

        ObjectId Id    = new ObjectId();
        ObjectId IdAnt = new ObjectId();


-----


db.grades.find(type:"student_id");

db.grades.find({ type:"student_id"}).pretty();

db.grades.find({"student_id" : true});

db.grades.find({ type:"homework"}).sort({"student_id" : -1 },{"score" : -1 }).pretty();

db.grades.find({ type:"homework"}).sort({"student_id" : -1 , "score" : -1 }).pretty(); ok

db.grades.find({ type:"homework"}).sort({"student_id" : 1 , "score" : 1 }).pretty();

db.grades.find({ type:"homework"}).sort({"student_id" : -1}).pretty();

db.grades.find({ type:"homework"}).sort($and:[{"student_id" : -1} , {"score" : -1 }]).pretty(); ok

db.grades.find({ type:"homework"}).sort({$and:[{"student_id" : -1},{"score" : -1 }]}).pretty(); Puede ser

db.grades.find({ type:"homework"}).sort({$and : ["student_id" : -1 },{"score" : -1 }}).pretty();
db.grades.find({ type:"homework"}).pretty();
db.grades.find({ type:"homework"}).pretty();

db.grades.find({"student_id" : 0 }).pretty()
db.grades.find({"student_id" : 9 }).pretty() // Del:55 ok:86.678
db.grades.find({"student_id" : 19 }).pretty() // Del:52 ok:97.717

--

        Integer codigo = (Integer)cursor.next().get("student_id");
        System.out.println(codigo);

        Integer codant = (Integer)cursor.next().get("student_id");
        System.out.println(codant);


        try {
          while (cursor.hasNext()) {


        codigo = (Integer)cursor.next().get("student_id");

        if (codigo != codant){
           System.out.println("cambio:");
           System.out.println(codigo);
           System.out.println(codant);
           codant = codigo;
        }



              DBObject cur = cursor.next();

              System.out.println(cur.get("student_id"));
              System.out.println(cur.get("type"));
              System.out.println(cur.get("score"));


              System.out.println(cur);
          }
        } finally {
            cursor.close();
        }


--
collection.remove(new BasicDBObject("_id", "frank"));

---

/*
        System.out.println(Id.toString());
        System.out.println(codigo);
        System.out.println(cursor.next().get("student_id"));
        System.out.println(cursor.next().get("type"));
        System.out.println(cursor.next().get("score"));

        System.out.println("Borrar:");
        System.out.println(cursor.next().get("_id"));
        
db.scores.find({ type:"essay", score:50}, {student:true,_id:false});


*/

package com.tengen;


/*
import org.bson.types.ObjectId;
*/



import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;





import java.net.UnknownHostException;

public class TareaWeek2 {

    public static void main(String[] args) throws UnknownHostException {

        MongoClient client = new MongoClient();

        DB db = client.getDB("students");
        DBCollection collection = db.getCollection("grades");

        BasicDBObject query = new BasicDBObject();
        query.put("type","homework");

        BasicDBObject filtro = new BasicDBObject();
        filtro.put("_id",false);
        filtro.put("student_id",true);
        filtro.put("score",true);
//        filtro = null;
        DBCursor cursor = collection.find(query,filtro);

        BasicDBObject ordenar = new BasicDBObject();
        ordenar.put("student_id", 1);
        ordenar.put("score", 1);
//        ordenar = null;
        cursor.sort(ordenar);

        Integer codigo = (Integer)cursor.next().get("student_id");
        Integer codAnt = (Integer)cursor.next().get("student_id");

/*
        ObjectId Id = (ObjectId)cursor.next().get("_id");
        collection.remove(new BasicDBObject("_id", Id));
*/


        try {
          while (cursor.hasNext()) {


              DBObject cur = cursor.next();

/*

              codigo = (Integer)cur.get("student_id");

              if (codigo != codAnt ){

                 codAnt = codigo;

                 Id = (ObjectId)cur.get("_id");
                 collection.remove(new BasicDBObject("_id", Id));

              }
*/

              System.out.println(cur);
// printjson(cur);

          }
        } finally {
            cursor.close();
        }


    }

}
