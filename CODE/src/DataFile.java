//class for a single DataFile
public class DataFile
{
    //array to keep trace of which page is available
    private Byte[] pagesStatus = null;

    public DataFile(){
        pagesStatus = new Byte[DBParams.maxPagesPerFile];
        this.init();
    }

    //Initiate the byte array to 0
    private void init(){
        if (pagesStatus != null)
            for (int i = 0; i < DBParams.maxPagesPerFile; i++)
                pagesStatus[i] = 0;
    }

    //return the index of first available page in file, or -1 if there is not
    public int PageAvailable(){
        for (int i = 0; i < DBParams.maxPagesPerFile; i++)
            if (pagesStatus[i] == 0)
                return (i);
        return (-1);
    }
}