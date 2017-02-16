import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		String[] Phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can't live without this product."};

		String[] Events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles.I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

		String[] Author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

		String[] Cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

		Random rnd = new Random();
        scanner.close();
		for (int i = 0; i < n; i++)
		{
			int PhrasesIndex = rnd.nextInt(Phrases.length);
			int EventsIndex = rnd.nextInt(Events.length);
			int AuthorIndex = rnd.nextInt(Author.length);
			int CitiesIndex = rnd.nextInt(Cities.length);

			String output = Phrases[PhrasesIndex] + " " + Events[EventsIndex] + " " + Author[AuthorIndex] + " - " + Cities[CitiesIndex];

			System.out.println(output);
		}

	}

}
