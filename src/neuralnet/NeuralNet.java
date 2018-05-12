/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Tassinari
 */
public class NeuralNet {

    static final double LINEARLEARNING = 0.1;
    static Neuron n1, n2, root;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<int[]> trainingData = new ArrayList<>();
        trainingData.add(new int[]{0,0});
        trainingData.add(new int[]{0,1});
        trainingData.add(new int[]{1,0});
        trainingData.add(new int[]{1,1});
        n1 = new Neuron();
        n1.setWeigth(1);
        n2 = new Neuron();
        n2.setWeigth(-1);
        root = new Neuron();
        root.setTreshold(0.4);
        root.setWeigth(1);
        root.getNet().add(n1);
        root.getNet().add(n2);
//        System.out.println(root.getNet().size());
        andTraining();
        orTraining();
        
    }

    private static void andTraining() {
        double error;
        int count=0;
        System.out.println("---And train---");
        do {
            System.out.println("N1 weigth: " + n1.getWeigth() + "\nN2 weigth: " + n2.getWeigth());
            error = 0;
            n1.setInput(0);
            n2.setInput(0);
            root.calculateNetInput();
            System.out.println("0/0/" + root.getOutput());
            if (root.getOutput() == 1) {
                error++;
//                System.out.println("output "+root.getOutput()+"\nlearn rate "+LINEARLEARNING+"\nn1 weight "+n1.getWeigth());
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 0));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 0));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
            n1.setInput(1);
            n2.setInput(0);
            root.calculateNetInput();
            System.out.println("1/0/" + root.getOutput());
            if (root.getOutput() == 1) {
                error++;
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 1));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 0));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
            n1.setInput(0);
            n2.setInput(1);
            root.calculateNetInput();
            System.out.println("0/1/" + root.getOutput());
            if (root.getOutput() == 1) {
                error++;
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 0));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 1));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
            n1.setInput(1);
            n2.setInput(1);
            root.calculateNetInput();
            System.out.println("1/1/" + root.getOutput());
            if (root.getOutput() == 0) {
                error++;
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 1));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 1));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
//            System.out.println(error);
            count++;
        } while (error != 0);
        System.out.println("Number of tries: "+count);
    }

    private static void orTraining() {
        double error;
        int count=0;
        System.out.println("---Or train---");
        do {
            System.out.println("N1 weigth: " + n1.getWeigth() + "\nN2 weigth: " + n2.getWeigth());
            error = 0;
            n1.setInput(0);
            n2.setInput(0);
            root.calculateNetInput();
            System.out.println("0/0/" + root.getOutput());
            if (root.getOutput() == 1) {
                error++;
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 0));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (0 - root.getOutput()) * 0));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
            n1.setInput(1);
            n2.setInput(0);
            root.calculateNetInput();
            System.out.println("1/0/" + root.getOutput());
            if (root.getOutput() == 0) {
                error++;
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 1));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 0));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
            n1.setInput(0);
            n2.setInput(1);
            root.calculateNetInput();
            System.out.println("0/1/" + root.getOutput());
            if (root.getOutput() == 0) {
                error++;
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 0));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 1));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
            n1.setInput(1);
            n2.setInput(1);
            root.calculateNetInput();
            System.out.println("1/1/" + root.getOutput());
            if (root.getOutput() == 0) {
                error++;
                n1.setWeigth(n1.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 1));
                n2.setWeigth(n2.getWeigth() + (LINEARLEARNING * (1 - root.getOutput()) * 1));
//                System.out.println("N1 weigth: "+n1.getWeigth()+"\nN2 weigth: "+n2.getWeigth());
            }
//            System.out.println(error);
            count++;
        } while (error != 0);
        System.out.println("Number of tries: "+count);
    }
}
