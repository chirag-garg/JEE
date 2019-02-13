import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Problem1 {
	
	
	
	public static void main(String[] args) throws IOException {
		
		String sourcePath = "C:\\Source.txt";
		String destinationPath = "C:\\Destination.txt";
		
		FileInputStream input = new FileInputStream(sourcePath);
		PrintWriter writer = new PrintWriter(destinationPath);
		/*FileOutputStream output = new FileOutputStream(destinationPath);
		BufferedOutputStream bout=new BufferedOutputStream(output);  */  
		
		String s= "";
		int c;
		while((c = input.read()) != -1) {
			s = (char)c + s;
		}
	
		writer.write(s);
		writer.flush();  
	    writer.close(); 
	    
	    input.close();
	    
		/*byte []b = s.getBytes();
		bout.write(b);
		bout.flush();
		bout.close();
		output.close();*/
		System.out.println("Success");		
	}

}
