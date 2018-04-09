package com.COSC3380.lab08;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class Lab08 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        File f = new File("c:/tmp/mapped.txt");
//        f.delete();
//
//        FileChannel fc = new RandomAccessFile(f, "rw").getChannel();
//
//        long bufferSize=8*1000;
//        MappedByteBuffer mem =fc.map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);
//
//        int start = 0;
//        long counter=1;
//        long HUNDREDK=100000;
//        long startT = System.currentTimeMillis();
//        long noOfMessage = HUNDREDK * 10 * 10;
//        for(;;)
//        {
//            if(!mem.hasRemaining())
//            {
//                start+=mem.position();
//                mem =fc.map(FileChannel.MapMode.READ_WRITE, start, bufferSize);
//            }
//            mem.putLong(counter);
//            counter++;
//            if(counter > noOfMessage )
//                break;
//        }
//        long endT = System.currentTimeMillis();
//        long tot = endT - startT;
//        System.out.println(String.format("No Of Message %s , Time(ms) %s ",noOfMessage, tot)) ;
//        File f = new File("c:/tmp/mapped.txt");
//
//        FileChannel fc = new RandomAccessFile(f, "rw").getChannel();
//
//        long bufferSize = 8 * 1000;
//        MappedByteBuffer mem = fc.map(FileChannel.MapMode.READ_ONLY, 0, bufferSize);
//        long oldSize = fc.size();
//
//        long currentPos = 0;
//        long xx = currentPos;
//
//        long startTime = System.currentTimeMillis();
//        long lastValue = -1;
//        for (; ; ) {
//            while(mem.hasRemaining()){
//                lastValue = mem.getLong();
//                currentPos+=8;
//            }
//            if (currentPos < oldSize){
//                xx = xx + mem.position();
//                mem = fc.map(FileChannel.MapMode.READ_ONLY, xx, bufferSize);
//                continue;
//            } else {
//                long endTime = System.currentTimeMillis();
//                long tot = endTime-startTime;
//                System.out.println(String.format("Last Value Read %s , Time(ms) %s ",lastValue, tot));
//                System.out.println("Waiting for message");
//                while(true) {
//                    long newSize = fc.size();
//                    if (newSize > oldSize) {
//                        oldSize = newSize;wq
//                        xx = xx + mem.position();
//                        mem = fc.map(FileChannel.MapMode.READ_ONLY, xx, oldSize - xx);
//                        System.out.println("Got some data");
//                        break;
//                    } else {
//                        System.out.println("No data");
//                    }
//                }
//            }
//        }

        try
        {
            RandomAccessFile aFile = new RandomAccessFile(
                    "c:/tmp/mapped.txt","r");
            FileChannel inChannel = aFile.getChannel();
            long fileSize = inChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            inChannel.read(buffer);
            //buffer.rewind();
            buffer.flip();
            for (int i = 0; i < fileSize; i++)
            {
                System.out.print((char) buffer.get());
            }
            inChannel.close();
            aFile.close();
        }
        catch (IOException exc)
        {
            System.out.println(exc);
            System.exit(1);
        }
    }
}
