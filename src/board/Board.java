package board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Board {

	private String[] boardData;

	public Board(String board) {
		try {
		InputStream in = ClassLoader.getSystemResourceAsStream("csv/" + board);
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");

			boardData = data;
		}
		br.close();
		in.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//
//		final String targetFilePath = board;
//
//		URL url = this.getClass().getClassLoader().getResource(targetFilePath);
//		File downloadable = new File(url.getPath());
//
//		String path1 = downloadable.getPath();
//
//		try (BufferedReader br = new BufferedReader(new FileReader(path1))) {
//			String line;
//
//			while ((line = br.readLine()) != null) {
//
//				String[] data = line.split(",");
//
//				boardData = data;
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public String[] getBoardData() {
		return boardData;
	}

}
