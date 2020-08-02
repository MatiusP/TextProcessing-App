package by.epamtc.protsko.textprocessing.main;

import by.epamtc.protsko.textprocessing.bean.Sentence;
import by.epamtc.protsko.textprocessing.bean.Text;
import by.epamtc.protsko.textprocessing.bean.Word;
import by.epamtc.protsko.textprocessing.service.ServiceFactory;
import by.epamtc.protsko.textprocessing.service.TextService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        Text sourceText = textService.getSourceText();


        List<Sentence> sentencesWithSameWords = textService.getSentencesWithSameWords(sourceText);
        for (Sentence sentencesWithSameWord : sentencesWithSameWords) {
            System.out.println(sentencesWithSameWord);
        }


        List<Word> wordsOfGivenLengthInInterrogativeSentence =
                textService.getWordsOfGivenLengthInInterrogativeSentence(sourceText, 4);
        for (Word word : wordsOfGivenLengthInInterrogativeSentence) {
            System.out.print(word);
        }


        List<Sentence> sortedSentencesByCountOfWords = textService.getSortedSentencesByCountOfWords(sourceText);
        for (Sentence sortedSentencesByCountOfWord : sortedSentencesByCountOfWords) {
            System.out.println(sortedSentencesByCountOfWord);
        }


    }
}
