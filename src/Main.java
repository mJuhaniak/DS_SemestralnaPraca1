public class Main {

    public static void main(String [] args)
    {
        //ParkingSuccessGenerator p = new ParkingSuccessGenerator(100000);

        /*Random randSeed = new Random();
        double replications = 10000;

        double scenario1 = 0;
        double scenario2 = 0;
        double scenario3 = 0;

        int nBounds = 200;

        Random randN = new Random(randSeed.nextInt());
        Random randK = new Random(randSeed.nextInt());
        int n = randN.nextInt(nBounds) + 10;

        for (int i = 0; i < replications; i++)
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
        }

        System.out.println("SC1: " + scenario1 / replications);
        System.out.println("SC2: " + scenario2 / replications);
        System.out.println("SC3: " + scenario3 / replications);
        */

        /*ArrayList<Random> rands = new ArrayList<>(10);
        for (int j = 0; j < 10; j++)
        {
            rands.add(new Random(randSeed.nextInt()));
        }
        int places = 9;
        for (int i = 0; i < 6; i++)
        {
            int rand = rands.get(places).nextInt(places + 1);
            System.out.println(rand);
            places--;
        }*/

    }
}
