package nta.uet.vnu;

public class DictionaryCommandLine {
   /* public static void dictionaryBasic()
    {
        DictionaryManagement a = new DictionaryManagement();
        *//*a.insertFromCommandline();*//*
        a.showAllWords();

    }*/
    public static void dictionaryAdvanced(){
        DictionaryManagement h = new DictionaryManagement();
/*
        h.insertFromCommandline();
*/
        h.insertFromFile();
        h.showAllWords();
       // h.Sharcher();
       // h.More();
        h.delete();
        h.change();
        h.Sharcher();
    }
    public static void main(String[] args) {
        DictionaryCommandLine dc = new DictionaryCommandLine();
        dc.dictionaryAdvanced();

    }

}

