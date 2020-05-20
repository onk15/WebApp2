package io.github.mat3e;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "languages")
public class Lang
{
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer iD;
    private String message;
    private String code;


    /**
     * Hibernate(JPA) needs it.
     */
@SuppressWarnings("unused")
    Lang() {

    }

    public Lang(Integer iD,String message, String code)
    {
        this.iD = iD;
        this.message = message;
        this.code = code;

    }

    public String getCode() {
        return code;
    }

    public Integer getiD() {
        return iD;
    }

    public String getMessage() {
        return message;
    }

}
