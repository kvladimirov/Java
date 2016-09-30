import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class AverageGrades {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in); 
	List<Student> students = new ArrayList<>();

	int n = Integer.parseInt(scan.nextLine());
	
	for (int i = 0; i < n; i++){
	
		String[] input = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
		Double[] grades = Arrays.stream(input).skip(1).map(Double::parseDouble).toArray(Double[]::new);

		students.add(new Student(input[0], grades));
	}
	
	Comparator<Student> byName = (x1, x2) -> x1.Name.compareTo(x2.Name);
	Comparator<Student> byGrade = (x1, x2) -> x2.getAvg().compareTo(x1.getAvg());
	
	for (Student student : students.stream().filter(s -> s.getAvg() >= 5).sorted(byName.thenComparing(byGrade)).toArray(Student[]::new)) {
	
		 System.out.println(student);		
	}		
	scan.close();
	
  }
}
class Student {
	public Student(String name, Double[] grades){
	
		this.Name = name;
		this.Grades = grades;
		OptionalDouble average = Arrays.stream(this.Grades)
                .mapToDouble(a -> a)
                .average();
		this.avgGrades = average.isPresent() ? average.getAsDouble() : 0;
		}
	
	 	public String Name;
	    public Double[] Grades;
	    private Double avgGrades;

	    public Double getAvg() {
	        return avgGrades;
	    }

	    @Override
	    public String toString() {
	        String stringView = String.format("%s -> %.2f", this.Name, this.getAvg());
	        return stringView;
	}
}