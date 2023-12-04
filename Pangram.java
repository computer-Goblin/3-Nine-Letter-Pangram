import java.util.*;
import java.io.*;
public class Pangram
{
   public static void main (String[] args)
   {
      
      Pangram p=new Pangram();
      File f=new File("NineLetterWords.txt");
      int count=p.count(f);
      p.makeArray(f,count);
      p.check();
   }
   
   private Scanner sc;
   private Word[] arr;
   public int count(File f)
   {
      try{
         sc=new Scanner(f);
      
      }catch(Exception e)
      {
         System.exit(0);
      }
      int count=0;
      while (sc.hasNextLine())
      {
         String s=sc.next();
         Word w=new Word(s);
         if(w.isValid())
            count++;
      }
      sc.close();
      return count;
   }
   public void makeArray(File f,int count)
   {
      try{
         sc=new Scanner(f);
      }catch(Exception e)
      {
         System.exit(0);
      }
      arr=new Word[count];
      for(int i=0;i<count;i++)
      {
         Word w=new Word(sc.next());
         arr[i]=w;
      }
   }
   public boolean join(Word w,Word w1)
   {
      int arr1[]=w.getFrequency();
      int arr2[]=w1.getFrequency();
      for(int i=0;i<26;i++)
      {
         if(arr1[i]+arr2[i]>2)
            return false;
      }
      return true;
   }
   public boolean join(Word w, Word w1, Word w2)
   {
      int[] arr1=w.getFrequency();
      int[] arr2=w1.getFrequency();
      int[] arr3=w2.getFrequency();
      for(int i=0;i<26;i++)
      {
         if(arr1[i]+arr2[i]+arr3[i]==0)
         {
            return false;
         }
      }
      return true;
   }
   public void check()
   {
      for(int w1=0;w1<arr.length;w1++)
      {
         for(int w2=0;w2<arr.length;w2++)
         {
            if(join(arr[w1],arr[w2]))
            {
               for(int w3=0;w3<arr.length;w3++)
               {
                  if(join(arr[w1],arr[w2],arr[w3]))
                  {
                     System.out.println(""+arr[w1]+" "+arr[w2]+" "+arr[w3]);
                     return;
                  }
               }
               
            }
         }
         System.out.println("Iterations 1: "+w1);
      }
   }
}

