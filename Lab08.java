//Michael Frantzen
//COSC 3380
//Lab 08

package com.COSC3380.lab08;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;
import java.util.Scanner;

public class Lab08 {
    public static void main(String[] args) throws  IOException {
        //Initializing variables
        String fileName = "c:/tmp/lab08.txt";
        File file = new File(fileName);
        FileChannel fileChannel;
        ByteBuffer byteBuffer;
        String fileContent = "";
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        //Reading the file
        fileChannel = new RandomAccessFile(file, "rw").getChannel();
        byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        //Putting byteBuffer into a String
        while(byteBuffer.hasRemaining()){
            fileContent = fileContent.concat(""+byteBuffer.getChar());
        }

       System.out.println("Orginal File: " + fileContent);

        //Pausing Application
        System.out.println("Press Enter to start writing the buffer");
        String unimportantString = scanner.nextLine();

        //Writing back to the file
        byteBuffer.rewind();
        byteBuffer.clear();
        int i = 0;
        while(byteBuffer.hasRemaining()) {
            //Generating random numbers between 32 - 255 for ascii code
            byteBuffer.putShort((short) (rand.nextInt(255) + 32));

        }
            //Writing hello world to the file from array
//            if (i >= helloWorldArray.length){
//                byteBuffer.putShort((short)32);
//            }else {
//                byteBuffer.putShort((short) helloWorldArray[i]);
//                i++;
//            }


        //Rereading the file
//        fileChannel = new RandomAccessFile(file, "rw").getChannel();
//
//        byteBuffer.rewind();
//        fileChannel.read(byteBuffer);
//        byteBuffer.flip();
//
//        //Putting byteBuffer into a String
//        fileContent = "";
//        while(byteBuffer.hasRemaining()){
//            fileContent = fileContent.concat(""+byteBuffer.getChar());
//        }
//
//        System.out.println("Modified File: " + fileContent);
    }
}
