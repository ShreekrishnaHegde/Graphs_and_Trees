package Graphs.Problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
https://www.geeksforgeeks.org/problems/word-ladder/1
https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder1 {
    class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args) {

    }
    public int wordLadderLength(String startWord,String targetWord,String[] wordList){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String> st=new HashSet<>();
        int length=wordList.length;

        for (int i=0;i<length;i++){
            st.add(wordList[i]);
        }

        st.remove(startWord);

        while (!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            if(word.equals(targetWord))return steps;
            for (int i=0;i<length;i++){
                for (char ch = 'a'; ch <= 'z' ; ch++) {
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
/*
TC: N X word.length
SC: N
 */