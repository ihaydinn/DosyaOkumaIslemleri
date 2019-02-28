package com.ismailhakkiaydin.dosyaokumaislemleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        File file = new File(this.getFilesDir(), "Deneme.txt");

        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String output = " ", line = " ";

            for (;;){
                line = br.readLine();
                if (line != null){
                    output += line + "\n\r";
                }
                break;
            }

            br.close();
            isr.close();
            fis.close();

            TextView textView = new TextView(this);
            textView.setText(output);
            this.setContentView(textView);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
