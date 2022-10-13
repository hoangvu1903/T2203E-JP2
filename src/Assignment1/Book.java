package Assignment1;

public class Book {
    String id;
    String name;
    Integer publish;

    public Book(String id, String name, Integer publish) {
        this.id = id;
        this.name = name;
        this.publish = publish;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return getId()+"-"+getName()+"-"+getPublish();
    }
}