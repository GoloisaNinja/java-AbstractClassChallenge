public class Main {
    public static void main(String[] args) {
        MyLinkedList cityList = new MyLinkedList(null);
        cityList.traverse(cityList.getRoot());
        String data = "Darwin Brisbane Perth Melbourne Canberra Adalaide Syndey Canberra";
        String[] stringData = data.split(" ");
        for (String city: stringData) {
            cityList.addItem(new Node(city));
        }
        cityList.traverse(cityList.getRoot());

        cityList.addItem(new Node("Binghamton"));
        cityList.addItem(new Node("Scranton"));
        cityList.addItem(new Node("Syracuse"));
        cityList.addItem(new Node("Deposit"));

        System.out.println("=================================");
        cityList.traverse(cityList.getRoot());

        cityList.removeItem(new Node("Deposit"));
        cityList.removeItem(new Node("Canberra"));
        cityList.removeItem(new Node("Wilmington"));
        cityList.removeItem(cityList.getRoot());

        System.out.println("=================================");
        cityList.traverse(cityList.getRoot());
    }
}