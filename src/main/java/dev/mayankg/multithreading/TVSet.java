package dev.mayankg.multithreading;

//Singleton Design Problem
public class TVSet {
    private static volatile TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("TV Set Instantiated");
    }

    public static TVSet getTvSetInstance() {
        if (tvSetInstance == null) {    //optimisation
            synchronized (TVSet.class) {    //thread safe
                if (tvSetInstance == null)  //double check
                    tvSetInstance = new TVSet();
            }
        }
        //heavy work is done above
        return tvSetInstance;
    }
}