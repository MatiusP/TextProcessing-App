package by.epamtc.protsko.textprocessing.service.component;

import by.epamtc.protsko.textprocessing.bean.*;

import java.util.ArrayList;
import java.util.List;

public class TextComponentsGetter {
    private static final TextComponentsGetter instance = new TextComponentsGetter();

    private TextComponentsGetter() {
    }

    public static TextComponentsGetter getInstance() {
        return instance;
    }


    public List<DataComponent> getDataComponents(Text text) {
        return text.getData();
    }

    public List<TextBlock> getTextBlocks(Text text) {
        List<TextBlock> textBlocks = new ArrayList<>();

        List<DataComponent> dataComponents = getDataComponents(text);
        for (DataComponent dataComponent : dataComponents) {
            if (dataComponent.getClass() == TextBlock.class) {
                textBlocks.add((TextBlock) dataComponent);
            }
        }
        return textBlocks;
    }

    public List<Sentence> getTextSentences(Text text) {
        List<Sentence> textSentences = new ArrayList<>();

        List<TextBlock> textBlocks = getTextBlocks(text);
        for (TextBlock textBlock : textBlocks) {
            textSentences.addAll(textBlock.getSentences());
        }
        return textSentences;
    }

    public List<Word> getSentenceWords(Sentence sentence) {
        List<Word> sentenceWords = new ArrayList<>();

        List<SentenceComponent> sentenceComponents = sentence.getSentenceComponents();
        for (SentenceComponent sentenceComponent : sentenceComponents) {
            if (sentenceComponent.getClass() == Word.class) {
                sentenceWords.add((Word) sentenceComponent);
            }
        }
        return sentenceWords;
    }

    public List<PunctuationMark> getSentencePunctuationMarks(Sentence sentence) {
        List<PunctuationMark> sentencePunctuationMarks = new ArrayList<>();

        List<SentenceComponent> sentenceComponents = sentence.getSentenceComponents();
        for (SentenceComponent sentenceComponent : sentenceComponents) {
            if (sentenceComponent.getClass() == PunctuationMark.class) {
                sentencePunctuationMarks.add((PunctuationMark) sentenceComponent);
            }
        }
        return sentencePunctuationMarks;
    }

}
