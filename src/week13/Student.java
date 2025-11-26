package week13;

public class Student implements Comparable<Student> {
    String name;
    String sid;
    int score;

    public Student(String name) {
        this(name,"",0);
    }

    public Student(String name, String sid, int score) {
        this.name = name;
        this.sid = sid;
        this.score = score;
    }

    @Override
    public String toString() {
        return "\""+ this.name+" , "+this.sid+" , "+this.score+"\"";
    }

    @Override
    public int compareTo(Student o) {
        //return this.name.compareTo(o.name);
        return this.score-o.score;
    }
}
