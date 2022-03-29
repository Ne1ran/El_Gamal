package com.company;

import java.math.BigInteger;
import java.util.Random;

public class elGamalCoder {
    static int Cb, k, d, r, e, statP;
    static boolean isSimple(double i){
        for (int j = 2; j < Math.sqrt(i); j++){
            if (i % j == 0){
                return false;
            }
        }
        return true;
    }
    static int[] inCoder(int p, int g, int m){
        statP = p;
        Random random = new Random();
        k = random.nextInt(p - 1);
        while (!isSimple(k) || k < 3 || k == 4){
            k = random.nextInt(p - 1);
        }
        Cb = random.nextInt(p - 1);
        while (!isSimple(Cb) || Cb < 3 || Cb == 4){
            Cb = random.nextInt(p - 1);
        }
        BigInteger big = new BigInteger(Integer.toString(g));
        for (int i = 1; i < k;i++){
            big = big.multiply(new BigInteger(Integer.toString(g)));
        }
        BigInteger modP = new BigInteger(Integer.toString(p));
        r = big.mod(modP).intValue();
        big = new BigInteger(Integer.toString(g));
        for (int i = 1; i < Cb;i++){
            big = big.multiply(new BigInteger(Integer.toString(g)));
        }
        d = big.mod(modP).intValue();
        big = new BigInteger(Integer.toString(d));
        for (int i = 1; i < k;i++){
            big = big.multiply(new BigInteger(Integer.toString(d)));
        }
        BigInteger message = new BigInteger(Integer.toString(m));
        big = big.multiply(message);
        e = big.mod(modP).intValue();
        return new int[]{e, r};
    }

    static int deCoder (int e, int r){
        if (statP == 0){
            System.out.println("Вы еще не кодировали");
            return 0;
        }
        BigInteger modP = new BigInteger(Integer.toString(statP));
        BigInteger big = new BigInteger(Integer.toString(r));
        for (int i = 1; i < (statP - 1 - Cb); i++){
            big = big.multiply(new BigInteger(Integer.toString(r)));
        }
        BigInteger eBig = new BigInteger(Integer.toString(e));
        big = big.multiply(eBig);
        return big.mod(modP).intValue();
    }
}