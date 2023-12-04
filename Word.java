public class Word
{
   private int[] letterFrequency=new int[26];
   private boolean properNoun;
   private String w;
   public Word(String word)
   {
      w=word;
      properNoun=(int)(word.charAt(0))<=90?true:false;
      String w=word.toLowerCase();
      for(int i=0;i<word.length();i++)
      {
         letterFrequency[(int)(w.charAt(i))-97]+=1;
      }
   }
   public boolean isValid()
   {
      int max=0;
      for(int i=0;i<26;i++)
      {
         if(letterFrequency[i]>max)
            max=i;
      }
      if(letterFrequency[max]>2)
         return false;
      return true;
   }
   public int[] getFrequency()
   {
      return letterFrequency;
   }
   public String toString()
   {
      return w;
   }
   
}
