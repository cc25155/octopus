package program;



public class Book {
    private int id;
    private String name;
    private Author author;
    private double price;
    private int stock;

    public Book(int id,String name,Author author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(int id,String name, Author author, double price) throws Exception{
        this(id,name,author);
        setPrice(price);
    }

    public Book(int id,String name,Author author, int stock) throws Exception{
        this(id,name,author);
        setStock(stock);
    }

    public Book(int id,String name, Author author,double price, int stock) throws Exception{
        this(id,name,author);
        setPrice(price);
        setStock(stock);
       
    }

    public String getName(){
        return this.name;
    }

    public Author getAuthor(){
        return this.author;
    }

    public double getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public void setPrice(double price) throws Exception{
        if(price > 0.0){
            this.price = price;
        }
        throw new Exception("Valor inválido para preco !");
    }

    public void setStock(int stock) throws Exception{
        if(stock >= 0.0){
            this.stock = stock;
        }
        throw new Exception("Valor inválido para quantidade de estoque !");
    }

    @Override
    public String toString(){
        return String.format("%d - ID\n%s - Nome\n%s - Autor\n%.2f - Preço\n%d - Quantidade em estoque",id,name,author,price,stock);
    }
}
