package learn.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ExplicitChannelRead {

	public static void main(String[] args) {
		int count;
		
		//The Channel is opened on the Path return by Path.get()
		try(SeekableByteChannel seekableByteChannel = Files.newByteChannel(Paths.get("E:\\Users\\test.txt"))) {
			//Buffer allocation
			ByteBuffer byteBuffer = ByteBuffer.allocate(128);
			
			do {
				//read a buffer
				count = seekableByteChannel.read(byteBuffer);
				
				//Stop when the end of the file is reached
				if(count != -1) {
					byteBuffer.rewind();
					
					for(int i = 0; i < count; i++) {
						System.out.print((char)byteBuffer.get());
					}
					System.out.println();
				}
			} while (count != -1);
			
		} catch (InvalidPathException e) {
			System.out.println("Path is not valid " + e);
		} catch(IOException e) {
			System.out.println("IO error " + e);
		}
	}
}
