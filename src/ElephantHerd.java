public class ElephantHerd {
    private List<Elephant> list ;

    public ElephantHerd(){
        list = new LinkedList<>(); //Only changed this line
    }

    public boolean add(Elephant ellie){
        return list.add(ellie); //add function already returns true or false
    }

    public Elephant find(String name){
        for (int i=0; i<list.size();i++){
            if (list.get(i).getName().contains(name)){
                return list.get(i);
            }
        }
        return null;
    }

    public Elephant remove(int index){
        if (index>=list.size()){return null;}
        else{return list.remove(index);}

    }

    public void sort(){
        int i, j;
        Elephant n;

        for (i = 1; i < list.size(); i++) {
            n = list.get(i);
            for (j = i-1; j >= 0 && (n.getHeight()>list.get(j).getHeight()); j--) {
                list.set(j+1,list.get(j));
                list.set(j,n);
            }
        }

    }

    public String toString(){ //Added for debugging purposes
        String result="";
        for (int i = 0; i < list.size(); i++){
            result+=list.get(i)+"\n";
        }
        return result;
    }

    public Elephant[] getTopKLargestElephants(int k){
        if (list.size()==0){return null;}
        if (k<list.size()){k=list.size();} //k cant eb bigger than total nb of elephants
        Elephant[] initialResult = makeSortedCopy(); //Copying the contents of the herd
        Elephant[] result = new Elephant[k-1];
        for (int i=0;i<k-1;i++){ //final result only contains K elements of the copy
            result[i]=initialResult[i];
        }
        return result;
    }

    public Elephant get(int index){ //getter function for herd
        if (index>list.size()){return null;}
        else{ return list.get(index);}
    }

    public Elephant[] makeSortedCopy(){
        ElephantHerd result0 = new ElephantHerd();
        Elephant[] finalResult = new Elephant[list.size()];
        for (int i=0; i<list.size();i++){ //creating a copy of the herd instance
            result0.add(list.get(i));
        }
        result0.sort(); //Elephants sorted by height
        for (int i=0; i<list.size();i++){ //"converting" the herd instance into an elephants array
            finalResult[i]=result0.get(i);
        }
        return finalResult;
    }


    public int getSize(){ //return size of heard
        return list.size();
    }

}


// Ali Meddeb x500:medde001