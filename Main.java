import java.util.*;

//problema 1
/*
public class Main {
    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            x.add(random.nextInt(11));
        }
        Collections.sort(x);

        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            y.add(random.nextInt(11));
        }
        Collections.sort(y);

        //a
        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        //b
        Set<Integer> zSet = new TreeSet<>(x);
        zSet.retainAll(y);

        //c
        List<Integer> xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y);

        //d
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        for (Integer num : xPlusY) {
            if (num <= p) {
                xPlusYLimitedByP.add(num);
            }
        }

        System.out.println("Lista x: " + x);
        System.out.println("Lista y: " + y);
        System.out.println("Lista xPlusY: " + xPlusY);
        System.out.println("Setul zSet: " + zSet);
        System.out.println("Lista xMinusY: " + xMinusY);
        System.out.println("Lista xPlusYLimitedByP: " + xPlusYLimitedByP);
    }
}
*/

//problema 2
class Student implements Comparable <Student> {
    private final String nume;
    private final String grupa;
    private final List <Integer> note;

    public Student(String nume, String grupa, List <Integer> note) {
        this.nume = nume;
        this.grupa = grupa;
        this.note = note;
    }

    public double Media() {
        int sum = 0;
        for (Integer nota : note) {
            sum += nota;
        }
        return (double) sum / note.size();
    }

    public int NrRestante() {
        int count = 0;
        for (Integer nota : note) {
            if (nota < 5) {
                count++;
            }
        }
        return count;
    }

    public String getName() {
        return nume;
    }

    public String getGroup() {
        return grupa;
    }

    public List <Integer> getGrades() {
        return note;
    }

    @Override
    public int compareTo(Student other) {
        return this.nume.compareTo(other.nume);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + nume + '\'' + ", group='" + grupa + '\'' + ", grades=" + note + '}';
    }

    public static void main(String[] args) {
        List<Student> studenti= new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            List <Integer> randomGrades = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                randomGrades.add(random.nextInt(7) + 4);
            }
            studenti.add(new Student("Student" + (i + 1), "Grupa " + (i % 3 + 1), randomGrades));
        }

        //a)
        System.out.println("Studentii initial:");
        for (Student student : studenti) {
            System.out.println(student);
        }

        //b1)
        System.out.println("Studentii in ordine alfabetica, pe grupe:");
        studenti.sort(Comparator.comparing(Student::getName));
        for (Student student : studenti) {
            System.out.println(student.getName() + " - " + student.getGroup());
        }

        //b2)
        System.out.println("Studentii in ordinea descrescatoare a mediilor:");
        studenti.sort(Comparator.comparing(Student::Media).reversed());
        for (Student student : studenti) {
            System.out.println(student.getName() + " - Media: " + student.Media());
        }

        //b3)
        System.out.println("Studentii in ordinea crescatoare a numarului de restante:");
        studenti.sort(Comparator.comparingInt(Student::NrRestante));
        for (Student student : studenti) {
            System.out.println(student.getName() + " - Restante: " + student.NrRestante());
        }
    }
}





