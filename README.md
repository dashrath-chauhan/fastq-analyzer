# fastq-analyzer
FastQ Analyzer is a tool built primariy for the assessment purpose for Sanger Institute. This tool counts the number of sequences or nucleotides in the FastQ file.

I have already compiled and packaged the tool as jar, so to run this utility directly execute Step4. If you want to make any changes to the code and recreate the jar again follow these steps.

## Usage
Step1. To compile this program and create a JAR file, open a terminal or command prompt and navigate to the directory where the FastqCounter.java file is located. 
Then run the following commands:
'''
javac FastqCounter.java
jar cfe FastqCounter.jar FastqCounter FastqCounter.class
'''

Step2. This will create an executable JAR file called FastqCounter.jar.
To run the program on Windows, open a command prompt and navigate to the directory where the FastqCounter.jar file is located. Then run the following command:
'''
java -jar FastqCounter.jar [--count-sequences | --count-nucleotides] input.fastq[.gz]
'''

To run the program on Linux, open a terminal and navigate to the directory where the FastqCounter.jar file is located. Then run the following command:
'''
java -jar FastqCounter.jar [--count-sequences | --count-nucleotides] input.fastq[.gz]
'''

Step4. Replace --count-sequences or --count-nucleotides with the flag you want to use, and replace input.fastq[.gz] with the name of the FASTQ file you want to analyze. If the file is compressed with gzip, make sure to include the .gz extension in the filename.

For example, to count the number of sequences in a file called example.fastq.gz, you can run the following command:
'''
java -jar FastqCounter.jar --count-sequences example.fastq.gz
'''

Similarly, to count the total number of nucleotides, you can run:
'''
java -jar FastqCounter.jar --count-nucleotides example.fastq.gz
'''
