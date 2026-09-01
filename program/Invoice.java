package program;

public class Invoice {
    private int id;
    private Customer customer;
    private int nBooks = 0;
    private Book[] books = new Book[1];
    private int[] quantities = new int[1];

    public Invoice(int id,Customer customer) throws Exception{
        setId(id);
        setCustomer(customer);
    }

    private void setId(int id)throws Exception{
        if(id <= 0){
            throw new Exception("O id não pode ser menor ou igual a 0");
        }
        this.id = id;
    }

    private void setCustomer(Customer customer) throws Exception{
        if(customer == null){
            throw new Exception("O cliente não pode ser nulo");
        }
        this.customer = customer;
    }

    public int getId(){
        return this.id;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public boolean addBook(Book book, int quantity){
        int firstEmpty = 0;
        if(book.getStock() < quantity){
            return false;
        }

        for(int i = 0; i < nBooks; i++){
            if(books[i].getName().compareTo(book.getName()) == 0){
                return false;
            }
        }
        
        if(nBooks + 1 >= books.length){
            increaseVectors();
        }

        for(int i = 0; i < nBooks; i++){
            if(books[i] == null){
                firstEmpty = i;
                break;
            }
        }

        books[firstEmpty] = book;
        quantities[firstEmpty] = quantity;
        nBooks++;
        return true;
    }

    public boolean removeBook(Book book){
        for(int i = 0; i < nBooks; i++){
            if(books[i] == null){
                continue;
            }
            if(books[i].getName().compareTo(book.getName()) == 0){
                books[i] = null;
                quantities[i] = 0;
                return true;
            }
        }
        return true;
    }

    public double getTotal(){
        double total = 0;
        for(int i = 0 ; i < nBooks;i++){
            if(books[i] == null){
                continue;
            }
            total += books[i].getPrice()*quantities[i];
        }
        return total;
    }

    public double getTotalAfterDiscount(){
        return getTotal()*customer.getDiscount();
    }

    private void increaseVectors(){
        int newSize = 2*nBooks;
        Book[] temp1 = new Book[newSize];
        int[] temp2 = new int[newSize];

        for(int i = 0; i < nBooks;i++){
            temp1[i] = books[i];
            temp2[i] = quantities[i];
        }

        books = temp1;
        quantities = temp2;
    } 
    
    @Override
    public String toString(){
        return String.format("%d: id; %s: Customer; %.2f: Total",id,customer.toString(),getTotal());
    }
    
    


}
