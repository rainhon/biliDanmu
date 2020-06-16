package com.github.rain_hon;

import org.json.JSONObject;

import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import static com.github.rain_hon.EnumOpt.CMD;

public class ReceiveDataHandler {
    private byte[] data;
    public ReceiveDataHandler(byte[] data) {
        this.data = data;
    }

    public String getDamu(){
        return Pack.analyze(data);
    }
}
