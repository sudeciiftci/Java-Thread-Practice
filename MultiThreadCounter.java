class Counter{
    private int count = 0;

    synchronized void increment(){
        count ++;
    }

    public int getCount() {
        return count;
    }

}

class CounterTask extends Thread{
    private Counter counter;

    public CounterTask(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 1; i <=1000; i++){
            counter.increment();
        }
    }

    

    
}

public class MultiThreadCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();

        CounterTask counterTask1 = new CounterTask(counter);
        CounterTask counterTask2 = new CounterTask(counter);

        counterTask1.start();
        counterTask2.start();

        try{
            counterTask1.join();
            counterTask2.join();

            System.out.println("Final count: " + counter.getCount());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
