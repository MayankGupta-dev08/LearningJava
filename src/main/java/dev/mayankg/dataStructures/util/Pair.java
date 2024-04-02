package dev.mayankg.dataStructures.util;

public class Pair<U, V> {
    private U _1;
    private V _2;

    public Pair(U _1, V _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public U get_1() {
        return _1;
    }

    public void set_1(U _1) {
        this._1 = _1;
    }

    public V get_2() {
        return _2;
    }

    public void set_2(V _2) {
        this._2 = _2;
    }
}