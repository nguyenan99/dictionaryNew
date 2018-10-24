package nta.uet.vnu;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryManagement {
    private static ArrayList<Word>dsData = new ArrayList<Word>();
    static Scanner sc = new Scanner(System.in);

    /*public static void insertFromCommandline()
    {
    }*/
    public static void  showAllWords()
    {
        System.out.println("Show all : " + "\n");
        for(int i=0;i<dsData.size();i=i+1)
        {
            System.out.println(dsData.get(i).getWord_target() +"\t" + dsData.get(i).getWord_explain()) ;
            System.out.println("\n");
        }
    }
    public static void insertFromFile() {

        try {
            FileInputStream fis = new FileInputStream("DATA.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line ;
            String s1,s2;
            while((line=br.readLine())!=null)
            {
               s1 = line.substring(0,line.indexOf("\t"));
               s2 = line.substring(line.lastIndexOf("\t")+1);
                Word W = new Word(s1,s2);
               dsData.add(W);
            }
            br.close();
            fis.close();
            isr.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   public static void Sort()
   {
       Collections.sort(dsData, new Comparator<Word>() {
           @Override
           public int compare(Word w1, Word w2) {
               if(w1.getWord_target().compareTo(w2.getWord_target())==0)
                   return w1.getWord_explain().compareTo(w2.getWord_explain());
               else
                   return w1.getWord_target().compareTo(w2.getWord_target());
           }
       });
   }

    public static void Sharcher()
    {
        System.out.println("Nhập từ tiếng anh :");
        String voc = sc.nextLine();
        voc =voc.trim();
        int temp =0;
        for(int i=0;i<dsData.size();i++)
        {
            if(dsData.get(i).getWord_target().compareToIgnoreCase(voc)==0)
            {
                    temp ++;
                    System.out.println(dsData.get(i).getWord_explain());
            }
            if(i== dsData.size()-1 && temp==0)
            {
                System.out.println("Từ muốn tìm không tồn tại !!!");
            }
        }
    }
    public static void More()
    {
        Word w1 = new Word();
        System.out.println("Từ :" );
        w1.setWord_target(sc.nextLine());
        System.out.println("Nghĩa :");
        w1.setWord_explain(sc.nextLine());
        int temp =0;
        for(int i =0;i<dsData.size();i++)
        {
            if(dsData.get(i).getWord_target().equals(w1.getWord_target())== true && dsData.get(i).getWord_explain().equals(w1.getWord_explain())==true) {
                System.out.println("Từ này đã tồn tại");
                temp ++;
                break;
            }
        }
        if(temp == 0)
        {
            dsData.add(w1);
            SaveToFile();
            System.out.println("Lưu từ thành công");
        }
        else
            System.out.println("Lưu từ thất bại");
    }
    public static void delete() {
        int temp =1;
            System.out.println("Từ Muốn Xóa : ");
            String tu = sc.nextLine();
            System.out.println("Nghĩa từ muốn xóa : ");
            String nghia = sc.nextLine();
            Word w = new Word(tu, nghia);
            for (int i = 0; i < dsData.size(); i++) {
                if (dsData.get(i).getWord_target().equals(w.getWord_target())==true && dsData.get(i).getWord_explain().equals( w.getWord_explain()) ==true) {
                    dsData.remove(i);
                    temp++;
                    System.out.println("Xóa từ thành công");
                    break;
                }
            }
        if(temp ==1)
        {
            System.out.println("Xóa từ thất bại");
        }
       SaveToFile();
    }
    public static void SaveToFile()
    {
        Sort();
        try {
            FileOutputStream fos = new FileOutputStream("DATA.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for(int i=0;i<dsData.size();i++)
            {
                bw.write(dsData.get(i).getWord_target()+"\t" + dsData.get(i).getWord_explain());
                bw.newLine();
            }
            bw.close();
            fos.close();
            osw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void change(){
        System.out.println("Nhập từ muốn thay đổi");
        String tu = sc.nextLine();
        tu = tu.trim();
        for(int i=0;i<dsData.size();i++)
        {
            if(dsData.get(i).getWord_target().equals(tu)==true )
            {
                System.out.println("Bạn muốn thay đổi từ thành : ");
                dsData.get(i).setWord_target(sc.nextLine());
                System.out.println("Bạn muốn thay đổi nghĩa thành :");
                dsData.get(i).setWord_explain(sc.nextLine());
                System.out.println("Thay đổi thành công");
                break;
            }
            if(i==dsData.size()-1)
                System.out.println("Không tìm thấy !!!");
        }
        Sort();
        SaveToFile();
    }
}
