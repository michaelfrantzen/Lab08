package com.COSC3380.lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Lab08_2 {
    public static void main(String[] args) throws IOException {
        //Initializing variables
        Scanner scanner = new Scanner(System.in);
        String fileName = "c:/tmp/lab08.txt";
        File file = new File(fileName);
        FileChannel fileChannel;
        ByteBuffer byteBuffer;
        String fileContent = "";

        fileChannel = new RandomAccessFile(file, "rw").getChannel();
        byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

        //Pausing Application
        System.out.println("Press Enter to start reading the buffer");
        String unimportantString = scanner.nextLine();

        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        //Putting byteBuffer into a String
        while(byteBuffer.hasRemaining()){
            fileContent = fileContent.concat(""+byteBuffer.getChar());
        }

        System.out.println("File: " + fileContent);
    }
}
