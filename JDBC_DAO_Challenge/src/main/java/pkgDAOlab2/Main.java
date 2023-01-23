package pkgDAOlab2;

public class Main {

	public static void main(String[] args) {
		StudentJDBCDAO student = new StudentJDBCDAO();
		StudentBean alok = new StudentBean();
		alok.setName("Alok");
		alok.setRollNo(8);
		alok.setCourse("MBA");
		alok.setAddress("Ranchi");
		StudentBean tinkoo = new StudentBean();
		tinkoo.setName("Arvind");
		tinkoo.setCourse("BS");
		tinkoo.setRollNo(6);
		// Adding Data
		student.add(alok);
		student.add(tinkoo);
		// Deleting Data
		// student.delete(7);
		// Updating Data
		student.update(tinkoo);
		// Displaying Data
		student.findAll();
	}
}
