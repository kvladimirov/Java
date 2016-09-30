import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Comparator;
	import java.util.Date;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
	import java.util.SortedSet;
	import java.util.TreeMap;
	import java.util.TreeSet;


public class BookLibraryModification {
		public static void main(String[] args) throws ParseException  {
					Scanner cs = new Scanner(System.in);
					long n = cs.nextInt();
					cs.nextLine();
					Library myLib = new Library();
					
					DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
					
					for (int i = 0; i < n; i++) {
						String[] bookInfo = cs.nextLine().split(" ");
						Date date = df.parse(bookInfo[3]);
						double bd = Double.parseDouble(bookInfo[5]);
						Books book = new Books(bookInfo[0], bookInfo[1], bookInfo[2], date, bookInfo[4], bd);
						myLib.books.add(book);
					}
					Date givenDate= df.parse(cs.nextLine());
					
					Map<String, Date> titleByDate = new TreeMap<String, Date>();

					for (Books book : myLib.books) {

						if (titleByDate.containsKey(book.Title)) {
							titleByDate.get(book.ReleaseDate);
						}
						titleByDate.put(book.Title, book.ReleaseDate);

					}
					SortedSet<Map.Entry<String, Date>> sorted = entriesSortedByValues(titleByDate);
					
					for (Map.Entry<String, Date> pair : sorted) {
						if(pair.getValue().after(givenDate)){
						System.out.println( pair.getKey()+" -> "+df.format(pair.getValue()) );
						}
					}
					cs.close();
				}

		static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
			SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {
				@Override
				public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
					int res = e1.getValue().compareTo(e2.getValue());
					if (res == 0) {
						res = ((String) e1.getKey()).compareTo((String) e2.getKey());

					}
					return res;
				}
			});
			sortedEntries.addAll(map.entrySet());
			return sortedEntries;
		}

	}

	class Books {
		public Books(String title, String author, String publisher, Date releaseDate, String iSBN, Double bd) {
			super();
			this.Title = title;
			this.Publisher = publisher;
			this.Author = author;
			this.ReleaseDate = releaseDate;
			this.ISBN = iSBN;
			this.Price = bd;
		}

		public String Title;
		public String Publisher;
		public String Author;
		public Date ReleaseDate;
		public String ISBN;
		public Double Price;

	}

	class Library {
		String name;
		List<Books> books;

		public Library() {
			this.books = new ArrayList<Books>();
		}

	}


