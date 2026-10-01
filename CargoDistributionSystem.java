class Courier{
    private String name;
    private int packageCount;
    private int deliveryDuration;


    public Courier(String name, int packageCount, int deliveryDuration) {
        this.name = name;
        this.packageCount = packageCount;
        this.deliveryDuration = deliveryDuration;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getPackageCount() {
        return packageCount;
    }


    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }


    public int getDeliveryDuration() {
        return deliveryDuration;
    }


    public void setDeliveryDuration(int deliveryDuration) {
        this.deliveryDuration = deliveryDuration;
    }

}


class DeliveryTask implements Runnable{

    private Courier courier;

    public  DeliveryTask(Courier courier){
        this.courier = courier;
    }

    @Override
    public void run() {
        
        for(int i = 1; i <= courier.getPackageCount(); i++){
            System.out.println(Thread.currentThread().getName() + " - " + courier.getName() + " -> Package " + i + " picked up.");
            threadPause(courier.getDeliveryDuration());
            System.out.println(Thread.currentThread().getName() + " - " + courier.getName() + " -> Package " + i + " on the way.");
            threadPause(courier.getDeliveryDuration());
            System.out.println(Thread.currentThread().getName() + " - " + courier.getName() + " -> Package " + i + " delivered.");

            if(i == 3){
                Thread.yield();
            }
        }

        
    }

    void threadPause(int duraction){
        try{
            Thread.sleep(duraction);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class CargoDistributionSystem {
    public static void main(String[] args) {

        Courier courier1 = new Courier("Ahmet", 5, 800);
        Courier courier2 = new Courier("Zeynep", 4, 600);
        Courier courier3 = new Courier("Mehmet", 6, 1000);

        DeliveryTask deliveryTask1 = new DeliveryTask(courier1);
        Thread thread1 = new Thread(deliveryTask1);
        thread1.setName("Courier1");
        thread1.setPriority(5);
        thread1.start();

        DeliveryTask deliveryTask2 = new DeliveryTask(courier2);
        Thread thread2 = new Thread(deliveryTask2);
        thread2.setName("Courier2");
        thread2.setPriority(8);
        thread2.start();

        DeliveryTask deliveryTask3 = new DeliveryTask(courier3);
        Thread thread3 = new Thread(deliveryTask3);
        thread3.setName("Courier3");
        thread3.setPriority(3);
        thread3.start();

        try{
            thread1.join();
            thread2.join();
            thread3.join();

            System.out.println("All package completed");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
