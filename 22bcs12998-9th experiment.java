public class Main {
    public static void main(String[] args) {
        // Simulated Spring DI
        AppConfig config = new AppConfig();
        Course course = config.course();
        Student student = config.student(course);
        
        student.showDetails();
    }
}

// Simulating @Component and @Bean classes
class Course {
    private String courseName;
    private int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", Duration: " + duration + " hours";
    }
}

class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void showDetails() {
        System.out.println("Student: " + name);
        System.out.println(course.toString());
    }
}

class AppConfig {
    public Course course() {
        return new Course("Spring Framework", 40);
    }

    public Student student(Course course) {
        return new Student("Alice", course);
    }
}
