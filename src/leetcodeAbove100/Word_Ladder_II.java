package leetcodeAbove100;

import java.util.*;
//126. Word Ladder II  
//Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the word list
//For example,
//
//Given:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//Return
//  [
//    ["hit","hot","dot","dog","cog"],
//    ["hit","hot","lot","log","cog"]
//  ]

public class Word_Ladder_II {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        // Start typing your Java solution below
        // DO NOT write main() function              
        
        HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();
        
        wordList.add(beginWord);
        wordList.add(endWord);
        
        // init adjacent graph        
        for(String str : wordList){
            calcNeighbours(neighbours, str, wordList);
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        // BFS search queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(null, beginWord, 1));
        
        // BFS level
        int previousLevel = 0;
        
        // mark which nodes have been visited, to break infinite loop
        HashMap<String, Integer> visited = new HashMap<String, Integer>(); 
        while(!queue.isEmpty()){
            Node n = queue.pollFirst();            
            if(endWord.equals(n.str)){ 
                // fine one path, check its length, if longer than previous path it's valid
                // otherwise all possible short path have been found, should stop
                if(previousLevel == 0 || n.level == previousLevel){
                    previousLevel = n.level;
                    findPath(n, result);                    
                }else {
                    // all path with length *previousLevel* have been found
                    break;
                }                
            }else {
                HashSet<String> set = neighbours.get(n.str);                 
                
                if(set == null || set.isEmpty()) continue;
                // This is to avoid hashset's
                // current modification exception.
                ArrayList<String> toRemove = new ArrayList<String>();
                for (String s : set) {
                    
                    // if s has been visited before at a smaller level, there is already a shorter 
                    // path from start to s thus we should ignore s so as to break infinite loop; if 
                    // on the same level, we still need to put it into queue.
                    if(visited.containsKey(s)){
                        Integer occurLevel = visited.get(s);
                        if(n.level+1 > occurLevel){
                            neighbours.get(s).remove(n.str);
                            toRemove.add(s);
                            continue;
                        }
                    }
                    visited.put(s,  n.level+1);
                    queue.add(new Node(n, s, n.level + 1));
                    if(neighbours.containsKey(s))
                        neighbours.get(s).remove(n.str);
                }
                for(String s: toRemove){
                    set.remove(s);
                }
            }
        }

        return result;
    }
    
    public void findPath(Node n, List<List<String>> result){
        List<String> path = new ArrayList<String>();
        Node p = n;
        while(p != null){
            path.add(0, p.str);
            p = p.parent; 
        }
        result.add(path);
    }

    /*
     * complexity: O(26*str.length*dict.size)=O(L*N)
     */
    void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, Set<String> dict) {
        int length = str.length();
        char [] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            
            char old = chars[i]; 
            for (char c = 'a'; c <= 'z'; c++) {

                if (c == old)  continue;
                chars[i] = c;
                String newstr = new String(chars);                
                
                if (dict.contains(newstr)) {
                    HashSet<String> set = neighbours.get(str);
                    if (set != null) {
                        set.add(newstr);
                    } else {
                        HashSet<String> newset = new HashSet<String>();
                        newset.add(newstr);
                        neighbours.put(str, newset);
                    }
                }                
            }
            chars[i] = old;
        }
    }
    
    private class Node {
        public Node parent;
        public String str;
        public int level;
        public Node(Node p, String s, int l){
            parent = p;
            str = s;
            level = l;
        }
    }
}
