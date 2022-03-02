import java.util.Random;

public class BuffonNeedleGenerator extends MonteCarloCore{

    Random randAlpha = new Random();
    Random randX = new Random();

    double L = 9;
    double D = 10;
    double m = 0;

    public BuffonNeedleGenerator(int nReplications)
    {
        this.doReplications(nReplications);
        System.out.println("Buffon needle: " + (2 * L * nReplications) / (D * m) );
    }

    @Override
    public void oneReplication() {
        double alpha = Math.toRadians(randAlpha.nextDouble() * 180);
        double x = randX.nextDouble() * D;

        double a = L * Math.sin(alpha);

        if (a + x > D)
        {
            m++;
        }
    }
}
