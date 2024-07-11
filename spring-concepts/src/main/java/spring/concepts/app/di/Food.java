package spring.concepts.app.di;

public class Food {
    private String code;
    private String type;

    public Food( ) {
    }

    public Food(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public void init() {
        System.out.println("init:Food Created : " + this);
    }

    public void destroy() {
        System.out.println("destroy:Food Destroyed");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Food{" +
                "code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
