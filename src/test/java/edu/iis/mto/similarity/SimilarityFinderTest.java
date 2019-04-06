package edu.iis.mto.similarity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SimilarityFinderTest {

    @Test
    public void testForTwoEmptyArray() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        double value = similarityFinder.calculateJackardSimilarity(new int[]{}, new int[]{});
        assertThat(value, is(1.0));
    }

    @Test
    public void testForTwoDiffrentOneElementArray() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        double value = similarityFinder.calculateJackardSimilarity(new int[]{1}, new int[]{2});
        assertThat(value, is(0.0));
    }

    @Test
    public void testForTwoTheSameArray() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        int seq[] = new int[]{1, 2, 3, 4};
        double value = similarityFinder.calculateJackardSimilarity(seq, seq);
        assertThat(value, is(1.0));
    }
}
