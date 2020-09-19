import java.util.LinkedList;
import java.util.Queue;

public class GuitarString{

	// fields and constants
	private static int samplingRate = 44100;
	private static double energyDecayFac = 0.994;
	private Queue <Double> guitarString;
	private int size;
	private int time;

	// creates a Queue of the desired capacity N
	public GuitarString(double frequency) {
		int capacity = (int)Math.round(samplingRate / frequency);
		guitarString = new LinkedList<>();
		size = capacity;
		for(int i = 0; i < size; i++) {
			
			guitarString.add(frequency);
		}
		System.out.println(guitarString.size());
	}

	// creates a Queue of capacity equal to the size of the array, 
	// and initializes the contents of the buffer to the values in the array.
	public GuitarString(double[] init) {
		size = init.length;
		guitarString = new LinkedList<>();
		for(int index = 0; index < size; index++) {
			guitarString.add(init[index]);
		}
	}

	// set the buffer to white noise
	// Replace the N items in the ring buffer with N random values between -0.5 and +0.5. 
	public void pluck() {
		for(int i = 0; i < size; i++) {
			double x = Math.random() - 0.5;
			guitarString.poll();
			guitarString.add(x);
		}
	}

	// delete the sample at the front of the ring buffer and add to the end of the ring buffer 
	// the average of the first two samples, multiplied by the energy decay factor. 
	public void tic() {
		System.out.println(guitarString.size());
		double first = guitarString.poll();
		double second = guitarString.peek();
		double newDouble = energyDecayFac * 0.5 * (first + second);
		guitarString.add(newDouble);
		time++;
	}

	// Return the value of the item at the front of the ring buffer. 
	public double sample() {
		return guitarString.peek();
	}

	// Return the total number of times tic() was called.
	public int time() {
		return time;
	}
}