package nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappedChannelRead {

	public static void main(String[] args) {

		//Obtain the channel to a file
		try(FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("E:\\Users\\test.txt"))){
			
			//Size of the file
			long fileSize = fileChannel.size();
			
			//Map the file into a buffer
			MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
			
			for(int i = 0; i < fileSize; i++) {
				System.out.print((char)mappedByteBuffer.get());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
