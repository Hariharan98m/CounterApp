package io.hasura.counter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button inc, dec, reset;
    private TextView counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCounter(getApplicationContext().getSharedPreferences("saved_counter",MODE_PRIVATE).getInt("counter",0));

        setValues();

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_counter(getApplicationContext().getSharedPreferences("saved_counter",MODE_PRIVATE));
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dec_counter(getApplicationContext().getSharedPreferences("saved_counter",MODE_PRIVATE));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_counter(getApplicationContext().getSharedPreferences("saved_counter",MODE_PRIVATE));
            }
        });

    }

    private void inc_counter(SharedPreferences s) {
        setCounter(Integer.parseInt(counter.getText().toString())+1);
        s.edit().putInt("counter",s.getInt("counter",0)+1);
    }

    private void dec_counter(SharedPreferences s) {
        setCounter(Integer.parseInt(counter.getText().toString())-1);
        s.edit().putInt("counter",s.getInt("counter",0)-1);
    }

    private void reset_counter(SharedPreferences s) {
        setCounter(0);
        s.edit().putInt("counter",0);
    }


    private void setValues() {
        inc= (Button) findViewById(R.id.inc);
        dec= (Button) findViewById(R.id.dec);
        reset= (Button) findViewById(R.id.reset);
    }


    private void setCounter(int count) {
        counter= (TextView)(findViewById(R.id.counter));
        counter.setText(count);
    }
}
