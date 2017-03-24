package com.example.abhishekyadav.remort;

import android.net.rtp.AudioStream;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class first extends AppCompatActivity {
EditText ip;
EditText sentmsg;
ImageButton sent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        sent=(ImageButton)findViewById(R.id.sent);
        sentmsg=(EditText) findViewById(R.id.sentmsg);
        ip=(EditText) findViewById(R.id.ip);
        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg msg=new msg();
                Thread thread =new Thread(msg);
                thread.start();
            }
        });



    }


    class msg implements Runnable

    {

        @Override
        public void run() {
            String ip1=ip.getText().toString();

            try {
                Socket socket= new Socket(ip1,3333);
                DataOutputStream out=new DataOutputStream(socket.getOutputStream());
                String a=sentmsg.getText().toString();
                out.writeUTF(a);
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    }






