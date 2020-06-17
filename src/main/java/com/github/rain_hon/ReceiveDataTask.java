package com.github.rain_hon;

import com.github.rain_hon.util.ReadStreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class ReceiveDataTask implements Runnable {

    private final Socket socket;

    public ReceiveDataTask(Socket socket) {
        this.socket =socket;
    }

    @Override
    public void run() {
        try{
            synchronized(socket){
                InputStream input = socket.getInputStream();

                while(true){
                    if(input.available() > 0){
                        byte[] receive = ReadStreamUtil.readStream(input, 1024*10);
                        String danmu = Pack.analyze(receive);
                        if(danmu != null){
                            System.out.println(danmu);
                        }
                    }
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
