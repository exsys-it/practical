package io.practical.p0001;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class P0001 {

	private static final String PATH = "/Users/xavier/";

	public static void main(String[] args) throws IOException {

		String zipFilename = "test_zipname_" + System.currentTimeMillis() + ".zip";
		write(zipFilename);
		read(zipFilename);

	}

	private static void read(String zipFilename) throws IOException {
		Map<String, String> env = new HashMap<>();
		env.put("create", "false");
		URI uri = URI.create("jar:file:" + PATH + zipFilename);
		System.out.println("READ ---> ");
		System.out.println(uri.toString());
		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {

			try (Stream<Path> pathesInZip = Files.walk(zipfs.getPath("/"))) {
				pathesInZip.forEach(pathInZip -> {
					System.out.println(pathInZip.getFileName());
					if (pathInZip.getFileName() != null) {
						try {
							Path tmp = Files.createTempFile("pe-jm-0001_", "_" + pathInZip.getFileName().toString());
							System.out.println("copy to:" + tmp.toRealPath());
							Files.copy(pathInZip, tmp, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		}
	}

	public static void write(String zipFilename) throws IOException {
		Map<String, String> env = new HashMap<>();
		env.put("create", "true");
		URI uri = URI.create("jar:file:" + PATH + zipFilename);
		System.out.println("WRITE ---> ");
		System.out.println(uri.toString());
		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
			// file1
			Path file1InZip = zipfs.getPath("/file1.txt");
			System.out.println(file1InZip.toAbsolutePath());
			Files.write(file1InZip, "plop".getBytes(), StandardOpenOption.CREATE);

			// file2 copy a file into the zip file
			Path externalTxtFile = Paths.get(PATH + "/file2.pdf");
			Path file2InZip = zipfs.getPath("/file2.pdf");
			System.out.println(file2InZip.toAbsolutePath());
			Files.copy(externalTxtFile, file2InZip, StandardCopyOption.REPLACE_EXISTING);

			// file3
			Path file3InZip = zipfs.getPath("/file3.log");
			System.out.println(file3InZip.toAbsolutePath());
			java.io.BufferedWriter bw = Files.newBufferedWriter(file3InZip, StandardOpenOption.CREATE);
			bw.write("line 1");
			bw.write("line 3");
			bw.close();
		}
	}
}
