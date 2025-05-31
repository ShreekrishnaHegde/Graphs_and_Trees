package Graphs.Problems;

import java.util.*;

/*
https://www.geeksforgeeks.org/problems/word-ladder-ii/1
https://leetcode.com/problems/word-ladder-ii/description/
 */
public class WordLadder2 {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<String>> findSequences(String startWord,String targetWord,String[] wordList){
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        Set<String> st=new HashSet<>();
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> usedOnLevel=new ArrayList<>();
        int length=wordList.length;
        int level=0;

        ArrayList<String> ls=new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        usedOnLevel.add(startWord);
        for (int i=0;i<length;i++){
            st.add(wordList[i]);
        }

        while (!q.isEmpty()){
            ArrayList<String> vec=q.peek();
            q.remove();
            //erase all the words that has been used in the previous levels to transform
            if (vec.size()>level){
                level++;
                for (String item: usedOnLevel){
                    st.remove(item);
                }
            }
            String word=vec.getLast();
            if (word.equals(targetWord)){
                //first sequence where we reached the end
                if (ans.isEmpty())ans.add(vec);
                else if (ans.get(0).size()==vec.size())ans.add(vec);
            }
            for (int i=0;i<length;i++){
                for (char ch='a';ch<='z';ch++){
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedString=new String(replacedCharArray);
                    if (st.contains(replacedString)){
                        vec.add(replacedString);
                        ArrayList<String> temp=new ArrayList<>();
                        q.add(temp);
                        usedOnLevel.add(replacedString);
                        vec.removeLast();
                    }
                }
            }
        }
        return ans;
    }

}
/*

 */
