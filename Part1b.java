
/**

 * *see README.TXT
 *N5b
 * @author Dimgba Martha Otisi 
 * @2020,January
 * @martha_samuel_ 
 * 
 */
public class Part1b {
public int findStopCodon(String dna, int startIndex, String stopCodon){
    //find the "TAA", starting from(startindex +3),call this result currindex
    int currIndex = dna.indexOf(stopCodon, startIndex+3);
    //as long as currindex is !-1
    while(currIndex != -1) {
    
        //check if (currindex - startindex) is a multiple of 3
        int diff = currIndex - startIndex;
        if(diff % 3 == 0){
            //if so currindex is your answer,return it
            return currIndex;
        }
        //if not,update currindex to the index of the nest "TAA" starting from (currindex+1
       
            else{
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
            //starting from currindex +1
            //if we exit loop,we didnt find stopcodon
            //so return dnastr.length()
           return dna.length();
        }
    
  public void testFindStopCodon(){
   //01234567890123456789012345
   String dna = "xxxyyzzzTAAxxxyyyzzzTAAxx";
   int dex = findStopCodon(dna, 0,"TAA");
    System.out.println(dex);
   
   dex = findStopCodon(dna, 9,"TAA");
    System.out.println(dex);
    
   dex = findStopCodon(dna, 1,"TAA");
    System.out.println(dex); 
    
      dex = findStopCodon(dna, 0,"TAG");
      System.out.println(dex);
    }
      
     
public String findGene(String dna){
   //find the first occurence of "ATG" and call its index stratIndex
   int startIndex = dna.indexOf("ATG");
   //if startindex is -1 the answer is an empty string
   if (startIndex == -1){
       return"";
    }
       //use taaindex to store findstopcodon(dnastr, startindex,"TAA") and call the result taaindex
       int taaIndex = findStopCodon(dna, startIndex, "TAA");
       //use tagindex to store findstopcodon(dnastr, startindex,"TGA") and call the result tgaindex
   int tagIndex = findStopCodon(dna, startIndex, "TAG");
  //use tgaindex to store findstopcodon(dnastr, startindex,"TAG") and call the result tagindex
  int tgaIndex = findStopCodon(dna, startIndex, "TGA");
  //take the smallest taaindex,tagindex and tgaindex,call it minindex
  //int temp = Math.min(taaIndex, tagIndex);
  //int minIndex = Math.min(temp, tgaIndex);
  int minIndex = 0;
  if(taaIndex == -1 ||
  //if(minIndex ==-1 OR
   (tagIndex != -1 && tagIndex < taaIndex)){
       //then set minIndex to tgaIndex
       minIndex = tagIndex;
    }
       //else set  min Index to  taaIndex
    else
    {
        minIndex = taaIndex;
    }
   //if  minIndex == -1 OR
   if(minIndex == -1 ||
   //if taaIndex! = -1 and taaIndex<minIndex;
   (tgaIndex != -1 && tgaIndex < minIndex)){
      //then set minIndex to tagIndex
      minIndex = tgaIndex;
    }
    //if minIndex == -1, return""
    if(minIndex == -1) {
        return "";
    }
    return dna.substring(startIndex, minIndex+3);
}
 
             
public void testFindGene(){
    
    String one = "ATFCCCAAATACTAAGCCTAGAAA";
    String two = "CAAATGGGCGTCACTAGATAACCG";
    String three = "ACCATGGGGAAAGTCTGAACCTAGCCA";
    String four = "ACCATGTCCGGAAATCCCTGAGGGTAGCCC";
    String five = "ACCTACATGAAACCCTACGAT";
    
    System.out.println("Gene is: " + one + " " + findGene(one));
    System.out.println("Gene is: " + two + " " + findGene(two));
    System.out.println("Gene is: " + three + " " + findGene(three));
    System.out.println("Gene is: " + four + " " + findGene(four));
    System.out.println("Gene is: " + five + " " + findGene(five));
}


   public void printAllGenes(String dna){
            
            while(true){
                String gene = findGene(dna);
                if(gene.isEmpty()){
                
                break;
            } else
        {
            System.out.println(gene);
        }
    }
}

public static void main(){
    Part1b test = new Part1b();
    test.testFindGene();
}
}

