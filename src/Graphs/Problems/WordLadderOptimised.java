package Graphs.Problems;

import java.lang.reflect.Array;
import java.util.*;

/*
https://leetcode.com/problems/word-ladder-ii/description/
 */
public class WordLadderOptimised {
    String b;
    HashMap<String,Integer> mpp;
    List<List<String>> ans;

    public static void main(String[] args) {

    }
    public List<List<String>> findLadders(String beginWord,String endWord,String[] wordList){
        Set<String> st=new HashSet<>();
        Queue<String>  q=new LinkedList<>();
        ans=new ArrayList<>();
        int length=wordList.length;
        for (int i=0;i<length;i++){
            st.add(wordList[i]);
        }
        b=beginWord;
        q.add(beginWord);
        mpp=new HashMap<>();
        mpp.put(beginWord,1);
        int size=beginWord.length();
        st.remove(beginWord);

        while (!q.isEmpty()){
            String word=q.peek();
            int steps=mpp.get(word);
            q.remove();
            if(word.equals(endWord))break;
            for (int i=0;i<size;i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mpp.put(replacedWord,steps+1);
                    }
                }
            }
        }
        if(mpp.containsKey(endWord)){
            List<String> seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
    private void dfs(String word,List<String> seq){
        if (word.equals(b)){
            List<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps=mpp.get(word);
        for (int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] replacedArray=word.toCharArray();
                replacedArray[i]=ch;
                String replacedWord=new String(replacedArray);
                if (mpp.containsKey(replacedWord) && mpp.get(replacedWord)+1==steps){
                    seq.add(replacedWord);
                    dfs(replacedWord,seq);
                    seq.removeLast();
                }
            }
        }
    }
}
/*

 */
