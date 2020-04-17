//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package enigma;

import java.util.ArrayList;

class MovingRotor extends Rotor {
    private ArrayList<Character> _notches = new ArrayList();

    MovingRotor(String name, Permutation perm, String notches) {
        super(name, perm);

        for(int i = 0; i < notches.length(); ++i) {
            this._notches.add(notches.charAt(i));
        }

    }

    boolean atNotch() {
        return this._notches.contains(this.alphabet().toChar(this._setting));
    }

    boolean rotates() {
        return true;
    }

    void advance() {
        System.out.println("is here");
        if (this.alphabet().size() == this.setting() - 1) {
            this._setting = 0;
        } else {
            ++this._setting;
        }

    }
}