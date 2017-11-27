package control;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import entity.PointInf;

public class TestBridgeWord_white {

	public static HashMap<String, PointInf> graph;
	public static Controller fx=new Controller();
	public static seekBridgeWordControl bwc=new seekBridgeWordControl();
	
	public static String[] str_array= {"my", "mother", "will", "buy", "me", "new", "clothes", "in", "the","new", "year", "which", "means", "the", "new", "beginning", "of", "the", "year","i", "am", "so", "excited", "about", "this", "present", "and", "my", "parents", "have", "rules", "for", "me", "if", "i", "act", "politely", "all", "the", "year", "round", "they", "will", "award", "me", "with", "more", "expensive" ,"dress", "this", "year", "i", "get","one","and", "i","am","so" ,"proud","of" ,"myself"};
	@Test
	public void testQBW1() {
		fx.buildGraph(str_array);
		String result1 = bwc.queryBridgeWord("j", "k");
		String expect1 = new String("No word1 or word2 in the graph!");
		assertEquals(expect1, result1);
	}
	@Test
	public void testQBW2() {
		String result2 = bwc.queryBridgeWord("myself", "if");
		String expect2 = new String("No bridge words from word1 to word2!");
		assertEquals(expect2, result2);
	}
	@Test
	public void testQBW3() {
		String result3 = bwc.queryBridgeWord("with", "expensive");
		String expect3 = new String("The bridge words from word1 to word2 are:more.");
		assertEquals(expect3, result3);
	}
	@Test
	public void testQBW4() {
		String result4 = bwc.queryBridgeWord("mother", "award");
		String expect4 = new String("The bridge words from word1 to word2 are:will.");
		assertEquals(expect4, result4);
	}
	@Test
	public void testQBW5() {
		String result5 = bwc.queryBridgeWord("with", "if");
		String expect5 = new String("No bridge words from word1 to word2!");
		assertEquals(expect5, result5);
	}
	@Test
	public void testQBW7() {
		String result7 = bwc.queryBridgeWord("will", "me");
		String expect7 = new String("The bridge words from word1 to word2 are:buy and award..");
		assertEquals(expect7, result7);
	}
	@Test
	public void testQBW6() {
		String result6 = bwc.queryBridgeWord("of", "more");
		String expect6 = new String("No bridge words from word1 to word2!");
		assertEquals(expect6, result6);
	}
}
