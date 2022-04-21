package estrutura.de.dados;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("        #### LISTA ####");
        System.out.println();
        List list = new List();
        List list1 = new List();

        list.addElement("1° ELEMENTO");
        list.addElement("2° ELEMENTO");
        list.addElement("3° ELEMENTO");
        list.addElement("4° ELEMENTO");
        list.addElement("5° ELEMENTO");
        list.addElement("6° ELEMENTO");
        //list.showList();

        System.out.println("- Verifica se lista 00 está vazia?: " + list.isEmpty());
        System.out.println("- Verifica se lista 01 está vazia?: " + list1.isEmpty());
        System.out.println();

        System.out.println("- Recupera N° de elementos na lista?: " + list.recuperaNumeroDeElementosDaLista() + "° Elementos na lista! ");
        System.out.println();

        System.out.println("- Verifica se elemento existe na lista: ('5° ELEMENTO') ");
        list.search("5° ELEMENTO");
        System.out.println("- Verifica se elemento existe na lista: ('20° ELEMENTO') ");
        list.search("20° ELEMENTO");
        System.out.println();

        System.out.println("- Insere elemento na lista: ('20° ELEMENTO')");
        System.out.println("    Lista sem elemnto: ");
        list.showList();
        list.addElement("20° ELEMENTO");
        System.out.println("+++++++++++++++++++++++++");
        System.out.println();
        System.out.println("    Lista com elemnto: ");
        list.showList();
        System.out.println();

        System.out.println("- Retira elemento da lista: ('20° ELEMENTO') ");
        list.removeElementList("20° ELEMENTO");
        System.out.println("    Lista elemento já removido! ");
        list.showList();
        System.out.println();

        System.out.println("- Imprime a lista: ");
        list.showList();
    }
}
