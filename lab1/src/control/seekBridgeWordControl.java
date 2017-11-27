package control;

import entity.PointInf;

public class seekBridgeWordControl extends Controller{
	public String queryBridgeWords(String word1, String word2) {// query the bridge words
		if (!(myGraph.graph.containsKey(word1) && myGraph.graph.containsKey(word2)))
			return "";
		String ret = "";
		PointInf value, bridge;
		value = myGraph.graph.get(word1);
		for (String ele : value.getAdj()) {
			bridge = myGraph.graph.get(ele);
			for (String des : bridge.getAdj()) {
				if (des.equalsIgnoreCase(word2)) {
					ret = ret.equals("") ? ele : ret + " " + ele;
				}
			}
		}
		if (ret.equals(""))
			return " ";
		return ret;
	}
	
	public String queryBridgeWord(String word1,String word2) {
		String ret = queryBridgeWords(word1,word2);
		if (ret.equals("")) {
			return "No word1 or word2 in the graph!";
		} else if (ret.equals(" ")) {
			return "No bridge words from word1 to word2!";
		} else {
			String out = "";
			String[] str_list = ret.split(" ");
			if (str_list.length == 1) {
				out = out + str_list[0];
			} else {
				for (int index = 0; index < str_list.length; index++) {// form the format
					if (index == str_list.length - 1) {
						out = out + " and " + str_list[index] + ".";
					} else if (index == str_list.length - 2) {
						out = out + str_list[index];
					} else {
						out = out + str_list[index] + ',';
					}
				}
			}
			return "The bridge words from word1 to word2 are:" + out + ".";
		}
	}
}
