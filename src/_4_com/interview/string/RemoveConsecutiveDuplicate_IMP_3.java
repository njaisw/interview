package _4_com.interview.string;

/**
 * Remove consecutive duplicate characters e.g AABBCDDAAB -> ABCDAB ABBBCCD ->
 * ABCD Test cases Empty string all unique all duplicates duplicates at certain
 * different places
 */
public class RemoveConsecutiveDuplicate_IMP_3 {

	public int removeDuplicates(char input[]) {
		//3 pointers
		int slow = 0;
		int fast = 0;
		int index = 0;
		// TODO You need 3 pointers here
		while (fast < input.length) {
			while (fast < input.length && input[slow] == input[fast]) {
				fast++;
			}
			input[index++] = input[slow];
			slow = fast;
		}
		return index;
	}

	public static void main(String args[]) {
		String str = "AAABBCCDDDEFGH";
		char input[] = str.toCharArray();
		RemoveConsecutiveDuplicate_IMP_3 rcd = new RemoveConsecutiveDuplicate_IMP_3();
		int len = rcd.removeDuplicates(input);
		for (int i = 0; i < len; i++) {
			System.out.print(input[i] + " ");
		}
	}
}
