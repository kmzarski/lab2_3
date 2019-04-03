package edu.iis.mto.similarity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SimilarityFinderTest {

    private final double E = 0.0000001;

    private void testHelperForJackadSImilarity(int[] seq1, int[] seq2, double value) {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(Math.abs(jackardSimilarity - value) < E, is(true));
    }

    @Test
    public void testForTwoEmptyArray() {
        testHelperForJackadSImilarity(new int[] {}, new int[] {}, 1);
    }

    @Test
    public void testForTwoDiffrentOneElementArray() {
        DooblerSequenceSearcher.toReturn.push(false);
        testHelperForJackadSImilarity(new int[] {1}, new int[] {2}, 0);
    }

    @Test
    public void testForTwoTheSameArray() {
        DooblerSequenceSearcher.toReturn.push(true);
        int seq[] = new int[] {1, 2, 3, 4};
        for (int i = 0; i <= seq.length; i++) {
            DooblerSequenceSearcher.toReturn.push(true);
        }
        testHelperForJackadSImilarity(seq, seq, 1);
    }
    @Test
    
}
