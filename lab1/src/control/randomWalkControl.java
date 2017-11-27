package control;

import java.util.Random;

public class randomWalkControl extends Controller{
	public String randomWalk() {
		if (rand_finish)
			return "";
		String ret = "";
		if (rand_start.equals("")) {
			Random rand = new Random();
			int finish = rand.nextInt(myGraph.graph.size());
			int count = 1;
			for (String tmp : myGraph.graph.keySet()) {
				if (count++ == finish) {
					rand_point = rand_start = tmp;
					break;
				}
			}
			ret = rand_start + " ";
		} else {
			if (myGraph.graph.get(rand_start).getAdj().isEmpty()) {
				rand_finish = true;
				return "\r\nthe path is over!";
			}
			for (String value : myGraph.graph.get(rand_start).getAdj()) {
				ret = ret.equals("") ? value : ret + " " + value;
			}
			String[] str_list = ret.split(" ");
			int cnt = 0;
			Random rand = new Random();
			int choice;
			while (true) {
				choice = rand.nextInt(str_list.length - cnt);
				rand_pair = rand_start + "->" + str_list[choice];
				if (rand_pool.isEmpty() || rand_pool.indexOf(rand_pair) == -1) {
					rand_pool.add(rand_pair);
					rand_start = ret = str_list[choice];
					ret += " ";
					break;
				} else {
					ret = "\r\nthe path already exists!";
					rand_finish = true;
					break;
				}
			}
		}
		return ret;
	}
}
