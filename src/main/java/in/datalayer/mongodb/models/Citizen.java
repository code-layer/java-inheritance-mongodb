package in.datalayer.mongodb.models;

public class Citizen {
    private Integer _id;
    private String descriminator;
    private String name,passport;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getDescriminator() {
        return descriminator;
    }

    public void setDescriminator(String descriminator) {
        this.descriminator = descriminator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
