package pl.edu.wszib.http2.service.model;

import pl.edu.wszib.http2.service.common.CrudResource;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Vocab implements CrudResource<Integer> {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String japanese;

    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String korean;

    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String polish;

    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String english;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
