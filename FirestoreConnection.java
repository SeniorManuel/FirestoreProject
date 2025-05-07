package org.example;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import javax.swing.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirestoreConnection extends JFrame {
    Firestore db;
    public FirestoreConnection() {
        db = null;
        try {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("ecpe205-flores-firebase-adminsdk-fbsvc-7d8d98ecab.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://console.firebase.google.com/project/ecpe205-flores/database/ecpe205-flores-default-rtdb/data/~2F")
                    .build();
            FirebaseApp.initializeApp(options);

            db = FirestoreClient.getFirestore();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//     public void addScoreToEmmanuel(int raw, int total) {
//         DocumentReference docRef = db.collection("Emmanuel Clyde Flores").document("ZSWF0RRqmeQjyuMahRfP");
//
//         Map<String, Object> score = new HashMap<>();
//         score.put("raw", raw);
//         score.put("total", total);
//
//         ApiFuture<WriteResult> future = docRef.update("scores", FieldValue.arrayUnion(score));
//         try {
//             future.get();
//             System.out.println("Score added!");
//         } catch (InterruptedException | ExecutionException e) {
//             e.printStackTrace();
//         }
//     }

    public void addPerson(String raw, String total) {
        Map<String, Object> person = new HashMap<>();
//        person.put("firstName", firstName);
//        person.put("lastName", lastName);
        person.put("rawScore", raw);
        person.put("totalScore", total);

        ApiFuture<DocumentReference> result = db.collection("Juan de La Cruz").add(person);

        try {
            System.out.println("Added document with ID: " + result.get().getId());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

//    public ArrayList<Person> getAllPersons() {
//        ArrayList<Person> persons = new ArrayList<>();
//        try {
//            ApiFuture<QuerySnapshot> query = db.collection("persons").get();
//            List<QueryDocumentSnapshot> documents = query.get().getDocuments();
//            for (QueryDocumentSnapshot document : documents) {
//                String firstName = document.getString("firstName");
//                String lastName = document.getString("lastName");
//                persons.add(new Person(firstName, lastName));
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        return persons;
//    }