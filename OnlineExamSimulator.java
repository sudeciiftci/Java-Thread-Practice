class Student {
    private String name;
    private int duraction;

    public Student(String name, int duraction) {
        this.name = name;
        this.duraction = duraction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuraction() {
        return duraction;
    }

    public void setDuraction(int duraction) {
        this.duraction = duraction;
    }
}

class MyThread implements Runnable {

    private Student student;

    public MyThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                student.getName() + " -> Question " + i + " solved."
            );

            try{
                Thread.sleep(student.getDuraction());
            }catch(InterruptedException e){
            e.printStackTrace();
            }

            
        }
        
        System.out.println(student.getName() + " finished the exam.");
        

    }
}

public class OnlineExamSimulator {

    public static void main(String[] args) {

        Student student1 = new Student("Ali", 1000);
        MyThread myThread1 = new MyThread(student1);
        Thread thread1 = new Thread(myThread1);
        thread1.start();

        Student student2 = new Student("Ayşe", 500);
        MyThread myThread2 = new MyThread(student2);
        Thread thread2 = new Thread(myThread2);
        thread2.start();

        Student student3 = new Student("Mehmet", 700);
        MyThread myThread3 = new MyThread(student3);
        Thread thread3 = new Thread(myThread3);
        thread3.start();

        try{
            thread1.join();
            thread2.join();
            thread3.join();

            System.out.println("All students finished the exam.");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}