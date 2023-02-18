# FastqCounter

`FastqCounter` is a command-line utility that can count the number of sequences and/or nucleotides in a FASTQ file. The program can handle both uncompressed and gzip-compressed FASTQ files.

## Requirements

- Java 8 or later

## Installation
### Compiling and packaging from source code

1. Clone or download the source code from the [GitHub repository](https://github.com/username/FastqCounter).
2. Open a terminal or command prompt and navigate to the root directory of the project.
3. Run the following command to compile the program and to create an executable JAR file:
    ```
    javac FastqCounter.java
    jar cfe FastqCounter.jar FastqCounter FastqCounter.class
    ```
4. To run the program on Windows, open a command prompt and navigate to the directory where the FastqCounter.jar file is located. Then run the following command:
    ```
    java -jar FastqCounter.jar [--count-sequences | --count-nucleotides] input.fastq[.gz]
    ```
5. To run the program on Linux, open a terminal and navigate to the directory where the FastqCounter.jar file is located. Then run the following command:
    ```
    java -jar FastqCounter.jar [--count-sequences | --count-nucleotides] input.fastq[.gz]
    ```
## Usage

To run the program, open a terminal or command prompt and navigate to the directory containing the `FastqCounter.jar` file.

Replace --count-sequences or --count-nucleotides with the flag you want to use, and replace input.fastq[.gz] with the name of the FASTQ file you want to analyze. If the file is compressed with gzip, make sure to include the .gz extension in the filename.

For example, to count the number of sequences in a file called example.fastq.gz, you can run the following command:
```
java -jar FastqCounter.jar --count-sequences example.fastq.gz
```
Similarly, to count the total number of nucleotides, you can run:
```
java -jar FastqCounter.jar --count-nucleotides example.fastq.gz
```
