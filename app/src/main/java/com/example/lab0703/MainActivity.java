package com.example.lab0703;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = this.findViewById(R.id.testview01);
        tv2 = this.findViewById(R.id.testviewo2);
        button = this.findViewById(R.id.bt1);
//        final SetLabelTask t3 = new SetLabelTask();
        for (int i =0;i<50;i++){
           new SetLabelTask().execute(i+1);

//           t3.execute(i+1);

        }
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new SetLabelTask().towait();
                //new ui thread
                for (int i =0;i<50;i++){

                    new SetLabelTask().execute(i+1);

                }
            }
        });

    }

     class SetLabelTask extends AsyncTask<Integer,Void,Integer> {

//        int count = 1;
        // 子线程
        @Override
        protected Integer doInBackground(Integer... integers) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return integers[0];
        }

        public void towait(){
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
         }
        //UI线程
        @Override
        protected void onPostExecute(Integer i){

            if(i%2==0){
                tv1.setTextColor(Color.parseColor("#FF0000"));
                tv2.setTextColor(Color.parseColor("#0000FF"));
//                count = count*-1;
            }
            else {
                tv2.setTextColor(Color.parseColor("#FF0000"));
                tv1.setTextColor(Color.parseColor("#0000FF"));
//                count = count*-1;

            }

        }
    }

}
