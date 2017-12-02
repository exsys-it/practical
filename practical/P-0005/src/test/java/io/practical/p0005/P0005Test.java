package io.practical.p0005;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class P0005Test {

	private static short BYTE = 1;
	private static short SHORT = 2;
	private static short INT = 4;
	private static short LONG = 8;
	
	@Test
	public void test() throws IOException, URISyntaxException, NoSuchFieldException, SecurityException {
		Unsafe unsafe = UnsafeHelper.getUnsafe();

		URL url = getClass().getClassLoader().getResource("file.txt");
		Path path = Paths.get(url.toURI());
		try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.READ)) {
			MappedByteBuffer mbb = fileChannel.map(MapMode.READ_ONLY, 0, fileChannel.size());
			
			long bufferAddress = unsafe.objectFieldOffset(Buffer.class.getDeclaredField("address"));
			long adrInMemory = (long) unsafe.getLong(mbb, bufferAddress) +3;

			System.out.println("\n\n loopByByte");
			loopByByte(unsafe, adrInMemory, mbb.limit());
			
			System.out.println("\n\n loopByShort");
			loopByShort(unsafe, adrInMemory, mbb.limit());

			System.out.println("\n\n loopByInt");
			loopByInt(unsafe, adrInMemory, mbb.limit());
			
			System.out.println("\n\n loopByLong");
			loopByLong(unsafe, adrInMemory, mbb.limit());
		}
	}

	private void loopByByte(Unsafe unsafe, long adr, int limit) {
		long index = adr;
		while (index < (adr + limit)) {
			byte c = unsafe.getByte(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(BYTE).put(c).array())));
			index = index + BYTE;
		}
	}

	private void loopByShort(Unsafe unsafe, long adr, int limit) {
		long index = adr;
		while (index < (adr + limit)) {
			short c = unsafe.getShort(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(SHORT).putShort(c).array())));
			index = index + SHORT;
		}
		while (index < (adr + limit)) {
			byte c = unsafe.getByte(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(BYTE).put(c).array())));
			index = index + BYTE;
		}
	}

	private void loopByInt(Unsafe unsafe, long adr, int limit) {
		long index = adr;
		while (index < (adr + limit)) {
			int c = unsafe.getInt(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(INT).putInt(c).array())));
			index = index + INT;
		}
		while (index < (adr + limit)) {
			short c = unsafe.getShort(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(SHORT).putShort(c).array())));
			index = index + SHORT;
		}
		while (index < (adr + limit)) {
			byte c = unsafe.getByte(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(BYTE).put(c).array())));
			index = index + BYTE;
		}
	}

	private void loopByLong(Unsafe unsafe, long adr, int limit) {
		long index = adr;
		while (index < (adr + limit)) {
			long c = unsafe.getLong(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(LONG).putLong(c).array())));
			index = index + LONG;
		}
		while (index < (adr + limit)) {
			int c = unsafe.getInt(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(INT).putInt(c).array())));
			index = index + INT;
		}
		while (index < (adr + limit)) {
			short c = unsafe.getShort(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(SHORT).putShort(c).array())));
			index = index + SHORT;
		}
		while (index < (adr + limit)) {
			byte c = unsafe.getByte(index);
			System.out.print(new String(reverse(ByteBuffer.allocate(BYTE).put(c).array())));
			index = index + BYTE;
		}
	}
	
	private byte[] reverse(byte[] bytes) {
		for(int i = 0; i < bytes.length / 2; i++)
		{
		    byte temp = bytes[i];
		    bytes[i] = bytes[bytes.length - i - 1];
		    bytes[bytes.length - i - 1] = temp;
		}
		return bytes;
	}
}
