package estrutura.de.dados;

import java.util.Objects;

public class ListDoubly {
    private Node head;
    private Node end;
    private int counter;

    public ListDoubly() {
        criateList();
    }

    public void criateList(){
        head = null;
        end = null;
        counter = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListDoubly)) return false;
        ListDoubly that = (ListDoubly) o;
        return getCounter() == that.getCounter() && Objects.equals(getHead(), that.getHead()) && Objects.equals(getEnd(), that.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead(), getEnd(), getCounter());
    }

    @Override
    public String toString() {
        return "ListDoubly{" +
                "head=" + head +
                ", end=" + end +
                ", counter=" + counter +
                '}';
    }

    // Métodos Públicos

    /**
     * Verifica se está vazia a lista
     * @return true se esta vazia / caso tenha elementos retorna false
     */
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }

    /**
     * Adiciona elemento no inicio da lista
     * @param element objeto a ser adicionado na lista
     */
    public void addStartList(Object element){
        Node node = new Node();
        node.setElement(element);
        node.setPrevius(null);
        node.setNext(head);
        if (head != null){
            head.setPrevius(node);
        }
        head = node;
        if (counter == 0){
            end = head;
        }
        counter++;
    }

    public Object removeStartList(){
        if (head == null){
            return null;
        }
        Object out = head.getElement();
        head = head.getNext();
        if (head != null){
            head.setPrevius(null);
        }else{
            end = null;
        }
        counter--;
        return out;
    }

    public void insertEndList(Object element){
        Node node = new Node();
        node.setElement(element);
        node.setNext(null);
        node.setPrevius(end);
        end = node;
        if (counter == 0){
            head = end;
        }
        counter++;
    }

    public Object removeEndList(){
        if (end == null){
            return null;
        }
        Object out = end.getElement();
        end = end.getPrevius();
        if (end != null){
            end.setNext(null);
        }else{
            head = null;
        }
        counter--;
        return out;
    }

    public void insertInTheMiddle(int index, Object element){
        if (index <= 0){
            addStartList(element);
        } else {
            if (index >= counter){
                insertEndList(element);
            }else {
                Node local = head;
                for (int i = 0; i < index - 1; i++){
                    local = local.getNext();
                }
                Node node = new Node();
                node.setElement(element);
                node.setPrevius(local);
                node.setNext(local.getNext());
                local.setNext(node);
                node.getNext().setNext(node);
                counter++;
            }
        }
    }


    public Object removeInTheMiddle(int index){
        if (index < 0
                || index >= counter
                || head == null){
                    return null;
        } else {
            if (index == 0){
                return removeStartList();
            } else {
                if (index == counter -1) {
                    return removeEndList();
                }
            }
        }
        Node local = head;
        for (int i = 0; i < index; i++){
            local = local.getNext();
        }
        if (local.getPrevius() != null){
            local.getPrevius().setNext(local.getNext());
        }
        if (local.getNext() != null){
            local.getNext().setPrevius(local.getPrevius());
        }
        counter--;
        return local.getElement();
    }

    public boolean search(Object element){
        for (Node node = head; node != null; node = node.getNext()){
            if(node.getElement() == element){
                System.out.println("     Elemento SIM existe na lista! ");
                return true;
            }
        }
        System.out.println("     Elemento NÃO existe na lista! ");
        return false; /* nao achou o elemento*/
    }

    public Object showListDoubly(){
        Object str = "- Elementos na lista: [" + counter + "] \n";
        Node local = head;
        while (local != null){
            str += local.getElement().toString() + "  \n";
            local = local.getNext();
        }
        return str;
    }

    public void newHitList(Object element){
        if (search(element)) {

        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("        #### LISTA DUPLAMENTE ENCADEADA ####");
        System.out.println();
        // Instancia uma lista duplamente encadeada
        ListDoubly listDoubly = new ListDoubly();

        // Verifica se lista esta vazia, Se esta vazia retorna True / caso contrario false
        System.out.println("- 01 Verifica se lista esta vazia?: - (" + listDoubly.isEmpty() + ")");

        // Adiciona elementos na lista
        listDoubly.addStartList("1° ELEMENTO");
        listDoubly.addStartList("2° ELEMENTO");
        listDoubly.addStartList("3° ELEMENTO");
        listDoubly.addStartList("4° ELEMENTO");
        listDoubly.addStartList("5° ELEMENTO");
        listDoubly.addStartList("6° ELEMENTO");

        // Verifica se lista esta vazia, Se esta vazia retorna True / caso contrario false
        System.out.println("- 02 Verifica se lista esta vazia?: - (" + listDoubly.isEmpty() + ")");
        System.out.println();

        // Recupera o numero de elementos da lista
        System.out.println("- 01 Recupera numeros de elementos na lista: - [" + listDoubly.counter + "] Elementos na lista. ");
        listDoubly.addStartList("7° ELEMENTO");
        System.out.println("    'ADICIONADO +1 ELEMENTO NA LISTA' ");
        System.out.println("- 02 Recupera numeros de elementos na lista: - [" + listDoubly.counter + "] Elementos na lista. ");
        System.out.println();

        // Verifica se um elemento existe na lista
        System.out.println("- Verifica se elemento existe na lista: ('5° ELEMENTO')  -");
        listDoubly.search("5° ELEMENTO");
        System.out.println("- Verifica se elemento existe na lista: ('20° ELEMENTO')  -");
        listDoubly.search("20° ELEMENTO");
        System.out.println();

        // Insere um elemento na lista
        System.out.println("- Insere elementos na lista:  -");
        System.out.println("        --> Imprime lista atual: ");
        System.out.println(listDoubly.showListDoubly());
        System.out.println();

        listDoubly.addStartList("99° ELEMENTO");
        listDoubly.addStartList("50° ELEMENTO");
        listDoubly.addStartList("88° ELEMENTO");
        System.out.println("    -> Imprime a lista com novos elementos: ");
        System.out.println(listDoubly.showListDoubly());

        System.out.println("- Retira elementos da lista:  -");
        System.out.println("        --> Imprime lista atual: ");
        System.out.println(listDoubly.showListDoubly());

        listDoubly.removeStartList();
        listDoubly.removeEndList();
        listDoubly.removeInTheMiddle(5);

        System.out.println("        --> Imprime a lista sem os elementos retirados: ");
        System.out.println(listDoubly.showListDoubly());

        // Imprime a lista
        System.out.println("- Imprime os elementos da lista:  -");
        System.out.println(listDoubly.showListDoubly());
    }
}
