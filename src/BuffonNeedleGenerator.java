import java.util.Random;

public class BuffonNeedleGenerator extends MonteCarloCore{

    Random randAlpha;
    Random randX;

    double L;
    double D;
    double m;

    int nReplications;

    public BuffonNeedleGenerator(int nReplications)
    {
        this.nReplications = nReplications;

        this.doReplications(nReplications);
    }

    @Override
    public void oneReplication() {
        double alpha = Math.toRadians(this.randAlpha.nextDouble() * 180);
        double x = this.randX.nextDouble() * this.D;

        double a = this.L * Math.sin(alpha);

        if (a + x > this.D)
        {
            this.m++;
        }
    }

    @Override
    public void beforeReplications() {
        this.randAlpha = new Random();
        this.randX = new Random();

        this.L = 9;
        this.D = 10;
        this.m = 0;
    }

    @Override
    public void afterReplications() {
        System.out.println("Buffon needle: " + (2 * this.L * this.nReplications) / (this.D * this.m) );
    }
}
