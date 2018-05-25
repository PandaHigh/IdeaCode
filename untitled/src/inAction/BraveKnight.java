package inAction;

public class BraveKnight implements Knight{
    private Quest oneQuest;
    public BraveKnight(Quest oneQuest){
        this.oneQuest=oneQuest;
    }
    public void embarkOnQuest(){
        oneQuest.embark();
    }
}
