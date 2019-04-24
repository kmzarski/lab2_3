package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DooblerSequenceSearcher implements SequenceSearcher {

    private int counter = 0;
    private int[] seqInMemory;

    public int getCounter() {
        return counter;
    }

    public int[] getSeqInMemory() {
        return seqInMemory;
    }

    @Override
    public SearchResult search(int key, int[] seq) {
        counter++;
        seqInMemory = seq;
        return SearchResult.builder().withFound(true).build();
    }
}
