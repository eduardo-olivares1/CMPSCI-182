import java.util.*;

public class PrintReport {
	Scanner in = new Scanner(System.in);
	char answer;
	ArrayList<Displayable> list = new ArrayList<Displayable>();

	public PrintReport() {
		System.out.println("First You Need To Create A Classroom");
		do {
			Displayable c = enterClassroom();

			list.add(c);
			System.out.print("Enter another class room (Y or N)? ");
			answer = in.next().toUpperCase().charAt(0);
			in.nextLine();
		} while (answer != 'N');

		System.out.print("\n");
		report(list);

		in.close();
	}

	private int getInt(int rangeStart, int rangeEnd, String retryMessage) {
		int num;
		while (true) {
			try {
				num = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Not a valid number. Try again.");
				System.out.println(retryMessage);
				in.nextLine();
				continue;
			}

			if (num > rangeStart && num < rangeEnd) {
				return num;
			} else {
				System.out.println("Number is not between " + rangeStart + " and " + rangeEnd + ". Try again.");
				System.out.println(retryMessage);
				in.nextLine();
			}
		}

	}

	private int getInt(int rangeStart, String retryMessage) {
		int num;
		while (true) {
			try {
				num = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Not a valid number. Try again.");
				System.out.println(retryMessage);
				in.nextLine();
				continue;
			}
			if (num > rangeStart) {
				return num;
			} else {
				System.out.println("Number is not greater than " + rangeStart + ". Try again.");
				System.out.println(retryMessage);
				in.nextLine();
			}
		}
	}

	public Displayable enterClassroom() {
		ArrayList<Displayable> studentList = new ArrayList<Displayable>();
		System.out.print("Enter Room Number (Room number must be 100 or greater): ");
		int room = getInt(99, "Enter Room Number (Room number must be 100 or greater): ");
		in.nextLine();
		System.out.println("Now you need to enter a teacher for the classroom.");
		Displayable teacher = enterTeacher();
		System.out.println("Now you need to Add Students for the classroom.");
		do {
			// create and add students until unser enters N for answer
			Displayable student = enterStudents();
			studentList.add(student);
			System.out.println("Do you want to enter a new student? (Y or N)");
			answer = in.next().toUpperCase().charAt(0);
			in.nextLine();
		} while (answer != 'N');

		return new Classroom(room, teacher, studentList);
	}

	public Displayable enterTeacher() {
		// Get infor for a teacher and create a teacher
		String firstName;
		String lastName;
		String subject;

		System.out.println("Enter the teachers first name: ");
		firstName = in.next();

		System.out.println("Enter the teachers LAST name: ");
		lastName = in.next();
		in.nextLine();

		System.out.println("Enter the teachers subject: ");
		subject = in.nextLine();

		return new Teacher(firstName, lastName, subject);
	}

	public Displayable enterStudents() {
		// Get info for a student and create a student
		int studentId;
		String firstName;
		String lastName;
		int finalGrade;

		System.out.println("Enter the students ID (must be greater than 0): ");
		studentId = getInt(0, "Enter the students ID (must be greater than 0): ");

		System.out.println("Enter the students first name: ");
		firstName = in.next();

		System.out.println("Enter the students LAST name: ");
		lastName = in.next();

		System.out.println("Enter the students final grade (must be between 0 and 100): ");
		finalGrade = getInt(0, 100, "Enter the students final grade (must be between 0 and 100): ");

		return new Student(firstName, lastName, studentId, finalGrade);
	}

	void report(ArrayList<Displayable> list) {
		// left as exercise
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).display());
		}

	}

}