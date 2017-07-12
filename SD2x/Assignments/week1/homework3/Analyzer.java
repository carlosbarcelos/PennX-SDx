package Assignments.week1.homework3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		if(filename == null){
			return new ArrayList<Sentence>();
		}
		System.err.println("Working on file:  " + filename);
		List<Sentence> sentenceList = new ArrayList<Sentence>();
		File f = new File(filename);
		Scanner scnr; //file scanner
		Scanner scnrLine; //line scanner
		try {
			scnr = new Scanner(f);
			while(scnr.hasNextLine()){
				//get ready to parse
				String line = scnr.nextLine();
				scnrLine = new Scanner(line).useDelimiter(" ");
				//get the score and text
				try{
					int score = Integer.parseInt(scnrLine.next().trim());
					if(score < -2 || score > 2){ //valid score [-2, 2]
						continue;
					}
					String text = scnrLine.next().trim();
					while(scnrLine.hasNextLine()){
						text += " ";
						text += scnrLine.next();
					}				
					//create the sentence object and add to list
					Sentence thisSentence = new Sentence(score,text);
					sentenceList.add(thisSentence);
				} catch(NumberFormatException e){
					continue;
				} catch(NoSuchElementException e1){
					continue;
				}
			}
			scnr.close();
		} catch (FileNotFoundException e1) {
			System.err.println("File \"" + filename + "\" not found.");
			return new ArrayList<Sentence>();
		}
		return sentenceList;
	}

	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		if(sentences == null || sentences.size() == 0){
			return new HashSet<Word>();
		}

		Set<Word> returnSet = new HashSet<Word>();
		for(Sentence s : sentences){
			if(s == null){
				continue;
			}
			String[] splitString = s.text.split("\\s");
			for(String str : splitString){
				if(!str.toLowerCase().matches("^[a-z]*$")){ //ignore non-words
					continue;
				}
				Word w = new Word(str.toLowerCase());
				if(returnSet.contains(w)){ //existing word
					for(Word w1 : returnSet){
						if(w == w1){
							w = w1;
							break;
						}
					}
				} 
				w.increaseTotal(s.getScore());
				returnSet.add(w);
			}
		}
		return returnSet;

	}

	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		if(words == null || words.size() == 0){
			return new HashMap<String, Double>();
		}
		
		Map<String, Double> scores = new HashMap<String, Double>();
		for(Word w : words){
			if(w == null){
				continue;
			}
			scores.put(w.getText(), w.calculateScore());
		}
		return scores;
	}

	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		if(wordScores == null || wordScores.size() == 0||
				sentence == null || sentence.isEmpty()){
			return 0;
		}

		double totalScore = 0.0;
		int totalWords = 0;
		String[] splitString = sentence.trim().split("\\s");
		for(String str : splitString){
			String lowStr = str.toLowerCase();
			if(!lowStr.matches("^[a-z]*$")){ //ignore non-words
				System.err.println("Invalid string : " + lowStr);
				continue;
			}
			if(wordScores.containsKey(lowStr)){ //is this a valid word
				totalScore += wordScores.get(lowStr);
			}
			totalWords++;
		}
		return totalScore/(double)totalWords;
	}

	/*
	 * This method is here to help you run your program.
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
