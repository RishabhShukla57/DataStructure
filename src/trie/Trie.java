package trie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Trie {
	TrieNode root;
	
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insertTrie(String word){
		TrieNode  trieNode  = root;
		
		for(int i=0;i<word.length();i++){
			char letter = word.charAt(i);
			int index = letter-'a';
			if(trieNode.trieNodeArr[index]==null){
				TrieNode  trie = new TrieNode();
				trieNode.trieNodeArr[index] = trie;
				trieNode = trie;
			}else{
				trieNode = trieNode.trieNodeArr[index]; 
			}
			
		}
		trieNode.isLeaf = true;
	}
	
	public boolean searchTrie(String word){
		TrieNode trieNode = root;
		for(int i=0;i<word.length();i++){
			char letter = word.charAt(i);
			int index = letter-'a';
			if(trieNode.trieNodeArr[index]!=null){
				trieNode = trieNode.trieNodeArr[index];
			}else{
				return false;
			}
		}
		if(trieNode==root){
			return false;
		}
		if(trieNode.isLeaf){
			return true;
		}
		return false;
	}
	
	void trieOperation(String fileName,TrieOperation trieOperation){
		BufferedReader  bufferedReader;
		String sCurrentLine;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				if(trieOperation==TrieOperation.INSERTTRIE){
					insertTrie(sCurrentLine);
				}else if(trieOperation==TrieOperation.SEARCHTRIE){
					System.out.println("Words Searched :"+sCurrentLine+" is :"+searchTrie(sCurrentLine));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String [] args){
		Trie trie = new Trie();
		ResourceBundle  resource;
		resource = ResourceBundle.getBundle("trie.TrieProperty");
		trie.trieOperation(resource.getString("PathOfInsertionWordsInTrie"),TrieOperation.INSERTTRIE);
		trie.trieOperation(resource.getString("PathOfSearchedWordsInTrie"), TrieOperation.SEARCHTRIE);
	}
	
	
	
}


class TrieNode{
	TrieNode trieNodeArr[];
	boolean isLeaf;
	public TrieNode() {
		trieNodeArr = new TrieNode[26];
	}
}



