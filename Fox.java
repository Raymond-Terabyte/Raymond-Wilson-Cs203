import java.util.ArrayList;
import java.util.Scanner;

public class Fox {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //copy and paste the lyrics
		int n = scan.nextInt();
		scan.nextLine();
		outer: for (int x = 0; x < n; x++) {
			ArrayList<String> arr1 = new ArrayList<>();
			String[] lyric = scan.nextLine().split(" ");
			for (String chars : lyric)
				arr1.add(chars);
			
			inner: for (String in = scan.nextLine(); !in.isEmpty(); in = scan.nextLine()) {
				if (in.equals("what does the fox say?")) {
					for (String chars : arr1) {
						System.out.print(chars + ' ');
					}
					
					System.out.println();
					continue outer;
				} else {
					String[] chars = in.split(" ");
					ArrayList<String> temp = new ArrayList<>();
					temp.add(chars[2]);
					arr1.removeAll(temp);
					temp.clear();
				}
			}
		}
	}
}