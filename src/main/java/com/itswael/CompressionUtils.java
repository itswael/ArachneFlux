package com.itswael;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionUtils {
    public byte[] Compress(String inputString) throws UnsupportedEncodingException{
        byte[] input = inputString.getBytes(StandardCharsets.UTF_8);
        byte[] output = inputString.getBytes();
        Deflater compressor = new Deflater();
        compressor.setInput(input);
        compressor.finish();
        int compressedDataLength = compressor.deflate(output);
        return output;
    }

    public String Decompress(byte[] inBytes) throws Exception{
        Inflater decompressor = new Inflater();
        decompressor.setInput(inBytes, 0, inBytes.length);
        byte[] result = new byte[inBytes.length];
        int resultLength = decompressor.inflate(result);
        decompressor.end();
        return new String(result, 0, resultLength, StandardCharsets.UTF_8);
    }
}
