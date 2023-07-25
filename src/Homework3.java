import java.util.*;


class Faculty {
    private String facultyName;
    private List<StudentStream> studentStreams;
    public Faculty(String facultyName) {
        this.facultyName = facultyName;
        this.studentStreams = new ArrayList<>();
    }

    public void add(StudentStream stream) {
        this.studentStreams.add(stream);
    }

    public List<StudentStream> getStudentStreams() {
        return this.studentStreams;
    }

    public String getFacultyName() {
        return this.facultyName;
    }
}
class StudentStream implements Iterable<StudentGroup> {
    private int streamID;
    private List<StudentGroup> groups;

    public StudentStream(int streamID) {
        this.streamID = streamID;
        this.groups = new ArrayList<>();
    }

    public void add(StudentGroup group) {
        this.groups.add(group);
    }

    public int getStreamID() {
        return streamID;

    }

    public List<StudentGroup> getGroups() {
        return groups;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("\nПоток: " + streamID + " количество групп: " + groups.size() +
                "\nГруппы, входящие в поток:");
        for (StudentGroup group : groups) {
            result.append("\n").append(group.toString());
        }
        return result.toString();
    }

    public Iterator<StudentGroup> iterator() {
        return groups.iterator();
    }

    public int compareTo(StudentStream streamToCompare) {
        return Integer.compare(this.getGroups().size(), streamToCompare.getGroups().size());
    }
}
class StreamComparator implements Comparator<StudentStream> {
    public int compare(StudentStream s1, StudentStream s2) {
        return s1.getGroups().size() - s2.getGroups().size();
    }
}

class StreamService {
    public void sortStudentStreams(List<StudentStream> streamsToSort) {
        Collections.sort(streamsToSort, new StreamComparator());
    }
}

class Controller {
    private StreamService streamService;

    public Controller() {
        streamService = new StreamService();
    }

    public void sortStreams(List<StudentStream> streamsToSort) {
        streamService.sortStudentStreams(streamsToSort);
    }
}
class StudentGroup implements Comparable<StudentGroup> {

    private String groupName;
    private int studentsTotal;


    public StudentGroup(String groupName, int studentsTotal) {
        this.groupName = groupName;
        this.studentsTotal = studentsTotal;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getStudentsTotal() {
        return studentsTotal;
    }

    public int compareTo(StudentGroup groupToCompare) {
        return Integer.compare(this.studentsTotal, groupToCompare.studentsTotal);
    }

    public String toString() {
        return "Группа: " + groupName + " --- Количество студентов: " + studentsTotal;
    }
}

public class Homework3 {
    public static void main(String[] args) {
        Faculty programmingLanguages = new Faculty("Языки программирования");

        StudentStream streamOne = new StudentStream(1);
        StudentStream streamTwo = new StudentStream(2);
        StudentStream streamThree = new StudentStream(3);

        StudentGroup group1 = new StudentGroup("Python", 20);
        StudentGroup group2 = new StudentGroup("Java", 15);
        StudentGroup group3 = new StudentGroup("C#", 10);
        StudentGroup group4 = new StudentGroup("GoLang", 14);
        StudentGroup group5 = new StudentGroup("Kotlin", 13);
        StudentGroup group6 = new StudentGroup("C++", 12);

        streamOne.add(group1);
        streamOne.add(group2);
        streamOne.add(group3);

        streamTwo.add(group4);
        streamTwo.add(group5);

        streamThree.add(group6);

        programmingLanguages.add(streamOne);
        programmingLanguages.add(streamTwo);
        programmingLanguages.add(streamThree);

        System.out.println("\n*****\nФакультет: " + programmingLanguages.getFacultyName());

        System.out.println("\nИсходный список потоков:");
        for (StudentStream stream : programmingLanguages.getStudentStreams()) {

            System.out.println(stream);

        }

        Controller sorter = new Controller();
        sorter.sortStreams(programmingLanguages.getStudentStreams());

        System.out.println("\nСписок потоков после сортировки по количеству групп:");

        for (StudentStream stream : programmingLanguages.getStudentStreams()) {

            System.out.println(stream);

        }
        System.out.println("\n*****");
    }
}