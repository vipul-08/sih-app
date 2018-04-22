package sih.com.sih;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import sih.com.sih.Adapters.ProgressAdapter;
import sih.com.sih.Modals.Stage;

public class TrackActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Stage> list;
    ProgressAdapter adapter;
    DatabaseReference ref;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        spinner = findViewById(R.id.spinner);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        ref = FirebaseDatabase.getInstance().getReference().child("sih").child("5285");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int numBags = dataSnapshot.child("numberOfBags").getValue(Integer.class);
                arrayAdapter.clear();
                for(int m = 0 ;m <numBags ; m++) {
                    arrayAdapter.add("Bag "+(m+1));
                    arrayAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myMethod();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                myMethod();
            }
        });
    }

    void myMethod() {

        list = new ArrayList<>();

        adapter = new ProgressAdapter(TrackActivity.this,list);

        recyclerView = findViewById(R.id.recycler_progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(TrackActivity.this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        ref = FirebaseDatabase.getInstance().getReference().child("sih").child("5285").child(String.valueOf(spinner.getSelectedItemPosition())).child("Status");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Stage stage = dataSnapshot.getValue(Stage.class);
                if (dataSnapshot.getKey().toString().equals("1")) {
                    list.add(0,stage);
                }
                else if(dataSnapshot.getKey().toString().equals("2")) {
                    list.add(1,stage);
                }
                else if (dataSnapshot.getKey().toString().equals("3")) {
                    list.add(2,stage);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Stage stage = dataSnapshot.getValue(Stage.class);
                if (dataSnapshot.getKey().toString().equals("1")) {
                    list.remove(0);
                    list.add(0,stage);
                }
                else if(dataSnapshot.getKey().toString().equals("2")) {
                    list.remove(1);
                    list.add(1,stage);
                }
                else if (dataSnapshot.getKey().toString().equals("3")) {
                    list.remove(2);
                    list.add(2,stage);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}