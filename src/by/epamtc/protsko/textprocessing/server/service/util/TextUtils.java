package by.epamtc.protsko.textprocessing.server.service.util;

import by.epamtc.protsko.textprocessing.common.bean.*;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {
    private static final TextUtils instance = new TextUtils();

    private TextUtils() {
    }

    public static TextUtils getInstance() {
        return instance;
    }


    public List<DataComponent> getDataComponents(Text text) {
        return text.getData();
    }

    public List<TextBlock> getTextBlocks(Text text) {
        List<TextBlock> textBlocks = new ArrayList<>();

        List<DataComponent> dataComponents = getDataComponents(text);
        for (DataComponent dataComponent : dataComponents) {
            if (dataComponent.getType() == TextComponentTypes.TEXT_BLOCK) {
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
            if (sentenceComponent.getType() == TextComponentTypes.WORD) {
                sentenceWords.add((Word) sentenceComponent);
            }
        }
        return sentenceWords;
    }

    public List<PunctuationMark> getSentencePunctuationMarks(Sentence sentence) {
        List<PunctuationMark> sentencePunctuationMarks = new ArrayList<>();

        List<SentenceComponent> sentenceComponents = sentence.getSentenceComponents();
        for (SentenceComponent sentenceComponent : sentenceComponents) {
            if (sentenceComponent.getType() == TextComponentTypes.PUNCTUATION_MARK) {
                sentencePunctuationMarks.add((PunctuationMark) sentenceComponent);
            }
        }
        return sentencePunctuationMarks;
    }
}
