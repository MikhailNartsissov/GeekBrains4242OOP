import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class User<T> {

    private T id;
    public String firstName;
    public String lastName;
    private int age;

    public User(T id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public int getAge() { return this.age; }
    public void setAge(Integer age) { this.age = age; }
    public T getId() { return this.id; }
}
class UserComparator<T extends User<T>> implements Comparator<T>  {
    public int compare(T user, T userToCompare) {
        return user.getAge() - userToCompare.getAge();
    }
}

class Teacher extends User<String> {
    private Integer salary;

    public Teacher(String id, String firstName, String lastName, int age, int salary) {
        super(id, firstName, lastName, age);
        this.salary = salary;
    }
    public Integer getSalary() { return this.salary; }
    public void setSalary(Integer salary) { this.salary = salary; }
}

class TeachersList {
    public List<Teacher> teachers = new ArrayList<>();

    public void add(Teacher teacher) {
        this.teachers.add(teacher);
    }
}


class TeacherView implements UserView<List<Teacher>> {
    @Override
    public void sendOnConsole(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            System.out.println("\nПреподаватель: " + teacher.getFullName() +
                    "\nВозраст: " + teacher.getAge() + "\nОклад: " + teacher.getSalary());
        }
    }
}

class TeacherService {
    public Teacher create(String id, String firstName, String lastName, int age, int salary) {
        return new Teacher(id, firstName, lastName, age, salary);
    }
    public void change(User<String> teacher, String firstName, String lastName, int age) {
        teacher.firstName = firstName;
        teacher.lastName = lastName;
        teacher.setAge(age);
    }
    public void sendOnConsole(User<String> teacher, int salary) {
        System.out.println("\n*** Создан преподаватель ***\nИмя и фамилия: " + teacher.getFullName() +
                "\nВозраст: " + teacher.getAge());
    }
}

class TeacherController implements UserController<String> {
    private TeacherService teacherService;

    public TeacherController() {
        teacherService = new TeacherService();
    }

    @Override
    public Teacher create(String userid, String firstName, String lastName, int age) {
        return teacherService.create(userid, firstName, lastName, age, 0);
    }

    @Override
    public void sendOnConsole(User<String> teacher) {
        teacherService.sendOnConsole(teacher, 0);
    }
    @Override
    public void change(User<String> teacher, String firstName, String lastName, int age) {
        teacherService.change(teacher, firstName, lastName, age);
    }
}


class Student extends User<Integer> {
    public String groupName;
    public Student(int id, String firstName, String lastName, int age, String groupName) {
        super(id, firstName, lastName, age);
        this.groupName = groupName;
    }
}

class StudentsList {
    public List<Student> students = new ArrayList<>();

    public void add(Student student) {
        this.students.add(student);
    }
}

interface UserView<E> {
    public void sendOnConsole(E users);
}

interface UserController<T> {
    public User<T> create(T userid, String firstName, String lastName, int age);

    void sendOnConsole(User<T> user);

    void change(User<T> user, String firstName, String lastName, int age);
}

class StudentView implements UserView<List<Student>> {
    @Override
    public void sendOnConsole(List<Student> students) {
        for (Student student : students) {
            System.out.println("\nСтудент: " + student.getFullName() +
                    "\nГруппа: " + student.groupName);
        }
    }
}

class StudentController implements UserController<Integer> {
    private String groupName;

    public StudentController(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public Student create(Integer userid, String firstName, String lastName, int age) {
        return new Student(userid, firstName, lastName, age, groupName);
    }

    @Override
    public void sendOnConsole(User<Integer> student) {
    System.out.println("\n*** Создан студент ***\nИмя и фамилия: " + student.getFullName() +
                    "\nГруппа: " + groupName);
        }

    @Override
    public void change(User<Integer> student, String firstName, String lastName, int age) {
        student.firstName = firstName;
        student.lastName = lastName;
        student.setAge(age);
    }
}


public class Homework4 {
    public static void main(String[] args) {
        StudentController studentController = new StudentController("ООП");
        Student ivan = studentController.create(1, "Иван", "Иванов", 34);
        studentController.sendOnConsole(ivan);
        Student peter = studentController.create(2, "Пётр", "Петров", 25);
        studentController.sendOnConsole(peter);
        Student mikhail = studentController.create(3, "Михаил", "Нарциссов", 52);
        studentController.sendOnConsole(mikhail);
        StudentsList oop = new StudentsList();
        oop.add(ivan);
        oop.add(peter);
        oop.add(mikhail);
        StudentView studentView = new StudentView();
        System.out.println("\n*** Итоговый список студентов ***");
        studentView.sendOnConsole(oop.students);
        TeacherController teacherController = new TeacherController();
        Teacher linus = teacherController.create("Teacher1", "Линус", "Торвальдс", 44);
        teacherController.sendOnConsole(linus);
        Teacher mark = teacherController.create("Teacher2", "Марк", "Лутц", 35);
        teacherController.sendOnConsole(mark);
        Teacher nick = teacherController.create("Teacher3", "Николай", "Лобачевский", 231);
        teacherController.sendOnConsole(nick);
        TeachersList professors = new TeachersList();
        professors.add(linus);
        professors.add(mark);
        professors.add(nick);
        linus.setSalary(100000);
        mark.setSalary(100000);
        nick.setSalary(200000);
        teacherController.change(nick, "Николай", "Лобачевский", 31);
        TeacherView teacherView = new TeacherView();
        System.out.println("\n*** Итоговый список преподавателей ***");
        teacherView.sendOnConsole(professors.teachers);
    }
}


