public abstract class MonteCarloCore {

    public void doReplications(int nReplications)
    {
        beforeReplications();

        for (int i = 0; i < nReplications; i++)
        {
            oneReplication();
        }

        afterReplications();
    }

    public abstract void oneReplication();
    public abstract void beforeReplications();
    public abstract void afterReplications();
}
