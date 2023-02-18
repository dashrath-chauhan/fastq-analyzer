import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FastQReader {

    public static void main(String[] args) {
    	
    	if (args.length != 2) {
            System.out.println("Usage: FastqCounter [--count-sequences | --count-nucleotides] input.fastq");
            System.exit(1);
        }

        String flag = args[0];
        String filename = args[1];
        
        int sequenceCount = 0;
	long nucleotideCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
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
            System.out.println("Usage: FastqCounter [--count-sequences | --count-nucleotides] input.fastq");
            System.exit(1);
        }
    }
}
