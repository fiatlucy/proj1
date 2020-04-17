package enigma;

import java.util.HashMap;
import java.util.Collection;

import static enigma.EnigmaException.*;

/** Class that represents a complete enigma machine.
 *  @author
 */
class Machine {

    /** A new Enigma machine with alphabet ALPHA, 1 < NUMROTORS rotor slots,
     *  and 0 <= PAWLS < NUMROTORS pawls.  ALLROTORS contains all the
     *  available rotors. */
    Machine(Alphabet alpha, int numRotors, int pawls,
            Collection<Rotor> allRotors) {
        _alphabet = alpha;
        // FIXME
        _numRotors = numRotors;
        _pawls = pawls;
        _allRotors = allRotors;
        _myRotors = new Rotor[numRotors + 1];

    }

    /** Return the number of rotor slots I have. */
    int numRotors() {
        return _numRotors;
//        return 0; // FIXME
    }

    /** Return the number pawls (and thus rotating rotors) I have. */
    int numPawls() {
        return _pawls; // FIXME
    }

    /** Set my rotor slots to the rotors named ROTORS from my set of
     *  available rotors (ROTORS[0] names the reflector).
     *  Initially, all rotors are set at their 0 setting. */
    void insertRotors(String[] rotors) {
//        ?! does collection rotors in construtor include reflector
        for (int i = 0; i < rotors.length; i++){
            for (Rotor r : _allRotors) {
                if (r.name() == rotors[i]){
                    _myRotors[i] = r;
                }
            }
        }
        _myRotors[rotors.length] = new MovingRotor("Ghost", _myRotors[0].permutation(), "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    /** Set my rotors according to SETTING, which must be a string of
     *  numRotors()-1 characters in my alphabet. The first letter refers
     *  to the leftmost rotor setting (not counting the reflector).  */
    void setRotors(String setting) {
        // FIXME
        for (int i = 0; i < setting.length(); i ++){
            _myRotors[i+1].set(_alphabet.toInt(setting.charAt(i)));
        }

    }

    /** Set the plugboard to PLUGBOARD. */
    void setPlugboard(Permutation plugboard) {
        // FIXME
        new Permutation(String cycles, Alphabet alphabet);

    }

    /** Returns the result of converting the input character C (as an
     *  index in the range 0..alphabet size - 1), after first advancing

     *  the machine. */
    int convert(int c) {
        for (int i = 1; i < _numRotors; i++){
            if (_myRotors[i + 1].atNotch() ){

            }
            _myRotors[i].advance();
        }
        return 0; // FIXME
    }

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        return ""; // FIXME
    }

    Rotor getRotor(int i){
        return _myRotors[i];
    }

    /** Common alphabet of my rotors. */
    private final Alphabet _alphabet;

    // FIXME: ADDITIONAL FIELDS HERE, IF NEEDED.
    private int _numRotors;
    private int _pawls;
    private Rotor[] _myRotors;
    private Collection<Rotor> _allRotors;

}
