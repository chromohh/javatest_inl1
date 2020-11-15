package org.example;

public class IIntArrayImp implements IIntArray {

    private int[] intArr;

    public IIntArrayImp(int[] intArr) {
        this.intArr = intArr;
    }

    public int[] getIntArr() {
        return intArr;
    }

    @Override
    public double getAverage() {
        try{
            int length = intArr.length;
            int sum = 0;
            for (int value : intArr) {
                sum = sum + value;
            }
            return (double) sum / length;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public int[] findPositions(int val) {
        try {
            int newArrLength = 0;

            for (int value : intArr) {
                if (value == val) {
                    newArrLength++;
                }
            }

            int[] returnArr = new int[newArrLength];

            int currentIndex = 0;
            int currentReturnIndex = 0;
            for (int value : intArr) {
                if (value == val) {
                    returnArr[currentReturnIndex] = currentIndex;
                    currentReturnIndex++;
                }
                currentIndex++;
            }

            return returnArr;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void appendLast(int value) {
        try {
            int[] mutatedArr = new int[intArr.length + 1];

            int currentIndex = 0;
            for (int currentVal : intArr) {
                mutatedArr[currentIndex] = currentVal;
                currentIndex++;
            }
            mutatedArr[intArr.length] = value;
            intArr = mutatedArr;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void insertAt(int pos, int value) {
        try {
            int[] mutatedArr = new int[intArr.length + 1];

            int currentIndex = 0;
            int currentMutatedIndex = 0;
            for (int val : mutatedArr) {
                if(currentMutatedIndex == pos){
                    mutatedArr[currentMutatedIndex] = value;
                }else{
                    mutatedArr[currentMutatedIndex] = intArr[currentIndex];
                    currentIndex++;
                }
                currentMutatedIndex++;
            }
            for(int currentVal : mutatedArr){
                System.out.println(currentVal);
            }
            intArr = mutatedArr;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public int getAt(int pos) {
        try{
            return intArr[pos];
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public void setAt(int pos, int element) {
        try{
            intArr[pos] = element;
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public int deleteAt(int pos) {
        try{
            int[] mutatedArr = new int[intArr.length-1];

            int currentIndex = 0;
            int mutatedIndex = 0;
            int returnVal = 0;

            for(int element : intArr){
                if(currentIndex == pos){
                    returnVal = element;
                }else{
                    mutatedArr[mutatedIndex] = element;
                    mutatedIndex++;
                }
                currentIndex++;
            }
            intArr = mutatedArr;
            return returnVal;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }
}
