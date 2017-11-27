package control;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import entity.PointInf;

public class TestShortestPath_black {

	public static HashMap<String, PointInf> graph;
	public static Controller fx=new Controller();
	public static seekShortestPathControl spc=new seekShortestPathControl();
	
	public static String[] str_array= {"my", "mother", "will", "buy", "me", "new", "clothes", "in", "the","new", "year", "which", "means", "the", "new", "beginning", "of", "the", "year","i", "am", "so", "excited", "about", "this", "present", "and", "my", "parents", "have", "rules", "for", "me", "if", "i", "act", "politely", "all", "the", "year", "round", "they", "will", "award", "me", "with", "more", "expensive" ,"dress", "this", "year", "i", "get","one","and", "i","am","so" ,"proud","of" ,"myself"};
	@Test
	public void testSP1() {
		fx.buildGraph(str_array);
		String result1 = spc.calcShortestPath("my", "will");
		String expect1 = new String("\r\n" + 
				"Path is :\r\n" + 
				"my->mother->will. Length is:2.");
		assertEquals(expect1, result1);
	}
	@Test
	public void testSP2() {
		String result2 = spc.calcShortestPath("will", "");
		String expect2 = new String("\r\n" + 
				"find the path between will and dress: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->with->more->expensive->dress. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->with->more->expensive->dress. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and beginning: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->beginning. Length is:4.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->beginning. Length is:4.\r\n" + 
				"\r\n" + 
				"find the path between will and year: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->year. Length is:4.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->year. Length is:4.\r\n" + 
				"\r\n" + 
				"find the path between will and buy: \r\n" + 
				"Path is :\r\n" + 
				"will->buy. Length is:1.\r\n" + 
				"\r\n" + 
				"find the path between will and about: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->am->so->excited->about. Length is:10.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->am->so->excited->about. Length is:10.\r\n" + 
				"\r\n" + 
				"find the path between will and for: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one->and->my->parents->have->rules->for. Length is:12.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one->and->my->parents->have->rules->for. Length is:12.\r\n" + 
				"\r\n" + 
				"find the path between will and rules: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one->and->my->parents->have->rules. Length is:11.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one->and->my->parents->have->rules. Length is:11.\r\n" + 
				"\r\n" + 
				"find the path between will and mother: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one->and->my->mother. Length is:9.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one->and->my->mother. Length is:9.\r\n" + 
				"\r\n" + 
				"find the path between will and act: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->act. Length is:5.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->act. Length is:5.\r\n" + 
				"\r\n" + 
				"find the path between will and award: \r\n" + 
				"Path is :\r\n" + 
				"will->award. Length is:1.\r\n" + 
				"\r\n" + 
				"find the path between will and and: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one->and. Length is:7.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one->and. Length is:7.\r\n" + 
				"\r\n" + 
				"find the path between will and of: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->beginning->of. Length is:5.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->beginning->of. Length is:5.\r\n" + 
				"\r\n" + 
				"find the path between will and get: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get. Length is:5.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get. Length is:5.\r\n" + 
				"\r\n" + 
				"find the path between will and me: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me. Length is:2.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me. Length is:2.\r\n" + 
				"\r\n" + 
				"find the path between will and have: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one->and->my->parents->have. Length is:10.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one->and->my->parents->have. Length is:10.\r\n" + 
				"\r\n" + 
				"find the path between will and politely: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->act->politely. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->act->politely. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and so: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->am->so. Length is:8.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->am->so. Length is:8.\r\n" + 
				"\r\n" + 
				"find the path between will and if: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if. Length is:3.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if. Length is:3.\r\n" + 
				"\r\n" + 
				"find the path between will and they: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->year->round->they. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->year->round->they. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and which: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->year->which. Length is:5.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->year->which. Length is:5.\r\n" + 
				"\r\n" + 
				"find the path between will and all: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->act->politely->all. Length is:7.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->act->politely->all. Length is:7.\r\n" + 
				"\r\n" + 
				"find the path between will and new: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new. Length is:3.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new. Length is:3.\r\n" + 
				"\r\n" + 
				"find the path between will and means: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->year->which->means. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->year->which->means. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and proud: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->am->so->proud. Length is:9.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->am->so->proud. Length is:9.\r\n" + 
				"\r\n" + 
				"find the path between will and in: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->clothes->in. Length is:5.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->clothes->in. Length is:5.\r\n" + 
				"\r\n" + 
				"find the path between will and excited: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->am->so->excited. Length is:9.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->am->so->excited. Length is:9.\r\n" + 
				"\r\n" + 
				"find the path between will and more: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->with->more. Length is:4.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->with->more. Length is:4.\r\n" + 
				"\r\n" + 
				"find the path between will and one: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and myself: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->beginning->of->myself. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->beginning->of->myself. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and this: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->with->more->expensive->dress->this. Length is:7.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->with->more->expensive->dress->this. Length is:7.\r\n" + 
				"\r\n" + 
				"find the path between will and i: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i. Length is:4.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i. Length is:4.\r\n" + 
				"\r\n" + 
				"find the path between will and my: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one->and->my. Length is:8.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one->and->my. Length is:8.\r\n" + 
				"\r\n" + 
				"find the path between will and am: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->am. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->am. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and clothes: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->clothes. Length is:4.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->clothes. Length is:4.\r\n" + 
				"\r\n" + 
				"find the path between will and expensive: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->with->more->expensive. Length is:5.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->with->more->expensive. Length is:5.\r\n" + 
				"\r\n" + 
				"find the path between will and the: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->beginning->of->the. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->beginning->of->the. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->clothes->in->in->of->the. Length is:6.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->clothes->in->in->of->the. Length is:6.\r\n" + 
				"\r\n" + 
				"find the path between will and with: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->with. Length is:3.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->with. Length is:3.\r\n" + 
				"\r\n" + 
				"find the path between will and round: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->new->year->round. Length is:5.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->new->year->round. Length is:5.\r\n" + 
				"\r\n" + 
				"find the path between will and present: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->with->more->expensive->dress->this->present. Length is:8.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->with->more->expensive->dress->this->present. Length is:8.\r\n" + 
				"\r\n" + 
				"find the path between will and parents: \r\n" + 
				"Path is :\r\n" + 
				"will->buy->me->if->i->get->one->and->my->parents. Length is:9.\r\n" + 
				"Path is :\r\n" + 
				"will->award->award->me->if->i->get->one->and->my->parents. Length is:9.\r\n" + 
				"");
		assertEquals(expect2, result2);
	}
	@Test
	public void testSP3() {
		String result3 = spc.calcShortestPath("", "");
		String expect3 = new String("The word is not exist!");
		assertEquals(expect3, result3);
	}
	@Test
	public void testSP4() {
		String result4 = spc.calcShortestPath("jk", "s");
		String expect4 = new String("The word1 or word2 is not exist!");
		assertEquals(expect4, result4);
	}
}
