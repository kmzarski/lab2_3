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

    @Test
    public void testCheckingIfSequanceIsChangingAfterCalculated() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        int seq1[] = new int[]{1, 2, 3, 4};
        int copySeq[] = seq1.clone();
        double value = similarityFinder.calculateJackardSimilarity(seq1, seq1);
        assertThat(seq1, is(copySeq));
    }

    @Test
    public void testCheckingIfSequanceIsUsingInCalculatedWithoutChanges() {
        DooblerSequenceSearcher dooblerSequenceSearcher = new DooblerSequenceSearcher();
        SimilarityFinder similarityFinder = new SimilarityFinder(dooblerSequenceSearcher);
        int seq1[] = new int[]{1, 2, 3, 4};
        double value = similarityFinder.calculateJackardSimilarity(seq1, seq1);
        assertThat(seq1, is(dooblerSequenceSearcher.getSeqInMemory()));
    }

    @Test
    public void testForCheckingSequanceSearcherCounterTimeUsedSearch() {
        DooblerSequenceSearcher dooblerSequenceSearcher = new DooblerSequenceSearcher();
        SimilarityFinder similarityFinder = new SimilarityFinder(dooblerSequenceSearcher);
        int seq1[] = new int[]{1, 2, 3, 4};
        similarityFinder.calculateJackardSimilarity(seq1, seq1);
        assertThat(4, is(dooblerSequenceSearcher.getCounter()));
    }

    @Test
    public void testForTwoDiffrenArrayWithSomeSameValueInAscendingOrder() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        int seq1[] = new int[]{1, 2, 3, 4};
        int seq2[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double value = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(value, is(0.4));
    }

    @Test
    public void testForTwoDiffrenArrayWithSomeSameValueInDescendingOrder() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        int seq1[] = new int[]{10, 9, 8, 7};
        int seq2[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double value = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(value, is(0.4));
    }

    @Test
    public void testForTwoDiffrenArrayWithSomeSameValueInRandomOrder() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new DooblerSequenceSearcher());
        int seq1[] = new int[]{5, 9, 7, 4};
        int seq2[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double value = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(value, is(0.4));
    }
}
