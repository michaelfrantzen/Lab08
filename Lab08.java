package com.COSC3380.lab08;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Lab08 {
    public static void main(String[] args) throws  IOException {
        //Initializing variables
        String fileName = "c:/tmp/hello_world.txt";
        File file = new File(fileName);
        FileChannel fileChannel;
        ByteBuffer byteBuffer;
        String fileContent = "";
        int[] mikey = new int[]{77,73,75,69,89};

        //Reading the file
        fileChannel = new RandomAccessFile(file, "rw").getChannel();
        byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        while(byteBuffer.hasRemaining()){
            fileContent = fileContent.concat(""+byteBuffer.getChar());
        }

       System.out.println("Orginal File: " + fileContent);

        //Writing back to the file
        byteBuffer.rewind();
        byteBuffer.clear();

        int i = 0;
        while(byteBuffer.hasRemaining()){
            if (i >= mikey.length){
                byteBuffer.putShort((short)32);
            }else {
                byteBuffer.putShort((short) mikey[i]);
                i++;
            }
        }

        //Rereading the file
        fileChannel = new RandomAccessFile(file, "rw").getChannel();

        byteBuffer.rewind();
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        fileContent = "";
        while(byteBuffer.hasRemaining()){
            fileContent = fileContent.concat(""+byteBuffer.getChar());
        }

        System.out.println("Modified File: " + fileContent);
    }
}
