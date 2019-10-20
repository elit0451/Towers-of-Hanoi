import java.util.Stack;

public class Tower {

    private int _disksNr;
    private int _iterCount;

    Stack<Integer> Tower1 = new Stack<>();
    Stack<Integer> Tower2 = new Stack<>();
    Stack<Integer> Tower3 = new Stack<>();

    public Tower(int disk)
    {
        _disksNr = disk;

        for (int i = disk; i > 0; i--)
        {
            Tower1.push(i);
        }
    }

    private void move(int disk, Stack<Integer> TowerA, Stack<Integer> TowerB, Stack<Integer> TowerC)
    {
        if(disk == 1)
        {
            TowerB.push(TowerA.pop());

            //Increment for every iteration
            _iterCount++;
            printIteration(_iterCount);

            return;
        }

        move(disk - 1, TowerA, TowerC, TowerB);
        TowerB.push(TowerA.pop());

        //Increment for every iteration
        _iterCount++;
        printIteration(_iterCount);

        move(disk - 1, TowerC, TowerB, TowerA);

    }

    public void solve() {
        //Start with 2nd and 3rd tower reversed, so that the disks end up on the 3rd tower
        //Else they will be on the 2nd
        move(_disksNr, Tower1, Tower3, Tower2);
    }

    public void print(int towerNr) {
        Stack<Integer> temp = new Stack<>();

        switch(towerNr) {
            case 1: temp = (Stack<Integer>) Tower1.clone();
                break;
            case 2: temp = (Stack<Integer>) Tower2.clone();
                break;
            case 3: temp = (Stack<Integer>) Tower3.clone();
                break;
            default:
                System.out.println("No tower exists");
        }

        System.out.println("\nTower " + towerNr + ":");
        while(!temp.empty()) {
            System.out.println(temp.pop());
        }
    }

    public void printIteration(int iterationCount) {
        //Print 3 towers for an iteration
        System.out.println("\n\tITERATION " + iterationCount);
        print(1);
        print(2);
        print(3);
    }
}
