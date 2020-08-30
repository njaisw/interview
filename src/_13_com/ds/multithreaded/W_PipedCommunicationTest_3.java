package _13_com.ds.multithreaded;

/*
What are piped streams
----------------------
Pipe streams are just like real plumbing pipes. You put things into to a pipe at one end � using some methods.
Then you receive the same things back from the pipe stream at the other end � using some other methods.

They come out in FIFO order, first-in first-out, just like from real plumbing pipes.

PipedReader and PipedWriter

PipedReader is an extension of Reader class which is used for reading character streams. Its read() method reads the connected PipedWriter�s stream. 
Similarly, PipedWriter is an extension of Writer class and does all the things which Reader class contracts.

A writer can be connected to a reader by following two methods:

    Using constructor PipedWriter(PipedReader pr)
    Using connect(PipedReader pr) method

Once connected through any of above ways, any thread can write data in stream using write(....) methods, and data will be available to reader and can be read using read() method.

Ponts to remember:
    You cannot write to a pipe without having some sort of reader created and connected to it. In other words, both ends must be present and already connected for the writing end to work.
    You cannot switch to another reader, to which the pipe was not originally connected, once you are done writing to a pipe.
    You cannot read back from the pipe if you close the reader. You can close the writing end successfully, however, and still read from the pipe.
    You cannot read back from the pipe if the thread which wrote to it ends.
    
 */

import java.io.PipedReader;
import java.io.PipedWriter;

public class W_PipedCommunicationTest_3 {

	public class PipeReaderThread implements Runnable {
		PipedReader pr;
		String name = null;

		public PipeReaderThread(String name, PipedReader pr) {
			this.name = name;
			this.pr = pr;
		}

		public void run() {
			try {
				// continuously read data from stream and print it in console
				while (true) {
					char c = (char) pr.read(); // read a char
					if (c != -1) { // check for -1 indicating end of file
						System.out.print(c);
					}
				}
			} catch (Exception e) {
				System.out.println(" PipeThread Exception: " + e);
			}
		}
	}

	public class PipeWriterThread implements Runnable {
		PipedWriter pw;
		String name = null;

		public PipeWriterThread(String name, PipedWriter pw) {
			this.name = name;
			this.pw = pw;
		}

		public void run() {
			try {
				while (true) {
					// Write some data after every two seconds
					pw.write("Testing data written...n");
					pw.flush();
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(" PipeThread Exception: " + e);
			}
		}
	}

	public static void main(String[] args) {
		new W_PipedCommunicationTest_3();
	}

	public W_PipedCommunicationTest_3() {
		try {
			// Create writer and reader instances
			PipedReader pr = new PipedReader();
			PipedWriter pw = new PipedWriter();

			// Connect the writer with reader
			pw.connect(pr);

			// Create one writer thread and one reader thread
			Thread thread1 = new Thread(new PipeReaderThread("ReaderThread", pr));

			Thread thread2 = new Thread(new PipeWriterThread("WriterThread", pw));

			// start both threads
			thread1.start();
			thread2.start();

		} catch (Exception e) {
			System.out.println("PipeThread Exception: " + e);
		}
	}
}
