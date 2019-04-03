package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class DooblerSequenceSearcher implements SequenceSearcher {

    public static Vector<Integer> searched = new Vector<>();
    public static Stack<Boolean> toReturn = new Stack<>();
    public static int counter = 0;

    @Override
    public SearchResult search(int key, int[] seq) {
        searched.add(key);
        counter++;
        return SearchResult.builder().withFound(toReturn.pop()).build();
    }
}
