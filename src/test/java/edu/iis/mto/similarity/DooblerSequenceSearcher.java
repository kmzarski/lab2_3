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

    @Override
    public SearchResult search(int key, int[] seq) {
        SearchResult.Builder builder = SearchResult.builder();
        seqInMemory = seq;

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == key) {
                counter++;
                return builder.withFound(true).withPosition(i).build();
            }
        }

        return builder.withFound(false).build();
    }
}
