package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

import entity.PointInf;

public class seekShortestPathControl extends Controller{
	@SuppressWarnings("unchecked")
	public String calcShortestPath(String word1, String word2) { 				// calculate the shortest path between two words

		if (word2.equals("")) {
			if (!(myGraph.graph.containsKey(word1)))
				return "The word is not exist!";
		} else if (!(myGraph.graph.containsKey(word1) && myGraph.graph.containsKey(word2))) {
			return "The word1 or word2 is not exist!";
		}
		String ret = "";
		int len = 0;// boolean find = false;
		PointInf bridge;
		ArrayList<String> pass;
		LinkedList<String> queue = new LinkedList<String>();
		queue.addFirst(word1);
		HashMap<String, Boolean> visit = new HashMap<String, Boolean>();
		HashMap<String, ArrayList<String>> path = new HashMap<String, ArrayList<String>>(); // mark the path
		HashMap<String, Integer> dis = new HashMap<String, Integer>(); // djikstral,initialize the distance array
		for (String iter : myGraph.graph.keySet()) {
			len++;
			if (iter.equals(word1)) {
				dis.put(iter, 0);
			} else {
				dis.put(iter, 10000);
			}
			visit.put(iter, false);
		}
		String temp;
		ArrayList<String> cross_point = new ArrayList<String>();
		cross_point.add(word1);
		path.put(word1, cross_point);
		for (int i = 0; i < len; i++) {
			temp = "";
			for (String iter : myGraph.graph.keySet())
				if (!visit.get(iter) && (temp.equals("") || dis.get(temp) > dis.get(iter)))
					temp = iter;
			visit.put(temp, true);
			bridge = myGraph.graph.get(temp);
			for (String ele : bridge.getAdj()) {
				if (dis.get(ele) > dis.get(temp) + bridge.getWeight().get(bridge.getAdj().indexOf(ele))) {
					dis.put(ele, dis.get(temp) + bridge.getWeight().get(bridge.getAdj().indexOf(ele)));
					pass = new ArrayList<String>();
					pass.add(temp);
					path.put(ele, pass);
				} else if (dis.get(ele) == dis.get(temp) + 1) {
					pass = path.get(ele);
					pass.add(temp);
				}
			}
		}
		String one_path;
		String[] one_path_list;
		int count;
		Stack<Integer> flag = new Stack<Integer>();
		int array_ind;
		Stack<ArrayList<String>> stack = new Stack<ArrayList<String>>();
		HashMap<String, ArrayList<String>> copy_path = new HashMap<String, ArrayList<String>>();
		if (word2.equals("")) {
			for (String iter : myGraph.graph.keySet()) {
				if (iter.equals(word1))
					continue;
				ret = ret + "\r\nfind the path between " + word1 + " and " + iter + ": \r\n";
				copy_path = (HashMap<String, ArrayList<String>>) path.clone();
				if (dis.get(iter) == MAX) {
					ret = ret + "there is no path between two words!\r\n";
				} else {
					stack.clear();
					stack.push(copy_path.get(iter));
					flag.push(1);
					one_path = iter;
					while (!stack.isEmpty()) { // use the date structure stack;
						cross_point = stack.peek();
						one_path = one_path + " " + cross_point.get(flag.peek() - 1);
						if (cross_point.equals(copy_path.get(word1))) {
							one_path_list = one_path.split(" "); // add a new path to ret
							ret = ret + "Path is :\r\n" + one_path_list[one_path_list.length - 1];
							for (int ind = one_path_list.length - 2; ind >= 0; ind--) {
								ret = ret + "->" + one_path_list[ind];
							}
							ret = ret + ". Length is:" + dis.get(iter) + ".\r\n";
							count = 0;
							one_path = iter;
							while (cross_point.size() == flag.peek()) {
								stack.pop();
								flag.pop();
								count++;
								if (!stack.isEmpty()) {
									cross_point = stack.peek();
								} else {
									cross_point = null;
									break;
								}
							}
							if (cross_point != null) {
								for (int i = 1; i <= one_path_list.length - count - 2; i++)
									one_path = one_path + " " + one_path_list[i];
								array_ind = flag.pop();
								array_ind++;
								flag.push(array_ind);
								one_path = one_path + " " + cross_point.get(flag.peek() - 1);
							}
						} else {
							stack.push(copy_path.get(cross_point.get(flag.peek() - 1)));
							flag.push(1);
						}
					}
				}
			}
		} else { // the shortest path between two words
			if (dis.get(word2) == MAX)
				return "there is no path between two words!";
			copy_path = (HashMap<String, ArrayList<String>>) path.clone();
			stack.push(copy_path.get(word2));
			one_path = word2;
			while (!stack.isEmpty()) { // use the date structure stack;
				cross_point = stack.peek();
				one_path = one_path + " " + cross_point.get(0);
				if (cross_point.equals(copy_path.get(word1))) {
					one_path_list = one_path.split(" "); // add a new path to ret
					ret = ret + "\r\nPath is :\r\n" + one_path_list[one_path_list.length - 1];
					for (int ind = one_path_list.length - 2; ind >= 0; ind--) {
						ret = ret + "->" + one_path_list[ind];
					}
					ret = ret + ". Length is:" + dis.get(word2) + ".";
					count = 0;
					one_path = word2;
					while (cross_point.size() == 1) {
						stack.pop();
						count++;
						if (!stack.isEmpty()) {
							cross_point = stack.peek();
						} else {
							cross_point = null;
							break;
						}
					}
					if (cross_point != null) {
						cross_point.remove(0);
						for (int i = 1; i <= one_path_list.length - count - 2; i++)
							one_path = one_path + " " + one_path_list[i];
						stack.push(cross_point);
					}
				} else {
					stack.push(copy_path.get(cross_point.get(0)));
				}
			}
		}
		return ret;
	}
}
