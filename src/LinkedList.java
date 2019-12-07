public class LinkedList<T extends Comparable<T>> implements List<T> {

    //Please double check that everything is up to standards(check the project prompt)
    //If you have a question text on discord
    //I left you all the fun(Hard) methods to do. If you can't do them then it's fine



    //Instances Variables
    private Node head; //Parameter set to the start of the list
    private Node tail=null; //Parameter set to the end of the list
    private boolean isSorted = false;
    private int size=0; //keeps track of list size

    //Constructor
    public LinkedList(){
        head=null;
        isSorted = true;
    }

    //Methods

    @Override
    public boolean add(T element) {
        if (element == null) {return false;}

        if (head==null) { //No elements in the list
            head=new Node((element));
            size++;
            return true;
        }
        if (tail==null){    //1 element is in the list
            tail=new Node((element));
            head.setNext(tail);
            isSorted=false;
            size++;
            return true;
        }
        else{  //More than 2 elements in the list
            Node temporary=tail;
            tail=new Node(element);
            temporary.setNext(tail);
            isSorted=false;
            size++;
            return true;
        }

    }

    @Override
    //Done
    public boolean add(int index, T element) {
        //element null or index out of bounds
        if ((element == null)||(index<0)||(index>size)) {return false;}

        if (index==size){ //Element added at end of list, add(element) used.
            add(element);
            isSorted=false;
            size++;
            return true;
        }

        else{
            Node newNode=new Node(element,getNode(index)); //New node has current index node as its next
            getNode(index-1).setNext(newNode);//previous node gets new Node as its next
            size++;
            isSorted=false;
            return true;
        }
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
        isSorted = true;

    }

    @Override
    //DONE
    public boolean contains(T element) {
        int index=0;
        Node startingNode=head;
        if (isSorted){ //Increased efficiency

            // Element bigger than biggest element in list
            if (element.compareTo((T)tail.getData())>0){return false;}
            // Element smaller than smallest element in list
            if (element.compareTo((T)head.getData())<0){return false;}
            // Element bigger than middle element in list: only search second half
            if(element.compareTo((T)getNode(size/2).getData())>0){
                startingNode=getNode(size/2);
                index=size/2;
            }
        }
        //Searching for element
        for (int i=index;i<size;i++){
                if (startingNode.getData()==element) {return true;}
                startingNode=startingNode.getNext();
            }
            return false;
        }


    @Override
    //DONE
    public T get(int index) {
        if ((index<0)||(index>=size)) {return null;}

        Node currNode=head;
        T result= (T) currNode.getData();
        for (int i=0;i<index;i++){
            currNode=currNode.getNext();
            result=(T) currNode.getData();
        }
        return result;
    }

    @Override
    //need to add Sorted version
    public int indexOf(T element) {
        if ((element==null)) {return -1;}
        if (isSorted){
            // Element too big or too small compared to max/min
            if (element.compareTo((T)tail.getData())>0){return -1;}
            if (element.compareTo((T)head.getData())<0){return -1;}
        }
        Node currNode=head;
        for (int index=0;index<size;index++){
            if (currNode.getData()==element) {return index;}
            currNode=currNode.getNext();
        }
        return -1; //element not in list
    }

    @Override
    //DONE
    public boolean isEmpty() {
        if (size==0){return true;}
        return false;
    }

    @Override
    //DONE
    public int lastIndexOf(T element) {
        if (isSorted){
            // Element too big or too small compared to max/min
            if (element.compareTo((T)tail.getData())>0){return -1;}
            if (element.compareTo((T)head.getData())<0){return -1;}
        }

        int answer = -1;
        Node currentNode = head;
        if (!this.isSorted) {
            for(int i = 0; i < size; ++i) {
                if (element.equals(currentNode.getData())) {
                    answer = i;
                }
                currentNode = currentNode.getNext();
            }
        }
        return answer;
    }

    @Override
    public T set(int index, T element) {
        if (element==null){return null;}
        if ((index<0)||(index>=size)){return null;}

        Node currNode=getNode(index);
        T result=(T)currNode.getData();
        getNode(index).setData(element);
        return (result);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort(boolean order) {
        if (order){isSorted=true;}
        //Bubble Sort
        int i, j;
        Node currentNode = head;
        Node next = currentNode.getNext();
        T temp;
        boolean swapped = true;
            for (i = 0; i < size && swapped == true; i++) {
                swapped = false;
                for (j = 1; j < size - i; j++) {
                    if ((order && currentNode.getData().compareTo(next.getData()) > 0) //Ascending order
                       || (!order && currentNode.getData().compareTo(next.getData()) < 0)) { //or Descending
                        swapped = true;
                        temp = (T) next.getData();
                        next.setData(currentNode.getData());
                        currentNode.setData(temp);
                    }
                    currentNode = currentNode.getNext();
                    next = currentNode.getNext();
                }
                currentNode = head;
                next = currentNode.getNext();
            }
    }

    @Override
    public boolean remove(T element) {
        if (element==null){return false;}
        if (indexOf(element)==-1){return false;} //element not in list
        remove(indexOf(element)); //Uses the other remove() function + indexOf()
        return true;
    }

    @Override
    //To DO
    public T remove(int index) {
        if ((index<0)||(index>=size)) {return null;} //out of bounds
        T result;
        if (index==0) { //Deleting first element in list
            result = (T) head.getData();
            head = head.getNext(); //First element skipped over
            size--;
            return result;
        }
        if (index==size-1){ //Deleting last element in list
            result = (T) tail.getData();
            tail = getNode(size-2); //Last element de-linked
            size--;
            return result;
        }
        result=(T)getNode(index).getData();
        Node previousNode=getNode(index-1);
        previousNode.setNext(getNode(index+1)); //link skips over node at index
        size--;
        return result;
    }

    @Override
    //Added this for test purposes
    public String toString() {
        String result="";
        Node currNode=head;
        for (int i=0;i<size;i++){
            result+=currNode.getData() + "\n";
            currNode=currNode.getNext();
        }
        return result;

    }

    private Node getNode(int index){ //returns node at index
        if ((index<0)||(index>=size)) {return null;}
        Node result=head;
        for (int i=0;i<index;i++){
            result=result.getNext();
        }
        return result;
    }
}


// Ali Meddeb x500:medde001