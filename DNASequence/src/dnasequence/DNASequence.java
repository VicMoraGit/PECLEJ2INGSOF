package dnasequence;


/**
 * Represents a DNA sequence.
 */
public class DNASequence {

    public final static char ADENINE = 'A';
    public final static char CYTOSINE = 'C';
    public final static char THYMINE = 'T';
    public final static char GUANINE = 'G';
    private final String _seq;

    /**
     * Constructs the sequence from a String. Nucleotides can be expressed
     * lowercase or uppercase.
     *
     * @param seq A non-null String with the nucleotide sequence.
     */
    public DNASequence(String seq) {
        assert (seq != null);
        _seq = seq.toUpperCase();
    }
    //

    /**
     * Format check.
     *
     * @return true if the object contains a valid DNA sequence
     */
    public boolean isValid() {
        for (int i = 0; i < _seq.length(); i++) {
            if ("ACTG".indexOf(_seq.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Counts the occurrences of a valid nucleotide in the sequence.
     *
     *
     * @param nucleotide A valid nucleotide as DNASequence.ADENINE
     * @return The number of ocurrences of nucleotide in the sequence.
     *
     */
    public int count(char nucleotide) {
        int aux = 0;
        for (int i = 0; i < _seq.length(); i++) {
            if (_seq.charAt(i) == nucleotide) {
                aux++;
            }
        }
        return aux;
    }
}
