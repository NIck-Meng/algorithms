package Link;


import Standardlibraries.StdIn;
import Standardlibraries.StdOut;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> doubles = new Bag<Double>();
        while(!StdIn.isEmpty()){
            Double intput=StdIn.readDouble();
            doubles.add(intput);
        }
        int N=doubles.size();

        double sum=0.0;
        for (Double x : doubles) {
            sum+=x;
        }
        double mean=sum/N;

        sum=0.0;
        for (Double x : doubles) {
            sum+=(x-mean)*(x-mean);
        }
        double std=Math.sqrt(sum/(N-1));
        StdOut.printf("Mean:",mean);
        StdOut.printf("Std dev is:",std);
    }
}
