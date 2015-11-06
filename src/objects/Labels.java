/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Labels {

    protected String string;
    protected String[] labels;
    protected int maxlenght;
    protected ArrayList<LabelFormat> list = new ArrayList<LabelFormat>();

    public Labels(String string) {
        this.string = string;
        
        String[] labels = this.string.trim().split(" ");
        this.labels = labels;
        getMainEffects();
        
        analyseString();
    }

    public int getSize() {
        return this.labels.length;
    }

    public String[] getMainEffects() {
        

        //get main effect
        String smaineffect = "";
        this.maxlenght = 1;
        for (String l : labels) {
            int lenght = l.length();
            if (lenght == 1) {
                //find main effects
                smaineffect += l + " ";
            } else {
                //search the highest number of values
                if (lenght > this.maxlenght) {
                    this.maxlenght = lenght;
                }
            }
        }
        String[] mainEffectLabels = smaineffect.trim().split(" ");

        return mainEffectLabels;
    }

    public int[] getLabel(int index) {
        return this.list.get(index).effectOf;
    }

    public void analyseString() {
        int maineffectCounter = 0;
        for (int i = 0; i < this.labels.length; i++) {
            String s = this.labels[i];
            
            int[] effectOf;

            if (s.length() == 1) {
                effectOf =  new int[]{maineffectCounter};
                this.list.add(new LabelFormat(maineffectCounter, s, effectOf));
                maineffectCounter++;
            } else {
                effectOf = new int[s.length()];
                
                for (int j = 0; j < s.length(); j++) {
                    int r = getPosition(String.valueOf(s.charAt(j)));
                    if (r == -1) {
                        System.err.println("Labels Not in the Correct Order");
                    }
                    effectOf[j] = r;
                }
                this.list.add(new LabelFormat(i, s, effectOf));
            }
            
        }

    }

    public int getPosition(String a) {
        for (LabelFormat lf : this.list) {
            if (lf.value.equalsIgnoreCase(a)) {
                return lf.position;
            }
        }
        return -1;
    }

}

class LabelFormat {

    int position;
    int mainEffect;
    String value;
    int[] effectOf;

    public LabelFormat(int p, String v, int[] effectOf) {
        this.position = p;
        this.value = v;
        this.effectOf = effectOf;
    }

}
