package NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {

	public static void main(String[] args) throws IOException {

        //Input files
        String[] inputFiles = {"/Users/katya/eclipse-workspace/Java Files and Java IO/src/NIO/file1.txt",
				"/Users/katya/eclipse-workspace/Java Files and Java IO/src/NIO/file2.txt"};

        //Files contents will be written in these files
        String outputFile = "/Users/katya/eclipse-workspace/Java Files and Java IO/src/NIO/OutputExampleTwo.txt";
        //Get channel for output file

        FileOutputStream fos = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fos.getChannel();
        for (int i = 0; i < inputFiles.length; i++)
        {
            //Get channel for input files
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            //Transfer data from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close the input channel
            inputChannel.close();
            fis.close();
        }

        //finally close the target channel
        targetChannel.close();
        fos.close();
    }

	

}
