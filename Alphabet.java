package enigma;

/** An alphabet of encodable characters.  Provides a mapping from characters
 *  to and from indices into the alphabet.
 *  @author
 */
class Alphabet {

    /** A new alphabet containing CHARS.  Character number #k has index
     *  K (numbering from 0). No character may be duplicated. */
    Alphabet(String chars) {
        // FIXME
        _alphabet = new Character[chars.length()];
        for (int i = 0; i < chars.length(); i++){
            _alphabet[i] = chars.charAt(i);
        }

    }

    /** A default alphabet of all upper-case characters. */
    Alphabet() {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    /** Returns the size of the alphabet. */
    int size() {
        return _alphabet.length; // FIXME
    }

    /** Returns true if preprocess(CH) is in this alphabet. */
    boolean contains(char ch) {
        for (int i = 0; i < size() ; i++){
            if (_alphabet[i] == ch){
                return true;
            }
        }
        return false;
    }

    /** Returns character number INDEX in the alphabet, where
     *  0 <= INDEX < size(). */
    char toChar(int index) {
        return _alphabet[index];
            
//        return (char) ('A' + index); // FIXME
    }

    /** Returns the index of character preprocess(CH), which must be in
     *  the alphabet. This is the inverse of toChar(). */
    int toInt(char ch) {
        if (contains(ch)){
            for (int i = 0; i < size(); i++) {
                if (_alphabet[i] == ch) {
                    return i;
                }
            }
        }
            return -1;
//        return ch - 'A'; // FIXME
    }

    private Character[] _alphabet;

}
