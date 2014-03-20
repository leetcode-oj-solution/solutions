import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		System.out.println(sol.wordBreak("a", dict));
	}
	
	@Test
	public void test1() {
		Solution sol = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(sol.wordBreak("catsanddog", dict));
	}

}
