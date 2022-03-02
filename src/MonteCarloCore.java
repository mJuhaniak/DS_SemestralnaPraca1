public abstract class MonteCarloCore {

    public void doReplications(int nReplications)
    {
        for (int i = 0; i < nReplications; i++)
        {
            oneReplication();
        }
    };

    public abstract void oneReplication();
}
