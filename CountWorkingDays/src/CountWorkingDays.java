import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CountWorkingDays {

	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate.parse(cs.nextLine(), df);
		LocalDate date2 = LocalDate.parse(cs.nextLine(), df);

		int workingDays = WorkingDays(date1, date2);
		System.out.println(workingDays);
		cs.close();
	}

	public static int WorkingDays(LocalDate date1, LocalDate date2) {

		int workingDays = 0;

		LocalDate[] holidays = new LocalDate[11];
		holidays[0] = LocalDate.of(2000, 03, 03);
		holidays[1] = LocalDate.of(2000, 05, 06);
		holidays[2] = LocalDate.of(2000, 05, 24);
		holidays[3] = LocalDate.of(2000, 9, 06);
		holidays[4] = LocalDate.of(2000, 9, 22);
		holidays[5] = LocalDate.of(2000, 01, 01);
		holidays[6] = LocalDate.of(2000, 11, 01);
		holidays[7] = LocalDate.of(2000, 12, 24);
		holidays[8] = LocalDate.of(2000, 12, 25);
		holidays[9] = LocalDate.of(2000, 12, 26);
		holidays[10] = LocalDate.of(2000, 05, 01);

		for (LocalDate startDate = date1; startDate.isBefore(date2)
				|| startDate.equals(date2); startDate = startDate.plusDays(1)) {
			LocalDate temp = LocalDate.of(2000, startDate.getMonth(), startDate.getDayOfMonth());
			boolean isHoliday = true;
			for (int i = 0; i < holidays.length; i++) {
				
				if (holidays[i].equals(temp) || startDate.getDayOfWeek() == DayOfWeek.SATURDAY
						|| startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
					isHoliday = false;
					break;
					
				}
			}
			if(isHoliday){
				workingDays++;
			}

		}

		return workingDays;

	}

}
