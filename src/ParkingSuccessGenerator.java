import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ParkingSuccessGenerator extends MonteCarloCore {

    Random randSeed = new Random();

    double scenario1 = 0;
    double scenario2 = 0;
    double scenario3 = 0;

    int nBounds = 2000;

    Random randN = new Random(randSeed.nextInt());
    Random randK = new Random(randSeed.nextInt());
    int n = randN.nextInt(nBounds) + 10;

    public ParkingSuccessGenerator(int nReplications)
    {
        this.doReplications(nReplications);
        System.out.println("SC1: " + scenario1 / nReplications);
        System.out.println("SC2: " + scenario2 / nReplications);
        System.out.println("SC3: " + scenario3 / nReplications);


        System.out.println(1);
        System.out.println(scenario2/scenario1);
        System.out.println(scenario3/scenario1);

    }



    @Override
    public void oneReplication()
    {
        int k = randK.nextInt(n) + 1;

        ArrayList<Boolean> isFree = new ArrayList<>(Arrays.asList(new Boolean[n]));
        Collections.fill(isFree, Boolean.TRUE);

        ArrayList<Integer> freeParkPlaces = new ArrayList<>(n);
        for (int j = 0; j < n; j++)
        {
            freeParkPlaces.add(j);
        }

        ArrayList<Random> randsArray = new ArrayList<>(n);
        for (int j = 0; j < n; j++)
        {
            randsArray.add(new Random(randSeed.nextInt()));
        }


        for (int j = 0; j < k; j++)
        {
            int carDeploy = randsArray.get(j).nextInt(freeParkPlaces.size());
            isFree.set(freeParkPlaces.get(carDeploy), Boolean.FALSE);
            freeParkPlaces.remove(carDeploy);
        }

        isFree.set(2, Boolean.FALSE);
        isFree.set(5, Boolean.FALSE);
        isFree.set(8, Boolean.FALSE);

        for (int j = (n - 1); j >= 0; j--)
        {
            if (isFree.get(j))
            {
                scenario1 += j + 1;
                break;
            }
            if (j == 0)
            {
                scenario1 += 3 * n;
            }
        }

        for (int j = (2 * (n - 1) / 3); j >= 0; j--)
        {
            if (isFree.get(j))
            {
                scenario2 += j + 1;
                break;
            }
            if (j == 0)
            {
                scenario2 += 3 * n;
            }
        }

        for (int j = ((n - 1) / 2); j >= 0; j--)
        {
            if (isFree.get(j))
            {
                scenario3 += j + 1;
                break;
            }

            if (j == 0)
            {
                scenario3 += 3 * n;
            }
        }
    };
}
