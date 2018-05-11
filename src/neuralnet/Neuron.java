/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

/**
 *
 * @author Victor Tassinari
 */
public class Neuron {
    private double treshold;
    private double weigth;
    private double input;

    public double getTreshold() {
        return treshold;
    }

    public void setTreshold(double treshold) {
        this.treshold = treshold;
    }
    
    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public double getOutput() {
        return input*weigth;
    }

    public int bitOutput(){
        if(getOutput()>=treshold){
            return 1;
        }else{
            return 0;
        }
    }
    
    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
    }
}
