package control;

import java.util.Random;

public class createNewTextControl extends Controller{
	public String generateNewText(String inputText) { // produce new text according to the bridge word
		String search_result, ret;
		String[] result_list;
		String[] input_list = inputText.split(" ");
		seekBridgeWordControl seekBridgeWordControl = new seekBridgeWordControl();
		ret = input_list[0];
		for (int index = 1; index < input_list.length; index++) {
			search_result = seekBridgeWordControl.queryBridgeWords(input_list[index - 1], input_list[index]);
			if (search_result.equals("") || search_result.equals(" ")) {
				ret = ret + " " + input_list[index];
				continue;
			}
			result_list = search_result.split(" ");
			Random rand = new Random();
			int i = rand.nextInt(result_list.length);
			ret = ret + " " + result_list[i] + " " + input_list[index];
		}
		return ret;
	}
}
