public class DefaultValue {

	public static void main(String[] args) {
		boolean bArray[] = new boolean[5];
		int iArray[] = new int[5];
		float fArray[] = new float[5];
		double dArray[] = new double[5];
		Student stuArray[] = new Student[5];
		
		System.out.println(bArray[0]);
		System.out.println(iArray[0]);
		System.out.println(fArray[0]);
		System.out.println(dArray[0]);
		System.out.println(stuArray[0]);
	}
}

class Student {
	int id;
	String name;

	public Student() {}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
