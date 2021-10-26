package Week7;

import Week7.JavaSort.Student;
import java.util.*;

public class JavaSort {

  static class Student {

    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
      super();
      this.id = id;
      this.fname = fname;
      this.cgpa = cgpa;
    }

    public int getId() {
      return id;
    }

    public String getFname() {
      return fname;
    }

    public double getCgpa() {
      return cgpa;
    }
  }

  static class StudentComparator implements Comparator<Student> {
    double epsilon = 0.001;
    @Override
    public int compare(Student x, Student y) {
      if (Math.abs(x.getCgpa() - y.getCgpa()) > epsilon) {
        return (x.getCgpa() < y.getCgpa() ? 1 : -1);
      } else if (!x.getFname().equals(y.getFname())) {
        return x.getFname().compareTo(y.getFname());
      } else {
        return x.getId() - y.getId();
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());

    List<Student> studentList = new ArrayList<Student>();
    while (testCases > 0) {
      int id = in.nextInt();
      String fname = in.next();
      double cgpa = in.nextDouble();

      Student st = new Student(id, fname, cgpa);
      studentList.add(st);

      testCases--;
    }
    studentList.sort(new StudentComparator());
    for (Student st : studentList) {
      System.out.println(st.getFname());
    }
  }
}


