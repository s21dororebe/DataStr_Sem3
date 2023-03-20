package datastr;

public class MyHeap <T>{
    private T[] elements;
    private final int DEFAULT_ARRAY_SIZE = 5;
    private int arraySize = DEFAULT_ARRAY_SIZE;
    private int elementCount = 0;

    //MAIN functions
    public MyHeap()
    {
        elements = (T[]) new Object[arraySize];
    }
    public MyHeap(int inputArraySize) {
        if(inputArraySize > 0) {
            arraySize = inputArraySize;
        }
        elements = (T[]) new Object[arraySize];
    }
    public boolean isFull() {
        return (elementCount == arraySize);
    }
    public boolean isEmpty()
    {
        return (elementCount == 0);
    }
    public int howManyElements() {
        return elementCount;
    }
    private void increaseHeap() {
        int newArraySize = (arraySize > 100)? (int)(arraySize*1.5) : arraySize*2;
        T[] newElements = (T[]) new Object[newArraySize];
        //elementu kopesana
        if (arraySize >= 0) System.arraycopy(elements, 0, newElements, 0, arraySize);
        elements = newElements;
        arraySize = newArraySize;
    }

    //OTHER FUNCTIONS
    public void enqueue(T inputElement) {
        if(isFull()){
            increaseHeap();
        }
        elements[elementCount] = inputElement;
        elementCount++;
        reheapUp(elementCount-1);
    }
    public T dequeue() throws Exception {
        if(isEmpty()){
            throw (new Exception("Kaudze ir tuksa, nevar izdzest elementu"));
        }
        T maxElement = elements[0]; //root - lielaka vertiba pasa augsaa
        elements[0] = elements[elementCount-1];
        elements[elementCount-1] = null;
        elementCount--;
        reheapDown(elementCount-1);
        return maxElement;
    }

    //RECURSIVE FUNCTIONS
    //inputIndex - elementa index, kuru salidzinasu vienmer ar vecako
    private void reheapUp(int inputIndex){
        //1.noskaidrosim vecaka indeksu
        /*indeksi =>
        leftChild = 2 * parent + 1
        rightChild = 2 * parent + 2
        (leftChild-1)/2 = parent
        (rightChild-2)/2 = parent
        example
        (3-1)/2 = parent = 1
        (4-2)/2 = parent = 1
        (rightChild-1)/2 = parent
        (4-1)/2 = parent = 3/2 = 1.5 = (int)1.5 = 1*/
        int parentIndex = (int)((inputIndex - 1)/2);

        //2.vecakam jabut lielakam vai vienadadm ar 0
        if(parentIndex>=0){
        //2.1.veicam salidzinasanu
        // if(elements[inputIndex] > elements[parentIndex]){
            if(((Comparable)(elements[inputIndex])).compareTo(elements[parentIndex]) == 1){
        //2.2.ja elements ir vecaks par savu vecako, tad mainam vietam
                swap(inputIndex, parentIndex);
                reheapUp(parentIndex);
            }
        }
    }

    private void swap(int index1, int index2){
        T temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }
    private void reheapDown(int inputIndex){
        int indexRigthChild = 2 * inputIndex +2;
        int indexLeftChild = 2 * inputIndex +1;

        //kurs no berniem ir lielaks
        if(indexLeftChild < elementCount-1 && indexRigthChild < elementCount){
            //1 ja kreisais berns ir lielaks, tad elementu salidzinam ar kreiso bernu
            if(((Comparable)(elements[indexLeftChild])).compareTo(elements[indexRigthChild]) == 1){
                if(((Comparable)(elements[indexLeftChild])).compareTo(elements[inputIndex]) == 1){
                    //1.1 tad mainam kreiso bernu ar pasu elementu un rekursivi izsaucam so funkciju
                    swap(indexLeftChild, inputIndex);
                    reheapDown(indexLeftChild);
                }
            }
            //2 ja labais berns ir lielaks, tad elementu salidzinam ar labo bernu
            else {
                if(((Comparable)(elements[indexRigthChild])).compareTo(elements[inputIndex]) == 1){
                    //2.1 tad mainam labo bernu ar pasu elementu un rekursivi izsaucam so funkciju
                    swap(indexRigthChild, inputIndex);
                    reheapDown(indexRigthChild);
                }
            }
        }
        //vai ir tikai kreisais berns
        else if (indexLeftChild < elementCount && indexRigthChild >= elementCount){
            //if(elements[indexLeftChild] < elements[indexRigthChild]){
            if(((Comparable)(elements[indexLeftChild])).compareTo(elements[indexRigthChild]) == -1){
                swap(inputIndex, indexLeftChild);
            }
        }
    }
    
    //TODO izveidot printesanu rekursivu pec koka apiesanas algoritmu
    public void print() {
        for (int i = 0; i < elementCount; i++){
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }




}
