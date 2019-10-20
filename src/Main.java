public class Main {

    public static void main(String[] args) {
        Main myProg = new Main();
        myProg.run();
    }

    private void run() {
        //Populate a tower with 3 disks
        Tower TOH = new Tower(3);

        TOH.solve();
    }
}
