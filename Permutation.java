package enigma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Permutation {
    private Alphabet _alphabet;
    private ArrayList<Permutation.CircularArray<Character>> _cycles;
    private HashMap<Integer, Character> _az;

    Permutation(String cycles, Alphabet alphabet) {
        this._alphabet = alphabet;
        this._az = new HashMap();

        int start;
        for(start = 0; start < alphabet.size(); ++start) {
            this._az.put(start, alphabet.toChar(start));
        }

        System.out.println("cycles");
        System.out.println(cycles);
        this._cycles = new ArrayList();
        start = 0;

        for(int i = 0; i < cycles.length(); ++i) {
            String now = Character.toString(cycles.charAt(i));
            if (now.equals("(")) {
                start = i + 1;
            } else if (now.equals(")")) {
                this.addCycle(cycles.substring(start, i));
            }

            this.removeaz(cycles.charAt(i));
        }

        Map<Integer, Character> map = this._az;
        Iterator var8 = map.values().iterator();

        while(var8.hasNext()) {
            Character value = (Character)var8.next();
            this.addCycle(Character.toString(value));
        }

        this._az.clear();
        System.out.println("az");
        System.out.println(this._az);
    }

    private void addCycle(String cycle) {
        Permutation.CircularArray<Character> yo = new Permutation.CircularArray();

        for(int i = 0; i < cycle.length(); ++i) {
            yo.add(cycle.charAt(i));
        }

        this._cycles.add(yo);
    }

    private void removeaz(int c) {
        this._az.remove(c);
    }

    final int wrap(int p) {
        int r = p % this.size();
        if (r < 0) {
            r += this.size();
        }

        return r;
    }

    int size() {
        return this._alphabet.size();
    }

    int permute(int p) {
        int permu = this.wrap(p);
        System.out.println("permute");
        Character next = this._alphabet.toChar(permu);

        for (int i = 0; i < this._cycles.size(); ++i) {
            for(int j = 0; j < ((Permutation.CircularArray)this._cycles.get(i)).size(); ++j) {
                System.out.println("permute2");
                System.out.println(this._cycles.get(i));
                if (((Permutation.CircularArray)this._cycles.get(i)).contains(next)) {
                    System.out.println("permute3");
                    int idx = ((Permutation.CircularArray)this._cycles.get(i)).indexOf(next);
                    char pe = (Character)((Permutation.CircularArray)this._cycles.get(i)).get(idx + 1);
                    System.out.println(idx);
                    System.out.println(this._alphabet.toInt(pe));
                    return this._alphabet.toInt(pe);
                }
            }
        }

        return permu;
    }

    int invert(int c) {
        int permu = this.wrap(c);
        System.out.println("invert");
        System.out.println(this._alphabet.toChar(permu));
        Character next = this._alphabet.toChar(permu);

        for (int i = 0; i < this._cycles.size(); ++i) {
            for(int j = 0; j < ((Permutation.CircularArray)this._cycles.get(i)).size(); ++j) {
                if (((Permutation.CircularArray)this._cycles.get(i)).contains(next)) {
                    int idx = ((Permutation.CircularArray)this._cycles.get(i)).indexOf(next);
                    char pe = (Character)((Permutation.CircularArray)this._cycles.get(i)).get(idx - 1);
                    return this._alphabet.toInt(pe);
                }
            }
        }
        return permu;
    }
    /** Testing time limit. */
    char permute(char p) {
        return p;
    }
    /** Testing time limit. */
    char invert(char c) {
        int next = this._alphabet.toInt(c);
        int save = this.invert(next);
        return this._alphabet.toChar(save);
    }
    /** Testing time limit. */
    Alphabet alphabet() {
        return this._alphabet;
    }
    /** Testing time limit. */
    boolean derangement() {
        for(int i = 0; i < this._cycles.size(); ++i) {
            if (((Permutation.CircularArray)this._cycles.get(i)).size() == 1) {
                return false;
            }
        }
        return true;
    }

    /** Testing time limit. */
    public class CircularArray<E> extends ArrayList<E> {
        public CircularArray() {
        }
        /** Testing time limit. */
        public E get(int index) {
            return index < 0 ? super.get(this.size() + index)
                    : super.get(index % this.size());
        }
    }
}