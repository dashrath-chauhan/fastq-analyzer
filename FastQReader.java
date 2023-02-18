import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class FastQReader {

    public static void main(String[] args) throws IOException {
    	
    	if (args.length != 2) {
            System.out.println("Usage: FastqCounter [--count-sequences | --count-nucleotides] example.fastq[.gz]");
            System.exit(1);
        }

        String flag = args[0];
        String filename = args[1];
        
        int sequenceCount = 0;
	long nucleotideCount = 0;
	boolean isCompressed = filename.endsWith(".gz");
	    
    	InputStream inputStream = new FileInputStream(filename);
        if (isCompressed) {
	    System.out.println("Compressed file...");
            inputStream = new GZIPInputStream(inputStream);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            boolean inSequence = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("@")) {
                    if (!inSequence) {
                        sequenceCount++;
                        inSequence = true;
                    }
                } else if (line.startsWith("+")) {
                    inSequence = false;
                } else if(inSequence) {
                	nucleotideCount += line.length();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (flag.equals("--count-sequences")) {
        	System.out.println("Number of sequences in " + filename + ": " + sequenceCount);
        } else if (flag.equals("--count-nucleotides")) {
        	System.out.println("Total number of nucleotides in " + filename + ": " + nucleotideCount);
        } else {
            System.out.println("Usage: FastqCounter [--count-sequences | --count-nucleotides] example.fastq[.gz]");
            System.exit(1);
        }
    }
}
