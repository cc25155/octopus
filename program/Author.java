public class Author {
    private int id;
    private String name;

    public Author(int id,String name){
        setId(id);
        setName(name);
    }

    private void setId(int id){
        if(id < 0){
            throw new Exception("O id não pode ser negativo");
        }
        this.id = id;
    }

    private void setName(String name){
        if(name.isBlank() || name.compareTo("") == 0){
            throw new Exception("O nome não pode ser vazio");
        }
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getString(){
        return this.name;
    }

    @Override
    public String toString(){
        return String.format("%d: Id; %s: Name",id,name);
    }
}
