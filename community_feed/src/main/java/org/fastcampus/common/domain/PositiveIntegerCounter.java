package org.fastcampus.common.domain;

public class PositiveIntegerCounter {

    private int count;

    public PositiveIntegerCounter() {
        this.count = 0;
    }

    public void increase(){
        this.count++;
    }

    public void decreases(){
        if(count <= 0) {
            return;
        }
        this.count--;
    }

    public int getCount() {
        return count;
    }
}
