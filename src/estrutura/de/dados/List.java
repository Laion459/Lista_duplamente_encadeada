package estrutura.de.dados;

public class List {
    private Node head;
    private Node end;
    private int counter;

    public List() {
        criateList();
    }

    public void criateList(){
        head = null;
        end = null;
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    // Métodos Públicos

    // Verifica se está vazia a lista
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }

    // Adiciona elemento na lista
    public void addElement(Object element){
        Node newNode = new Node();
        newNode.setElement(element);
        newNode.setNext(head);
        newNode.setPrevius(end);                // proximo foi alterado
        head = newNode;
        counter++;
    }

    public void proxNode(Node node){
        if (head != null){
            node.setElement(node.getElement());
            node.setNext(node.getNext());
            node.setPrevius(node.getPrevius());
        }
    }

    // Percorre e imprime a lista
    public void showList(){
        for (Node node = head; node != null; node = node.getNext()){
            System.out.println(node.getElement());
        }
    }

    // Procura um elementos da lista
    public Object search(Object element){
        for (Node node = head; node != null; node = node.getNext()){
            if(node.getElement() == element){
                System.out.println("     Elemento SIM existe na lista! ");
                return node.getElement();
            }
        }
        System.out.println("     Elemento NÃO existe na lista! ");
        return null; /* nao achou o elemento*/
    }

    // Recupera numero de elementos da lista
    public int recuperaNumeroDeElementosDaLista(){
        return getCounter();
    }

    // remove um elemnto da lista
    public void removeElementList(Object element){
        //objeto para o elemento previusNode
        Node previusNode = null;
        //objeto para percorrer a lista
        Node positionHead = head;

        //procura elemento na lista, guardando previusNode
        while(positionHead != null && positionHead.getElement() != element){
            previusNode = positionHead;
            positionHead = positionHead.getNext();
        }

        //verifica se achou elemento
        if(positionHead == null){
            /*nao achou: mantem primeiro da forma como esta*/
            return;
        }

        //retira elemento
        if(previusNode == null){
            //retira elemento do inicio
            head = positionHead.getNext();

        }else{
            //retira elemento do meio da lista
            previusNode.setNext(positionHead.getNext());

        }
        counter--;
    }
}
