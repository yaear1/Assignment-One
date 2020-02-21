
import java.io.*;
import java.util.*;

public class AssignmentOne { 
  
  static class Artist {
    public String name;
    public Artist next;
    
   
   

  }

 static class TopStreamingArtists {
    static int cnt = 0;
    private Artist first;
    public void TopStreamingArtists(){
      first = null;
    }
    public boolean isEmpty(){
     return (first == null);
    }
    public void insert(String str){
       Artist artist = new Artist();
       artist.name = str;
       artist.next = null;
       
       if(first == null){
         first = artist;
       }
       else
       {
         Artist n = first;
         while(n.next != null){
         n = n.next;
       }
         n.next = artist;
       }
       cnt++;
    }
       
    public int size(){
      return cnt;
    }
     
   
     public void display(){
       Artist a = first;
       while(a.next != null){
         System.out.println(a.name);
       }
     }
    
 }
  
  public static void sort(String [][] str){
    
    for (int i = 0; i < str.length; i++) 
        {
            for (int j = i + 1; j < str.length; j++) 
            { 
              if (str[i][0].compareTo(str[j][0]) > 0) 
                {
                    String temp = str[i][0];
                    str[i][0] = str[j][0];
                    str[j][0] = temp;
                }
            }
        }
  }

  public static void main(String[] args) throws Exception{
    int rows = 203; 
    int columns = 5;
    String[][] spfy = new String[203][5];  // Creates 2D array that records data
    
    String [][] numArtists = new String [rows][2]; // Creates 2D array that will record frequency of artist on chart

    String [] splitData = new String[rows*columns];
        String fileName = "global.csv";
        File file = new File(fileName);
        
          Scanner inputStream = new Scanner(fileName);
          while(inputStream.hasNext()){ // Inputs data from file into 2D array
           String data = inputStream.next();
           splitData = data.split(",");
           for(int i = 0; i < rows; i++){
              for(int j = 0; j < columns; j++){
                spfy[i][j] = "n";
              }
            }
            
          }
          inputStream.close();
        
        
        int cnt = 0;
        for(int i = 0; i < rows; i++){  // counts how many times each artist is in the 2D array
          for(int j = 1; j < rows; j++){
           if(spfy[i][0] == spfy[j][0])
             cnt++;
          }
          numArtists[i][0] = spfy[i][0];
          numArtists[i][1] = String.valueOf(cnt); 
          cnt = 0;
        }
        
        for(int i = 0; i < rows-1; i++){     // Removes element from array if artist is mentioned more than 
          for(int j = 1; j < rows; j++){   // once and shifts array
            if(numArtists[i][0] == numArtists[j][0]){
              for(int n = i; n < rows; n++)
              numArtists[i][0] = numArtists[i+1][0];
            }
          }
        }
        
        sort(numArtists); // sorts array
        
          TopStreamingArtists artistNames = new TopStreamingArtists(); //Creates Sorted Linked List
          for(int i = 0;i < rows;i++){
            for(int j = 0;j < columns;j++){
    artistNames.insert(numArtists[i][j]);
            }
          }
    artistNames.display();
    }
  }

 

        
