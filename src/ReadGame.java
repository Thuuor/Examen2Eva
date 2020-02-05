import java.io.*;
import java.util.*;

public class ReadGame {

	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Enter de name of the file u wanna read: ");
			Scanner scan = new Scanner(System.in);
			String file = scan.next();
			scan.close();
			Map<String,List<Card>> map = readFileToMap(file);
			System.out.println(map);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("Error reading file");
		}
	}

	public static Map<String, List<Card>> readFileToMap(String file) throws IOException {

		BufferedReader input = null;
		Map<String, List<Card>> map = new HashMap<String, List<Card>>();

		try {
			
			input = new BufferedReader(new FileReader(file));
			String line;
			while ((line = input.readLine()) != null) {
				List<Card> list = new ArrayList<Card>();
				line = line.replaceAll(" ", "");
				String[] items = line.split(",");
				String player = items[0];
				for (int i = 1; i < items.length; i += 2) {
					Card.SuitType type = null;
					int number = Integer.parseInt(items[i]);
					int suit = Integer.parseInt(items[i + 1]);
					switch (suit) {
					case 1:
						type = Card.SuitType.OROS;
						break;
					case 2:
						type = Card.SuitType.COPAS;
						break;
					case 3:
						type = Card.SuitType.ESPADAS;
						break;
					case 4:
						type = Card.SuitType.BASTOS;
						break;
					}
					Card card = new Card(number,type);
					list.add(card);
				}
				map.put(player, list);
			}
			return map;
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
}
