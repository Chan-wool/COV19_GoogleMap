package com.example.googlemapex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;

public class RankingActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    private String value = "";
    final static int[] valueTemp = new int[6];
    final String[] localSave = new String[6];





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        /*A.음식점
        B.유흥주점
        C.PC방/노래방
        D.종교시설
        E.카페
        F.기타*/

        localSave[0]="음식점";
        localSave[1]="유흥주점";
        localSave[2]="PC방/노래방";
        localSave[3]="종교시설";
        localSave[4]="카페";
        localSave[5]="기타 시설";
        int i  = 1;



        for(;;) {
            String str = Integer.toString(i);

            databaseReference.child("patient").child(str).child("local").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    value = snapshot.getValue(String.class);
                    if(value.compareTo("A")==0) {
                        valueTemp[0]++;
                        databaseReference.child("local").child("A").setValue(valueTemp[0]);
                    }
                    if(value.compareTo("B")==0) {
                        valueTemp[1]++;
                        databaseReference.child("local").child("B").setValue(valueTemp[1]);
                    }
                    if(value.compareTo("C")==0) {
                        valueTemp[2]++;
                        databaseReference.child("local").child("C").setValue(valueTemp[2]);
                    }
                    if(value.compareTo("D")==0) {
                        valueTemp[3]++;
                        databaseReference.child("local").child("D").setValue(valueTemp[3]);
                    }
                    if(value.compareTo("E")==0) {
                        valueTemp[4]++;
                        databaseReference.child("local").child("E").setValue(valueTemp[4]);
                    }
                    if(value.compareTo("F")==0) {
                        valueTemp[5]++;
                        databaseReference.child("local").child("F").setValue(valueTemp[5]);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });
            i++;
            if(i>79) {

                databaseReference.child("local").child("A").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        valueTemp[0]=(int)snapshot.getValue(Integer.class);
                        TextView textView1 = (TextView) findViewById(R.id.textView1);
                        textView1.setTextColor(Color.parseColor("#ffff0000"));
                        textView1.setText(" "+localSave[0] +" "+ valueTemp[0]+"명");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                databaseReference.child("local").child("B").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        valueTemp[1]=(int)snapshot.getValue(Integer.class);
                        TextView textView2 = (TextView) findViewById(R.id.textView2);
                        textView2.setTextColor(Color.parseColor("#ff320000"));
                        textView2.setText(" "+localSave[1] +" "+ valueTemp[1]+"명");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                databaseReference.child("local").child("C").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        valueTemp[2]=(int)snapshot.getValue(Integer.class);
                        TextView textView3 = (TextView) findViewById(R.id.textView3);
                        textView3.setTextColor(Color.parseColor("#ffffff00"));
                        textView3.setText(" "+localSave[2] +" "+ valueTemp[2]+"명");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                databaseReference.child("local").child("D").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        valueTemp[3]=(int)snapshot.getValue(Integer.class);
                        TextView textView4 = (TextView) findViewById(R.id.textView4);
                        textView4.setTextColor(Color.parseColor("#ff00ff00"));
                        textView4.setText(" "+localSave[3] +" "+ valueTemp[3]+"명");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                databaseReference.child("local").child("E").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        valueTemp[4]=(int)snapshot.getValue(Integer.class);
                        TextView textView5 = (TextView) findViewById(R.id.textView5);
                        textView5.setTextColor(Color.parseColor("#ff0000ff"));
                        textView5.setText(" "+localSave[4] +" "+ valueTemp[4]+"명");
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });

                databaseReference.child("local").child("F").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        valueTemp[5]=(int)snapshot.getValue(Integer.class);
                        TextView textView6 = (TextView) findViewById(R.id.textView6);
                        textView6.setTextColor(Color.parseColor("#ff000546"));
                        textView6.setText(" "+localSave[5] +" "+ valueTemp[5]+"명");
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });

                databaseReference.child("local").child("A").setValue(0);
                databaseReference.child("local").child("B").setValue(0);
                databaseReference.child("local").child("C").setValue(0);
                databaseReference.child("local").child("D").setValue(0);
                databaseReference.child("local").child("E").setValue(0);
                databaseReference.child("local").child("F").setValue(0);



               /* TextView textView2 = (TextView) findViewById(R.id.textView2);
                textView2.setText("2위 : "+localSave[1] +" "+ valueTemp[1]+"명");

                TextView textView3 = (TextView) findViewById(R.id.textView3);
                textView3.setText("3위 : "+localSave[2] +" "+ valueTemp[2]+"명");

                TextView textView4 = (TextView) findViewById(R.id.textView4);
                textView4.setText("4위 : "+localSave[3] +" "+ valueTemp[3]+"명");

                TextView textView5 = (TextView) findViewById(R.id.textView5);
                textView5.setText("5위 : "+localSave[4] +" "+ valueTemp[4]+"명");*/

                break;
            }
        }



    }


}