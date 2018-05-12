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
public class Neuron {
    private double treshold;
    private double weigth;
    private double input;
    private List<Neuron> net;

    public void calculateNetInput(){
        input=0;
        net.forEach(neuron->{
//            System.out.println(neuron.getWeigth());
            input+= neuron.getInput()*neuron.getWeigth();
        });
//        System.out.println(input);
    }
    
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
    
    public int getOutput(){
        if((input*weigth)>=treshold){
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

    public List<Neuron> getNet() {
        if(net==null)
            net = new ArrayList<>();
        return net;
    }

    public void setNet(List<Neuron> net) {
        this.net = net;
    }
}
