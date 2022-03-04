import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ParkingSuccessGenerator extends MonteCarloCore {

    Random randSeed;

    double scenario1;
    double scenario2;
    double scenario3;

    int nReplications;
    int n;

    int pas = 0;

    Random randK;
    ArrayList<Random> randsArray;

    public ParkingSuccessGenerator(int nReplications, int n)
    {
        this.n = n;
        this.nReplications = nReplications;

        this.doReplications(nReplications);
    }



    @Override
    public void oneReplication()
    {
        int k = this.randK.nextInt(this.n) + 1;

        ArrayList<Boolean> isFree = new ArrayList<>(Arrays.asList(new Boolean[this.n]));
        Collections.fill(isFree, Boolean.TRUE);

        ArrayList<Integer> freeParkPlaces = new ArrayList<>(this.n);
        for (int j = 0; j < this.n; j++)
        {
            freeParkPlaces.add(j);
        }

        for (int j = 0; j < k; j++)
        {
            int carDeploy = this.randsArray.get(j).nextInt(freeParkPlaces.size());
            isFree.set(freeParkPlaces.get(carDeploy), Boolean.FALSE);
            freeParkPlaces.remove(carDeploy);
        }

        isFree.set(2, Boolean.FALSE);
        isFree.set(5, Boolean.FALSE);
        isFree.set(8, Boolean.FALSE);

        for (int j = (this.n - 1); j >= 0; j--)
        {
            if (isFree.get(j))
            {
                this.scenario1 += j + 1;
                break;
            }
            if (j == 0)
            {
                this.scenario1 += 3 * this.n;
            }
        }

        for (int j = ((this.n) / 3) - 1; j >= 0; j--)
        {
            if (isFree.get(j))
            {
                this.scenario2 += j + 1;
                break;
            }
            if (j == 0)
            {
                this.scenario2 += 3 * this.n;
                this.pas++;
            }
        }

        for (int j = (this.n / 2) - 1 ; j >= 0; j--)
        {
            if (isFree.get(j))
            {
                this.scenario3 += j + 1;
                break;
            }

            if (j == 0)
            {
                this.scenario3 += 3 * this.n;
            }
        }
    }

    @Override
    public void beforeReplications() {

        this.randSeed = new Random();

        this.scenario1 = 0;
        this.scenario2 = 0;
        this.scenario3 = 0;

        this.randK = new Random(this.randSeed.nextInt());

        this.randsArray = new ArrayList<>(this.n);
        for (int j = 0; j < this.n; j++)
        {
            this.randsArray.add(new Random(this.randSeed.nextInt()));
        }
    }

    @Override
    public void afterReplications() {
        System.out.println("SC1: " + this.scenario1 / this.nReplications);
        System.out.println("SC2: " + this.scenario2 / this.nReplications);
        System.out.println("SC3: " + this.scenario3 / this.nReplications);


        System.out.println(1);
        System.out.println(this.scenario2/this.scenario1);
        System.out.println(this.scenario3/this.scenario1);

        System.out.println("Pas: " + this.pas);
    }
}
